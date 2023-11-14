package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("remote")
public class StudentRegistrationFormRemoteTests extends RemoteTestBase {

    @Test
    @DisplayName("Successful Registration - Fill All Fields")
    void successfulRegistrationFillAllFieldsTest() {
        step("Open form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.userEmail)
                    .setGender(testData.userGender)
                    .setUserNumber(testData.userPhone)
                    .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                    .setSubjects(testData.subject)
                    .setHobbies(testData.hobby)
                    .uploadPicture(testData.picture)
                    .setAddress(testData.address)
                    .setState(testData.state)
                    .setCity(testData.city)
                    .clickSubmit();
        });
        step("Verify results", () -> {
            registrationFormPage.checkResultModalTable("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResultModalTable("Student Email", testData.userEmail)
                    .checkResultModalTable("Gender", testData.userGender)
                    .checkResultModalTable("Mobile", testData.userPhone)
                    .checkResultModalTable("Date of Birth",
                            String.format("%s %s,%s", testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth))
                    .checkResultModalTable("Subjects", testData.subject)
                    .checkResultModalTable("Hobbies", testData.hobby)
                    .checkResultModalTable("Picture", testData.picture)
                    .checkResultModalTable("Address", testData.address)
                    .checkResultModalTable("State and City", testData.state + " " + testData.city);
        });
    }

    @Test
    @DisplayName("Successful Registration - Fill Required Fields")
    void successfulRegistrationFillRequiredFieldsTest() {
        step("Open form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.userEmail)
                    .setGender(testData.userGender)
                    .setUserNumber(testData.userPhone)
                    .clickSubmit();
        });
        step("Verify results", () -> {
            registrationFormPage.checkResultModalTable("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResultModalTable("Student Email", testData.userEmail)
                    .checkResultModalTable("Gender", testData.userGender)
                    .checkResultModalTable("Mobile", testData.userPhone);
        });
    }

    @Test
    @DisplayName("Unsuccessful Registration - Fill Wrong Email")
    void unsuccessfulRegistrationFillWrongEmailTest() {
        step("Open form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.userWrongEmail)
                    .setGender(testData.userGender)
                    .setUserNumber(testData.userPhone)
                    .clickSubmit();
        });
        step("Verify results", () -> {
            registrationFormPage.checkModalDialogHidden();
        });
    }

    @Test
    @DisplayName("Unsuccessful Registration - Not Fill Form")
    void unsuccessfulRegistrationNotFillFormTest() {
        step("Open form and click Submit", () -> {
            registrationFormPage.openPage()
                    .clickSubmit();
        });
        step("Modal dialog should be hidden", () -> {
            registrationFormPage.checkModalDialogHidden();
        });
    }
}
