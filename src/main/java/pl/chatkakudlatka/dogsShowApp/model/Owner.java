package pl.chatkakudlatka.dogsShowApp.model;

import lombok.Getter;
import lombok.Setter;
import pl.chatkakudlatka.dogsShowApp.auth.User;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lastName;
    private String firstName;

    @Enumerated(EnumType.STRING)
    private Language language = Language.POLISH;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Dog> dogs;

    @ManyToOne(cascade = CascadeType.ALL)
    private Kennel kennel;

    @OneToOne (cascade = CascadeType.ALL)
    private OwnerDetails ownerDetails;

    @OneToOne (cascade = CascadeType.ALL)
    private User user;
}
