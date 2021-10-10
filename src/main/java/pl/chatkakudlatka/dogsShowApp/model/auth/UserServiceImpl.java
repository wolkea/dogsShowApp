package pl.chatkakudlatka.dogsShowApp.model.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RolesRepository rolesRepository;


    @Override
    @Transactional()
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User  user  = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username is not in database");
        }

        Set<GrantedAuthority> grantedAuthorities =
                user.getRoles().stream()
                        .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName()))
                        .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    public void save(User user) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
    }

    public Iterable getAllUsersNamesAndTheirRoles() {
        return userRepository.findAll().stream().map(user -> {
            User tmpUser = new User();
            tmpUser.setUsername(user.getUsername());
            tmpUser.setRoles(user.getRoles());
            return tmpUser;
        }).collect(Collectors.toList());
    }


    public User getLoggedInUser() {
        Optional<User> user = null;
        try {
            org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            user = Optional.ofNullable(userRepository.findByUsername(principal.getUsername()));
            return user.get();
        } catch (Exception e) {
            return null;
        }
    }

    public void changeUserPassword(String username, String password) {
        User loggedInUser = getLoggedInUser();
        if (loggedInUser.isManager()) {
            User user = userRepository.findByUsername(username);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            userRepository.save(user);
        } else if(loggedInUser.getUsername().equals(username)) {
            loggedInUser.setPassword(bCryptPasswordEncoder.encode(password));
            userRepository.save(loggedInUser);
        }
    }

    public List<User> getAllUserList() {
        if (getLoggedInUser().isManager()) {
            return userRepository.findAll();
        }
        ArrayList<User> singleUser = new ArrayList<>();
        singleUser.add(getLoggedInUser());
        return  singleUser;
    }



}
