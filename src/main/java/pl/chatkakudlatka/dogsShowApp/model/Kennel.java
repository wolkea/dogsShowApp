package pl.chatkakudlatka.dogsShowApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "kennels")
public class Kennel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String kennelName;

    @Enumerated(EnumType.STRING)
    private Kennel.NamePossition kennelNamePossition;

    @OneToMany(mappedBy = "kennel")
    private Set<Owner> owners;

    @OneToMany(mappedBy = "kennel")
    private Set<Dog> dogs;

    @Getter
    public enum NamePossition {
        FRONT("z przodu"), BACK("z tyłu");

        private final String positionPrint;

        NamePossition(String positionPrint) {
            this.positionPrint = positionPrint;
        }
    }
}
