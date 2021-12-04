package pl.chatkakudlatka.dogsShowApp.model;

import lombok.Getter;

@Getter
public enum FCIGroup {
    FCI_1(1, "Grupa 1", "Group 1", "Owczarki i inne psy pasterskie, z wyłączeniem szwajcarskich psów do bydła", "Sheepdogs and Cattledogs (except Swiss Cattledogs)"),
    FCI_2(2, "Grupa 2", "Group 2", "", ""),
    FCI_3(3, "Grupa 3", "Group 3", "", ""),
    FCI_4(4, "Grupa 4", "Group 4", "", ""),
    FCI_5(5, "Grupa 5", "Group 5", "", ""),
    FCI_6(6, "Grupa 6", "Group 6", "", ""),
    FCI_7(7, "Grupa 7", "Group 7", "", ""),
    FCI_8(8, "Grupa 8", "Group 8", "", ""),
    FCI_9(9, "Grupa 9", "Group 9", "", ""),
    FCI_10(10, "Grupa 10", "Group 10", "", ""),
    FCI_UNCATEGORISED(null, "Grupa nieuznana", "Group uncategorised", "", "");

    private final Integer number;
    private final String groupNamePl;
    private final String groupNameEn;
    private final String fullNamePl;
    private final String fullNameEn;

    FCIGroup(Integer number, String groupNamePl, String groupNameEn, String fullNamePl, String fullNameEn) {
        this.number = number;
        this.groupNamePl = groupNamePl;
        this.groupNameEn = groupNameEn;
        this.fullNamePl = fullNamePl;
        this.fullNameEn = fullNameEn;
    }
}
