package pl.chatkakudlatka.dogsShowApp.auth;

import lombok.*;
import pl.chatkakudlatka.dogsShowApp.model.Owner;
import pl.chatkakudlatka.dogsShowApp.model.OwnerDetails;

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
    String email;

    String password;

    @ManyToMany
    private Set<Role> roles;

    @OneToOne (cascade = CascadeType.ALL)
    private Owner owner;

    public boolean isManager() {
        return roles.stream().anyMatch(roles -> roles.getName().equals("MANAGER"));
    }
}
