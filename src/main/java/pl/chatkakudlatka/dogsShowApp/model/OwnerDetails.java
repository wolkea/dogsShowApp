package pl.chatkakudlatka.dogsShowApp.model;

import javax.persistence.*;

@Entity
@Table(name = "owner_details")
public class OwnerDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne (cascade = CascadeType.ALL)
    private Owner owner;
    private Integer pesel;
    private Integer ownerIBAN;
    private String adres;
    private Integer phoneNumber;

}
