package pl.chatkakudlatka.dogsShowApp.model;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Wpisz pierwszą liczbę:");
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        System.out.println("Wpisz drugą:");
        int second = scanner.nextInt();
        System.out.println("Wpisz trzecią:");
        int third = scanner.nextInt();
        int sum = sum(first, second, third);
        int sum2 = sum(first, second);
        System.out.println("Wynikiem dodania wszystkich trzech jest: " + sum);
        System.out.println("A wynikiem dodanie tylko pierwszej i drugiej to:" + sum2);






    }

    private static int sum(int first, int second, int third) {
        return first + second + third;
    }

    private static int sum(int first, int second) {
        return first + second;
    }

}
