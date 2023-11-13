package tests;

import org.junit.jupiter.api.Test;


public class LoginInBookStoreTests extends TestBase {

    @Test
    void successfulLogin() {
        loginInBookStorePage.openPage()
                .setUserName(testDataBookStore.userName)
                .setPassword(testDataBookStore.userPassword)
                .clickLogin()
                .checkRedirectToPage(testDataBookStore.pageProfile);

    }

    @Test
    void unsuccessfulLoginWithWrongUserName() {
        loginInBookStorePage.openPage()
                .setUserName(testDataBookStore.wrongUserName)
                .setPassword(testDataBookStore.userPassword)
                .clickLogin()
                .checkMessageInvalidLogin();

    }

    @Test
    void unsuccessfulLoginWithWrongPassword() {
        loginInBookStorePage.openPage()
                .setUserName(testDataBookStore.userName)
                .setPassword(testDataBookStore.wrongPassword)
                .clickLogin()
                .checkMessageInvalidLogin();

    }

    @Test
    void unsuccessfulLoginWithEmptyFields() {
        loginInBookStorePage.openPage()
                .setUserName("")
                .setPassword("")
                .clickLogin()
                .checkInvalidUserName()
                .checkInvalidPassword();

    }

    @Test
    void unsuccessfulLoginWithEmptyUserName() {
        loginInBookStorePage.openPage()
                .setUserName("")
                .setPassword(testDataBookStore.userPassword)
                .clickLogin()
                .checkInvalidUserName();

    }

    @Test
    void unsuccessfulLoginWithEmptyPassword() {
        loginInBookStorePage.openPage()
                .setUserName(testDataBookStore.userName)
                .setPassword("")
                .clickLogin()
                .checkInvalidPassword();
    }
}
