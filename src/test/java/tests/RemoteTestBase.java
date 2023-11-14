package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginInBookStorePage;
import pages.StudentRegistrationFormPage;
import pages.TextBoxPage;

import java.util.Map;


public class RemoteTestBase {

    StudentRegistrationFormPage registrationFormPage = new StudentRegistrationFormPage();
    LoginInBookStorePage loginInBookStorePage = new LoginInBookStorePage();
    TextBoxPage textBoxPage = new TextBoxPage();

    TestData testData = new TestData();
    TestDataBookStore testDataBookStore = new TestDataBookStore();

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
