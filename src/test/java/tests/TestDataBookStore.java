package tests;

import utils.RandomUtils;

public class TestDataBookStore {
    RandomUtils randomData = new RandomUtils();

    public String userName = "Chupakabra",
            userPassword = "Pass1234_*",
            wrongUserName = randomData.getRandomUserName(),
            wrongPassword = randomData.getRandomPassword(20),
            pageProfile = "Profile";
}
