package by.sergeev;

import by.sergeev.model.*;
import by.sergeev.util.Util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

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
        out.println("\nTask 1:");

        List<Animal> animals = Util.getAnimals();
        final int MIN_AGE = 10;
        final int MAX_AGE = 20;

        animals.stream()
                .filter(animal -> animal.getAge() >= MIN_AGE && animal.getAge() < MAX_AGE)
                .sorted(comparing(Animal::getAge))
                .skip(14)
                .limit(7)
                .forEach(out::println);
    }

    /*
    Задача №2
     - Отобрать всех животных из Японии (Japanese) и записать породу UPPER_CASE
     если пол Female преобразовать к строкам породы животных и вывести в консоль
     */
    private static void task2() throws IOException {
        out.println("\nTask 2:");

        List<Animal> animals = Util.getAnimals();
        final String BY_ORIGIN = "Japanese";
        final String BY_GENDER = "Female";

        animals.stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase(BY_ORIGIN))
                .filter(animal -> animal.getGender().equalsIgnoreCase(BY_GENDER))
                .peek(animal -> animal.setBread(animal.getBread().toUpperCase()))
                .forEach(out::println);
    }

    /*
    Задача №3
     - Отобрать всех животных старше 30 лет и вывести все страны происхождения без дубликатов начинающиеся на "A"
     */
    private static void task3() throws IOException {
        out.println("\nTask 3:");

        List<Animal> animals = Util.getAnimals();
        final int BY_AGE = 30;
        final char BY_FIRST_CHAR = 'A';

        animals.stream()
                .filter(animal -> animal.getAge() > BY_AGE)
                .map(Animal::getOrigin)
                .filter(origin -> origin.toUpperCase().charAt(0) == BY_FIRST_CHAR)
                .distinct()
                .sorted()
                .forEach(out::println);
    }

    /*
    Задача №4
     - Подсчитать количество всех животных пола = Female. Вывести в консоль
     */
    private static void task4() throws IOException {
        out.println("\nTask 4:");

        List<Animal> animals = Util.getAnimals();
        final String BY_GENDER = "Female";

        long count = animals.stream()
                .filter(animal -> animal.getGender().equalsIgnoreCase(BY_GENDER))
                .count();

        out.println("Number of all sex animals " + BY_GENDER + " = " + count);

    }

    /*
    Задача №5
    - Взять всех животных возрастом 20 - 30 лет. Есть ли среди них хоть один из страны Венгрия (Hungarian)?
    Ответ вывести в консоль.
     */
    private static void task5() throws IOException {
        out.println("\nTask 5:");

        List<Animal> animals = Util.getAnimals();
        final String BY_ORIGIN = "Hungarian";
        final int MIN_AGE = 20;
        final int MAX_AGE = 30;

        boolean isOrigin = animals.stream()
                .filter(animal -> animal.getAge() >= MIN_AGE && animal.getAge() <= MAX_AGE)
                .allMatch(animal -> animal.getOrigin().equalsIgnoreCase(BY_ORIGIN));

        out.printf("In this country '%s' animals between %d and %d age : %b\n", BY_ORIGIN, MIN_AGE, MAX_AGE, isOrigin);
    }

    /*
    Задача №6
    -Взять всех животных. Все ли они пола Male или Female ? Ответ вывести в консоль.
     */
    private static void task6() throws IOException {
        out.println("\nTask 6:");

        List<Animal> animals = Util.getAnimals();

        final boolean isGender = animals.stream()
                .allMatch(animal -> animal.getGender().equalsIgnoreCase("Male")
                        || animal.getGender().equalsIgnoreCase("Female"));

        out.println("Are all animals Male or Female? " + isGender);
    }

    /*
    Задача №7
    -Взять всех животных. Узнать что ни одно из них
    не имеет страну происхождения Oceania. Ответ вывести в консоль.
     */
    private static void task7() throws IOException {
        out.println("\nTask 7:");

        List<Animal> animals = Util.getAnimals();
        final String BY_COUNTRY = "Oceania";

        boolean anyMatchAnimals = animals.stream()
                .anyMatch(animal -> animal.getOrigin().equalsIgnoreCase(BY_COUNTRY));

        out.printf("Is there any animal that lives in %s? %b\n", BY_COUNTRY, anyMatchAnimals);
    }

    /*
    Задача №8
    - Взять всех животных. Отсортировать их породу в стандартном порядке и взять первые 100.
    Вывести в консоль возраст самого старого животного.
     */
    private static void task8() throws IOException {
        out.println("\nTask 8:");

        List<Animal> animals = Util.getAnimals();
        final int COUNT = 100;

        animals.stream()
                .sorted(comparing(Animal::getBread))
                .limit(COUNT)
                .mapToInt(Animal::getAge)
                .max()
                .ifPresent(age -> out.printf("Age of oldest animal = %d\n", age));
    }

    /*
    Задача №9
    - Взять всех животных. Преобразовать их в породы, а породы в []char.
    Вывести в консоль длину самого короткого массива.
     */
    private static void task9() throws IOException {
        out.println("\nTask 9:");

        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .min(comparing(ch -> ch.length))
                .ifPresent(ch -> out.println("Length of the shortest array: " + ch.length));

    }

    /*
    Задача №10
    - Взять всех животных. Подсчитать суммарный возраст всех животных. Вывести результат в консоль.
     */
    private static void task10() throws IOException {
        out.println("\nTask 10:");

        List<Animal> animals = Util.getAnimals();

        long sumAge = animals.stream()
                .mapToLong(Animal::getAge)
                .sum();

        out.printf("The total age of all animals = %d age\n", sumAge);
    }

    /*
    Задача №11
    - Взять всех животных. Подсчитать средний возраст всех животных из индонезии (Indonesian). Вывести результат в консоль.
     */
    private static void task11() throws IOException {
        out.println("\nTask number 11:");

        List<Animal> animals = Util.getAnimals();
        final String BY_COUNTRY = "Indonesian";

        animals.stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase(BY_COUNTRY))
                .mapToInt(Animal::getAge)
                .average()
                .ifPresent(age -> out.printf("Average age of all animals from %s: %.2f\n", BY_COUNTRY, age));
    }

    /*
    Задача №12 -
    Во Французский легион принимают людей со всего света, но есть отбор по полу (только мужчины)
    возраст от 18 до 27 лет. Преимущество отдаётся людям военной категории 1, на втором месте - военная категория 2,
    и на третьем месте военная категория 3. Отсортировать всех подходящих кандидатов в порядке их
    приоритета по военной категории. Однако взять на обучение академия может только 200 человек. Вывести их в консоль.
     */
    private static void task12() throws IOException {
        out.println("\nTask 12:");

        List<Person> people = Util.getPersons();
        final String BY_GENDER = "Male";
        final int MIN_AGE = 18;
        final int MAX_AGE = 27;
        final int COUNT_PERSON = 200;

        people.stream()
                .filter(p -> p.getGender().equalsIgnoreCase(BY_GENDER))
                .filter(age -> ChronoUnit.YEARS.between(age.getDateOfBirth(), LocalDate.now()) >= MIN_AGE)
                .filter(age -> ChronoUnit.YEARS.between(age.getDateOfBirth(), LocalDate.now()) <= MAX_AGE)
                .sorted(comparing(Person::getRecruitmentGroup))
                .limit(COUNT_PERSON)
                .forEach(out::println);
    }

    /*
    Задача №13 -
    Надвигается цунами и в районе эвакуации требуется в первую очередь обойти дома и эвакуировать больных и раненых
    (из Hospital), во вторую очередь детей и стариков (до 18 и пенсионного возраста), а после всех остальных.
    В первый этап эвакуации мест в эвакуационном транспорте только 500.
    Вывести всех людей попадающих в первый этап эвакуации в порядке приоритета (в консоль).
     */
    private static void task13() throws IOException {
        out.println("\nTask 13:");

        List<House> houses = Util.getHouses();
        final String BY_FIRST_QUEUE = "Hospital";
        final int CHILDREN_AGE = 18;
        final int MALE_RETIREMENT_AGE = 65;
        final int FEMALE_RETIREMENT_AGE = 58;
        final int COUNT_EVACUATION_PLACES = 500;

        Map<Boolean, List<Person>> persons = houses.stream()
                .collect(partitioningBy(house -> house.getBuildingType().equalsIgnoreCase(BY_FIRST_QUEUE),
                        flatMapping(house -> house.getPersonList().stream(), toList())));
        List<Person> secondEvocuation = persons.get(false).stream()
                .filter(person -> ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) < CHILDREN_AGE
                        || (ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) >= FEMALE_RETIREMENT_AGE
                        && person.getGender().equalsIgnoreCase("Female"))
                        || (ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) >= MALE_RETIREMENT_AGE
                        && person.getGender().equalsIgnoreCase("Male")))
                .toList();

        persons.get(false).removeAll(secondEvocuation);
        persons.get(true).addAll(secondEvocuation);
        persons.get(true).addAll(persons.get(false));
        List<Person> evocuationList = persons.get(true).subList(0, COUNT_EVACUATION_PLACES);

        evocuationList.forEach(out::println);
    }

    /*
    Задача №14 -
Из перечня автомобилей приходящих на рынок Азии логистическому агентству предстоит отсортировать их в порядке следования
1.Туркменистан(TM) - 2.Узбекистан(UZ) - 3.Казахстан(KZ) - 4.Кыргызстан(KIZ) - 5.Россия(RU) - 6.Монголия(MN).
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
        out.println("\nTask 14:");

        List<Car> eschelon1 = cars.stream()
                .filter(car -> car.getCarMake().equalsIgnoreCase("Jaguar")
                        || car.getColor().equalsIgnoreCase("White"))
                .toList();
        int totalMass1 = eschelon1.stream().map(Car::getMass).reduce(Integer::sum).orElse(0);

        List<Car> eschelon2 = cars.stream()
                .filter(car -> car.getMass() < 1500)
                .filter(car -> car.getCarMake().equalsIgnoreCase("BMW")
                        || car.getCarMake().equalsIgnoreCase("Lexus")
                        || car.getCarMake().equalsIgnoreCase("Chrysler")
                        || car.getCarMake().equalsIgnoreCase("Toyota"))
                .toList();

        List<Car> eschelon3 = cars.stream()
                .filter(car -> (car.getColor().equalsIgnoreCase("Black") && car.getMass() > 4000)
                        || car.getCarMake().equalsIgnoreCase("GMC")
                        || car.getCarMake().equalsIgnoreCase("Dodge"))
                .toList();

        List<Car> eschelon4 = cars.stream()
                .filter(car -> car.getReleaseYear() < 1982
                        || car.getCarModel().equalsIgnoreCase("Civic")
                        || car.getCarModel().equalsIgnoreCase("Cherokee"))
                .toList();

        List<Car> eschelon5 = cars.stream()
                .filter(car -> (!"Yellow".equalsIgnoreCase(car.getColor())
                        && !car.getColor().equalsIgnoreCase("Red")
                        && !car.getColor().equalsIgnoreCase("Green")
                        && !car.getColor().equalsIgnoreCase("Blue"))
                        || car.getPrice() > 40_000)
                .toList();

        List<Car> eschelon6 = cars.stream()
                .filter(car -> car.getVin().contains("59"))
                .toList();

        List<Integer> eschelonMass = Stream.of(eschelon1, eschelon2, eschelon3, eschelon4, eschelon5, eschelon6)
                .map(esch -> esch.stream()
                        .map(Car::getMass)
                        .reduce(Integer::sum)
                        .orElse(0))
                .toList();
//        Double totalMass = eschelonMass.stream().;

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
        out.println("\nTask 15:");
        final int SETTLEMENT_PERIOD = 5 * 365;
        final double WATER_COAST = 1.39d;

        double coastFlower = flowers.stream()
                .sorted(comparing(Flower::getOrigin).reversed())
                .sorted(comparing(Flower::getPrice))
                .sorted(comparing(Flower::getWaterConsumptionPerDay))
                .filter(flower -> String.valueOf(flower.getCommonName().charAt(0)).matches("[C-S]"))
                .filter(flower -> flower.isShadePreferred()
                        && (flower.getFlowerVaseMaterial().contains("Class")
                        || flower.getFlowerVaseMaterial().contains("Aluminium")
                        || flower.getFlowerVaseMaterial().contains("Steel")))
                .mapToDouble(flower -> flower.getPrice()
                        + flower.getWaterConsumptionPerDay()
                        * SETTLEMENT_PERIOD * WATER_COAST)
                .sum();

        out.printf("Maintenance cost of all plants: $ %.2f ", coastFlower);
    }
}