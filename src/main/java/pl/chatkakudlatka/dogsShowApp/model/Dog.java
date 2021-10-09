package pl.chatkakudlatka.dogsShowApp.model;

import java.util.Date;
import java.util.Set;

public class Dog {
    private Integer id;
    private String callName;
    private String name;
    private Kennel.NamePossition kennelNamePossition;
    private Breed breed;
    private Date birthDay;
    private Sex sex;
    private boolean champion;
    private boolean working;
    private Kennel kennel;
    private Set<Owner> owners;


    private enum Sex {
        BITCH, DOG;
    }
}
