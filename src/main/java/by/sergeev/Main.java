package by.sergeev;

import by.sergeev.model.*;
import by.sergeev.util.Util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

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

    /*
    Задача №1
    - Из представленных животных отобрать все молодые особи от 10 до 20 лет
     и отсортировать по возрасту (по возрастанию) далее - распределить по 7 на каждый зоопарк.
     Зоопарков неограниченное кол-во,а вы - директор 3-го по счёту зоопарка.
     Полученных животных вывести в консоль.
     */
    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
        final int MIN_AGE = 10;
        final int MAX_AGE = 20;

        out.println("\nTask 1:");
        animals.stream().filter(x -> x.getAge() >= MIN_AGE && x.getAge() < MAX_AGE).sorted(Comparator.comparing(Animal::getAge)).skip(14).limit(7).forEach(out::println);
    }

    /*
    Задача №2
     - Отобрать всех животных из Японии (Japanese) и записать породу UPPER_CASE
     если пол Female преобразовать к строкам породы животных и вывести в консоль
     */
    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        final String BY_ORIGIN = "Japanese";
        final String BY_GENDER = "Female";

        out.println("\nTask 2:");

        animals.stream().filter(x -> BY_ORIGIN.equalsIgnoreCase(x.getOrigin())).filter(x -> BY_GENDER.equalsIgnoreCase(x.getGender())).peek(x -> x.setBread(x.getBread().toUpperCase())).forEach(out::println);
    }

    /*
    Задача №3
     - Отобрать всех животных старше 30 лет и вывести все страны происхождения без дубликатов начинающиеся на "A"
     */
    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        final int BY_AGE = 30;
        final char BY_FIRST_CHAR = 'A';

        out.println("\nTask 3:");

        animals.stream().filter(x -> BY_AGE < x.getAge()).filter(x -> BY_FIRST_CHAR == x.getOrigin().toUpperCase().charAt(0)).map(x -> x.getOrigin()).distinct().sorted().forEach(out::println);
    }

    /*
    Задача №4
     - Подсчитать количество всех животных пола = Female. Вывести в консоль
     */
    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        final String BY_GENDER = "Female";

        out.println("\nTask number 4:");

        long count = animals.stream().filter(x -> BY_GENDER.equalsIgnoreCase(x.getGender())).count();
        out.println("Number of all sex animals " + BY_GENDER + " = " + count);

    }

    /*
    Задача №5
    - Взять всех животных возрастом 20 - 30 лет. Есть ли среди них хоть один из страны Венгрия (Hungarian)?
    Ответ вывести в консоль.
     */
    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        final String BY_ORIGIN = "Hungarian";
        final int MIN_AGE = 20;
        final int MAX_AGE = 30;

        out.println("\nTask number 5:");

        boolean isOrigin = animals.stream().filter(x -> MIN_AGE <= x.getAge() && MAX_AGE >= x.getAge()).allMatch(x -> x.getOrigin().equalsIgnoreCase(BY_ORIGIN));

        out.printf("In this country '%s' animals between %d and %d age : %b\n", BY_ORIGIN, MIN_AGE, MAX_AGE, isOrigin);
    }

    /*
    Задача №6
    -Взять всех животных. Все ли они пола Male или Female ? Ответ вывести в консоль.
     */
    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();

        out.println("\nTask number 6:");

        final boolean isGender = animals.stream().allMatch(x -> "Male".equalsIgnoreCase(x.getGender()) || "Female".equalsIgnoreCase(x.getGender()));

        out.println("Are all animals Male or Female? Answer: " + isGender);
    }

    /*
    Задача №7
    -Взять всех животных. Узнать что ни одно из них
    не имеет страну происхождения Oceania. Ответ вывести в консоль.
     */
    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        final String BY_COUNTRY = "Oceania";

        out.println("\nTask number 7:");

        boolean anyMatchAnimals = animals.stream().anyMatch(x -> BY_COUNTRY.equalsIgnoreCase(x.getOrigin()));

        out.printf("Is there any animal that lives in %s? %b\n", BY_COUNTRY, anyMatchAnimals);
    }

    /*
    Задача №8
    - Взять всех животных. Отсортировать их породу в стандартном порядке и взять первые 100.
    Вывести в консоль возраст самого старого животного.
     */
    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
        final int COUNT = 100;

        out.println("\nTask number 8:");

        animals.stream().sorted(Comparator.comparing(Animal::getBread)).limit(100).mapToInt(Animal::getAge).max().ifPresent(age -> out.printf("Age of oldest animal = %d\n", age));
    }

    /*
    Задача №9
    - Взять всех животных. Преобразовать их в породы, а породы в []char.
    Вывести в консоль длину самого короткого массива.
     */
    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();

        out.println("\nTask number 9:");

        animals.stream().map(Animal::getBread).map(String::toCharArray).min(Comparator.comparing(ch -> ch.length)).ifPresent(ch -> out.println("Length of the shortest array: " + ch.length));

    }

    /*
    Задача №10
    - Взять всех животных. Подсчитать суммарный возраст всех животных. Вывести результат в консоль.
     */
    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
        out.println("\nTask number 10:");

        long sumAge = animals.stream().mapToLong(Animal::getAge).sum();

        out.printf("The total age of all animals = %d age\n", sumAge);
    }

    /*
    Задача №11
    - Взять всех животных. Подсчитать средний возраст всех животных из индонезии (Indonesian). Вывести результат в консоль.
     */
    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
        final String BY_COUNTRY = "Indonesian";

        out.println("\nTask number 11:");

        animals.stream().filter(x -> BY_COUNTRY.equalsIgnoreCase(x.getOrigin())).mapToInt(Animal::getAge).average().ifPresent(age -> out.printf("Average age of all animals from %s: %.2f\n", BY_COUNTRY, age));
    }

    /*
    Задача №12 -
    Во Французский легион принимают людей со всего света, но есть отбор по полу (только мужчины)
    возраст от 18 до 27 лет. Преимущество отдаётся людям военной категории 1, на втором месте - военная категория 2,
    и на третьем месте военная категория 3. Отсортировать всех подходящих кандидатов в порядке их
    приоритета по военной категории. Однако взять на обучение академия может только 200 человек. Вывести их в консоль.
     */
    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
        final String BY_GENDER = "Male";
        final int MIN_AGE = 18;
        final int MAX_AGE = 27;
        final int COUNT_PERSON = 200;

        out.println("\nTask number 12:");
        people.stream()
                .filter(p -> BY_GENDER.equalsIgnoreCase(p.getGender()))
                .filter(age -> MIN_AGE <= ChronoUnit.YEARS.between(age.getDateOfBirth(), LocalDate.now()))
                .filter(age -> MAX_AGE >= ChronoUnit.YEARS.between(age.getDateOfBirth(), LocalDate.now()))
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(COUNT_PERSON)
                .forEach(out::println);
    }

    /*
    Задача №13 -
    Надвигается цунами и в районе эвакуации требуется в первую очередь обойти дома и эвакуировать больных и раненых (из Hospital),
    во вторую очередь детей и стариков (до 18 и пенсионного возраста) а после всех остальных. В первый этап эвакуации мест
    в эвакуационном транспорте только 500. Вывести всех людей попадающих в первый этап эвакуации в порядке приоритета (в консоль).
     */
    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
        out.println("\nTask number 13:");

        out.println("NULL");
    }

    /*
    Задача №14 -
Из перечня автомобилей приходящих на рынок Азии логистическому агентству предстоит отсортировать их в порядке следования
1.Туркменистан - 2.Узбекистан - 3.Казахстан - 4.Кыргызстан - 5.Россия - 6.Монголия.
Все автомобили марки "Jaguar" а так же все авто цвета White идут в первую страну.
Из оставшихся все автомобили с массой до 1500 кг и марок BMW, Lexus, Chrysler и Toyota идут во второй эшелон.
Из оставшихся все автомобили Черного цвета с массой более 4000 кг и все GMC и Dodge идут в третий эшелон.
Из оставшихся все автомобили года выпуска до 1982 или все модели "Civic" и "Cherokee" идут в четвёртый эшелон.
Из оставшихся все автомобили цветов НЕ Yellow, Red, Green и Blue или же по стоимости дороже 40000 в пятый эшелон
Из оставшиеся все автомобили в vin номере которых есть цифра "59" идут в последний шестой эшелон.
Оставшиеся автомобили отбрасываем, они никуда не идут.
Измерить суммарные массы автомобилей всех эшелонов для каждой из стран и подсчитать сколько для каждой страны
будет стоить транспортные расходы если учесть что на 1 тонну транспорта будет потрачено 7.14 $.
Вывести суммарные стоимости в консоль. Вывести общую выручку логистической кампании.
     */
    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
        out.println("\nTask number 14:");

        out.println("NULL");
    }

    /*
    Задача №15 -
    Для оранжереи нужно подобрать растения соответствующие требованиям.
    Во-первых, нужно произвести сложную сортировку каталога растений. Отсортировать их по странам происхождения в обратном порядке
    После по стоимости и еще по водопотреблению в обратном порядке. Из этого списка взять растения название которых
    от буквы "S" до буквы "C". Если растения тенелюбивые и им подходит горшок из стекла, алюминия или стали - то выбираем их.
    Далее на каждое растение надо рассчитать стоимость растения + стоимость потребления воды за 5 лет c учётом того
    что кубометр воды стоит 1.39 $. Суммировать общую стоимость обслуживания всех растений. Во сколько это обойдётся бюджету?
     */
    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        out.println("\nTask number 15:");

        out.println("NULL");
    }
}