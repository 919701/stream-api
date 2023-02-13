package by.sergeev;

import by.sergeev.model.*;
import by.sergeev.util.Util;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
    }

    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    /*
    Задача №2 - Отобрать всех животных из Японии (Japanese) и записать породу UPPER_CASE
     если пол Female преобразовать к строкам породы животных и вывести в консоль
     */
    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
        System.out.println("\nTask number 2 - Select all animals from Japan (Japanese) " +
                "and write the breed UPPER_CASE if the gender is Female, 7" +
                "convert to animal breed strings and output to the console\n");

        final String BY_ORIGIN = "Japanese";
        final String BY_GENDER = "Female";

        animals.stream()
                .filter(x -> x.getOrigin().equals(BY_ORIGIN))
                .filter(x->x.getGender().equals(BY_GENDER))
                .peek(x -> x.setBread(x.getBread().toUpperCase()))
                .forEach(System.out::println);
    }

    /*
    Задача №3 - Отобрать всех животных старше 30 лет и вывести все страны происхождения без дубликатов начинающиеся на "A"
     */
    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
        System.out.println("\nTask #3 - Select all animals over 30 years old " +
                "and display all countries of origin without duplicates starting with \"A\"");

        final int BY_AGE = 30;
        final char BY_FIRST_CHAR = 'A';

        animals.stream()
                .filter(x -> x.getAge() > BY_AGE)
                .filter(x -> x.getOrigin().toUpperCase().charAt(0) == BY_FIRST_CHAR)
                .map(x -> x.getOrigin())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /*
    Задача №4 - Подсчитать количество всех животных пола = Female. Вывести в консоль
     */
    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
        System.out.println("\nTask number 4 - Count the number of all animals of gender = Female. Output to console.");

        final String BY_GENDER = "Female";
        long count = animals.stream()
                .filter(x -> x.getGender().equals(BY_GENDER))
                .count();
        System.out.println("Number of all sex animals " + BY_GENDER + " = " + count);

    }

    /*
    Задача №5 - Взять всех животных возрастом 20 - 30 лет.
    Есть ли среди них хоть один из страны Венгрия (Hungarian)?
    Ответ вывести в консоль.
     */
    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
        System.out.println("\nTask number 5 - Take all animals aged 20 - 30 years. " +
                "Are there any of them from Hungary (Hungarian)?" +
                "Output the answer to the console.");

        final String BY_ORIGIN = "Hungarian";
        final int MIN_AGE = 20;
        final int MAX_AGE = 30;

        boolean isOrigin = animals.stream()
                .filter(x -> x.getAge() >= MIN_AGE && x.getAge() <= MAX_AGE)
                .allMatch(x -> x.getOrigin().toUpperCase().equals(BY_ORIGIN.toUpperCase()));

        System.out.printf("In this country '%s' animals between %d and %d age : %b", BY_ORIGIN, MIN_AGE, MAX_AGE, isOrigin);
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
//        Продолжить...
    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
        //        Продолжить...
    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
        //        Продолжить...
    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        //        Продолжить...
    }
}