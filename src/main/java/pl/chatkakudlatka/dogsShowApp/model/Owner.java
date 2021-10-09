package pl.chatkakudlatka.dogsShowApp.model;

import java.util.Set;

public class Owner {
    private Integer id;
    private String lastName;
    private String firstName;
    private Language language = Language.POLISH;
    private Set<Dog> dogs;
    private Kennel kennel;
    private OwnerDetails ownerDetails;
}
