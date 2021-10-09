package pl.chatkakudlatka.dogsShowApp.model;

public class HelloWord {
    public static void main(String[] args) {


        People ola = new People();
        ola.setFirstName("Ola");
        ola.setAge(25);


//        System.out.println(ola.getBirthYear());
//        System.out.println(ola.czyLiczbaParzysta());
//        System.out.println(ola.czyRokPrzestepny());
//
//        if (ola.czyRokPrzestepny())
//            System.out.println("Rok przestępny");
        print(ola.getBirthYear());
        print(People.getBirthYear(10));


        DogsShow.DogClass juniorBitch = DogsShow.DogClass.JUNIOR_CLASS_BITCH;
        print(juniorBitch.getPrintName());

        print("Wynik:" +juniorBitch.getByGender(false));
    }


    public static void print(Object string){
        System.out.println(string);
    }
}
