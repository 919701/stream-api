package by.sergeev.util;

import by.sergeev.model.Animal;
import by.sergeev.model.Car;
import by.sergeev.model.Flower;
import by.sergeev.model.House;
import by.sergeev.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class Util {
    public static final String ANIMALS_DATA_FILE_NAME = "src/main/resources/animals.json";
    public static final String RECRUITS_DATA_FILE_NAME = "src/main/resources/recruits.json";
    public static final String CARS_DATA_FILE_NAME = "src/main/resources/cars.json";
    public static final String FLOWERS_DATA_FILE_NAME = "src/main/resources/flowers.json";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static List<Animal> getAnimals() throws IOException {
        return newMapper().readValue(new File(ANIMALS_DATA_FILE_NAME), new TypeReference<>() {
        });
    }

    public static List<Person> getPersons() throws IOException {
        return newMapper().readValue(new File(RECRUITS_DATA_FILE_NAME), new TypeReference<>() {
        });
    }

    public static List<Car> getCars() throws IOException {
        return newMapper().readValue(new File(CARS_DATA_FILE_NAME), new TypeReference<>() {
        });
    }

    public static List<Flower> getFlowers() throws IOException {
        return newMapper().readValue(new File(FLOWERS_DATA_FILE_NAME), new TypeReference<>() {
        });
    }

    public static List<House> getHouses() throws IOException {
        List<Person> personList = getPersons();
        return List.of(
            new House(1, "Hospital", personList.subList(0, 40)),
            new House(2, "Civil building", personList.subList(41, 141)),
            new House(3, "Civil building", personList.subList(142, 200)),
            new House(4, "Civil building", personList.subList(201, 299)),
            new House(5, "Civil building", personList.subList(300, 399)),
            new House(6, "Civil building", personList.subList(400, 499)),
            new House(7, "Civil building", personList.subList(500, 599)),
            new House(8, "Civil building", personList.subList(600, 699)),
            new House(9, "Civil building", personList.subList(700, 799)),
            new House(9, "Civil building", personList.subList(800, 899)),
            new House(9, "Civil building", personList.subList(900, 999))
        );
    }

    private static ObjectMapper newMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(DATE_FORMAT);
        mapper.setLocale(Locale.ENGLISH);
        mapper.registerModule(new JSR310Module());
        return mapper;
    }
}
