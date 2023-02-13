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
    Задача №2 -
Отобрать всех животных из Японии (Japanese) и записать породу UPPER_CASE в если пол Female
преобразовать к строкам породы животных и вывести в консоль
     */
    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
        System.out.println("\nЗадача №2 - Отобрать всех животных из Японии (Japanese) " +
                "и записать породу UPPER_CASE в если пол Female преобразовать к строкам " +
                "породы животных и вывести в консоль\n");

        final String ORIGIN = "Japanese";
        final String GENDER = "Female";

        animals.stream()
                .filter(x -> x.getOrigin().equals(ORIGIN) && x.getGender().equals(GENDER))
                .peek(x -> x.setBread(x.getBread().toUpperCase()))
                .forEach(System.out::println);
    }

    /*
    Задача №3 -
Отобрать всех животных старше 30 лет и вывести все страны происхождения без дубликатов начинающиеся на "A"
     */
    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
        System.out.println("\nЗадача №3 - Отобрать всех животных старше 30 лет " +
                "и вывести все страны происхождения без дубликатов начинающиеся на \"A\"\n");

        final int AGE = 30;
        animals.stream()
                .filter(x -> x.getAge() > AGE)
                .map(x->x.getOrigin())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...

    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
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