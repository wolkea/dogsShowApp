package pl.chatkakudlatka.dogsShowApp.model;

import java.util.Date;

public class RingDetails {
    private Integer id;
    private Breed breed;
    private FCIGroup fciGroup;
    private Integer ringId;
    private Date showDate;
    private String judge;
    private Show_Rank showRank;



    public enum Show_Rank{
        CWC,CACIB
    }
}
