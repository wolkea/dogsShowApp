package pl.chatkakudlatka.dogsShowApp.model;

import java.util.ArrayList;
import java.util.List;

public enum DogShowClass {
    MINOR_PUPPY_CLASS_DOG("Klasa młodsze szczenie (Pies)", false),
    PUPPY_CLASS_DOG("Klasa szczenie (Pies)", false),
    JUNIOR_CLASS_DOG("Klasa młodzieży (Pies)", false),
    INTERMEDIATE_CLASS_DOG("Klasa pośrednia (Pies)", false),
    OPEN_CLASS_DOG("Klasa otwarta (Pies)", false),
    WORKING_CLASS_DOG("Klasa użytkowa (Pies)", false),
    CHAMPION_CLASS_DOG("Klasa championów (Pies)", false),
    VETERAN_CLASS_DOG("Klasa weteranów (Pies)", false),
    MINOR_PUPPY_CLASS_BITCH("Klasa młodsze szczenie (Suka)", true),
    PUPPY_CLASS_BITCH("Klasa szczenie (Suka)", true),
    JUNIOR_CLASS_BITCH("Klasa młodzieży (Suka)", true),
    INTERMEDIATE_CLASS_BITCH("Klasa pośrednia (Suka)", true),
    OPEN_CLASS_BITCH("Klasa otwarta (Suka)", true),
    WORKING_CLASS_BITCH("Klasa użytkowa (Suka)", true),
    CHAMPION_CLASS_BITCH("Klasa championów (Suka)", true),
    VETERAN_CLASS_BITCH("Klasa weteranów (Suka)", true);

    private final String printName;
    private final boolean isBitch;

    private DogShowClass(String name, boolean isBitch) {
        this.isBitch = isBitch;
        this.printName = name;
    }

    public String getPrintName() {
        return printName;
    }

    public boolean isBitch() {
        return isBitch;
    }

    public List<Integer> nmbers() {
        Integer[] myIntArray = new Integer[]{1, 2, 3,2};
        List<Integer> returnList = new ArrayList<>();

        for (int i = 0; i < myIntArray.length; i++) {
            Integer integer = myIntArray[i];
            if (integer == 2) {
                returnList.add(integer);
            }
        }
        return returnList;
    }

    public List<DogShowClass> getByGender(boolean isBitch) {
        DogShowClass[] allDogClasses = DogShowClass.values();
        List<DogShowClass> returnList = new ArrayList<>();
        for (int i = 0; i < allDogClasses.length; i++) {
            DogShowClass currentDogClass = allDogClasses[i];
            if (currentDogClass.isBitch() == isBitch){
                returnList.add(currentDogClass);
            }
        }
        return returnList;
    }
}