package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public Faker fakerUS = new Faker(new Locale("en-US"));
    public Faker fakerRU = new Faker(new Locale("ru"));


    public String getRandomFirstName() {
        return fakerRU.name().firstName();
    }

    public String getRandomLastNAme() {
        return fakerRU.name().lastName();
    }

    public String getRandomEmail() {
        return fakerUS.internet().emailAddress();
    }
    public String getRandomWrongEmail() {return fakerUS.internet().emailAddress("!@#$%^&*}{:");}

    public String getRandomPhone() {
        return String.valueOf(fakerUS.number().randomNumber(10, true));
    }

    public Map<String, String> getRandomDateOfBirth() {
        Date date = fakerUS.date().birthday(16, 90);
        Map<String, String> dateOfBirth = new HashMap<>();
        dateOfBirth.put("day", new SimpleDateFormat("dd").format(date));
        dateOfBirth.put("month", new SimpleDateFormat("MMMM", Locale.US).format(date));
        dateOfBirth.put("year", new SimpleDateFormat("yyyy").format(date));

        return dateOfBirth;
    }

    public String getRandomAddress() {
        return fakerRU.address().fullAddress();
    }

    public String getRandomKeyFromMap(Map<String, String[]> map) {
        Set<String> statesSet = map.keySet();
        int n = statesSet.size();

        String[] statesArray = new String[n];
        statesArray = statesSet.toArray(statesArray);
        int index = getRandomInt(0, statesArray.length - 1);

        return statesArray[index];
    }

    public String getRandomPassword(int min) {
        return fakerUS.internet().password(min, 1024);
    }

    public String getRandomUserName() {
        return fakerUS.name().username();
    }

    public String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
