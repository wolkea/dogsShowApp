package pl.chatkakudlatka.dogsShowApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Setter
@Getter
@Entity
@Table(name = "dog")

public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String callName;
    private String name;

    @ManyToOne (cascade = CascadeType.ALL)
    private Breed breed;

    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Enumerated(EnumType.STRING)
    private DogSex sex;
    private boolean champion;
    private boolean working;

    @ManyToOne (cascade = CascadeType.ALL)
    private Kennel kennel;

    @ManyToMany(mappedBy = "dogs", cascade = CascadeType.ALL)
    private Set<Owner> owners;


}
