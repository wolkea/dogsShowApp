package pl.chatkakudlatka.dogsShowApp.model;

public class People {
    private String firstName;
    private String lastName;
    private int age;

    public People() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (this.firstName != null) {
            System.out.println("Nie mozna ponownie ustawić imienia");
            return;
        } else {
            this.firstName = firstName;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        isLeapYear();
    }

    public Integer getBirthYear() {
        return getBirthYear(age);
    }

    boolean czyLiczbaParzysta() {
        return this.getBirthYear() % 2 == 0;
    }

    public boolean czyRokPrzestepny() {
        return ((getBirthYear() % 4 == 0) && (getBirthYear() % 100 != 0)) || (getBirthYear() % 400 == 0);
    }

    public static Integer getBirthYear(Integer myAge) {
        return 2021 - myAge;

    }

    private void isLeapYear() {
        if (czyRokPrzestepny())
            System.out.println(firstName+" Rok przestępny");
    }
}
