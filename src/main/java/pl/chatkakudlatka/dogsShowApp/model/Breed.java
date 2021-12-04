package pl.chatkakudlatka.dogsShowApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter

@Entity
@Table(name = "breeds")
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private FCIGroup fciGroup;
    @OneToMany(mappedBy="breed")
    private Set<Dog> dogs;
}
