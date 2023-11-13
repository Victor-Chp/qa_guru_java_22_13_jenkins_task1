package tests;

import utils.RandomUtils;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    RandomUtils randomData = new RandomUtils();

    public String[] genders = {"Male", "Female", "Other"},
            subjects = {"English", "Physics", "Chemistry", "Computer Science", "Commerce", "Arts",
                    "Math", "Accounting", "Economics", "Social Studies", "Civics", "Chemistry"},
            hobbies = {"Sports", "Reading", "Music"},
            pictures = {"account1.png", "account2.jpg", "account3.png"};

    public Map<String, String[]> statesCities = new HashMap<String, String[]>(); {
        statesCities.put("NCR", (new String[]{"Delhi", "Gurgaon", "Noida"}));
        statesCities.put("Uttar Pradesh", (new String[]{"Agra", "Lucknow", "Merrut"}));
        statesCities.put("Haryana", (new String[]{"Karnal", "Panipat"}));
        statesCities.put("Rajasthan", (new String[]{"Jaipur", "Jaiselmer"}));
    }


    public String firstName = randomData.getRandomFirstName(),
            lastName = randomData.getRandomLastNAme(),
            userEmail = randomData.getRandomEmail(),
            userWrongEmail = randomData.getRandomWrongEmail(),
            userGender = randomData.getRandomItemFromArray(genders),
            userPhone = randomData.getRandomPhone(),
            dayOfBirth = randomData.getRandomDateOfBirth().get("day"),
            monthOfBirth = randomData.getRandomDateOfBirth().get("month"),
            yearOfBirth = randomData.getRandomDateOfBirth().get("year"),
            subject = randomData.getRandomItemFromArray(subjects),
            hobby = randomData.getRandomItemFromArray(hobbies),
            picture = randomData.getRandomItemFromArray(pictures),
            address = randomData.getRandomAddress(),
            permanentAddress = randomData.getRandomAddress(),
            state = randomData.getRandomKeyFromMap(statesCities),
            city = randomData.getRandomItemFromArray(statesCities.get(state));

}
