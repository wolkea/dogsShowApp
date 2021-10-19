package pl.chatkakudlatka.dogsShowApp.model.auth;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String username;
    String fullName;
    String email;

    String password;

    @ManyToMany
    private Set<Role> roles;

    public boolean isManager() {
        return roles.stream().anyMatch(roles -> roles.getName().equals("MANAGER"));
    }
}
