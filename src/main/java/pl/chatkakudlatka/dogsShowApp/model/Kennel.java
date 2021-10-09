package pl.chatkakudlatka.dogsShowApp.model;

import java.util.Set;

public class Kennel {
    private Integer id;
    private String kennelName;
    private Set<Owner> owners;


    public enum NamePossition {
        FRONT, BACK;
    }
}
