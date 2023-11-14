package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("remote")
public class StudentRegistrationFormRemoteTests extends RemoteTestBase {

    @Test
    void successfulRegistrationFillAllFieldsTest() {

        registrationFormPage.openPage()
                        .setFirstName(testData.firstName)
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

    }

    @Test
    void successfulRegistrationFillRequiredFieldsTest() {

        registrationFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setUserNumber(testData.userPhone)
                .clickSubmit();

        registrationFormPage.checkResultModalTable("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultModalTable("Student Email", testData.userEmail)
                .checkResultModalTable("Gender", testData.userGender)
                .checkResultModalTable("Mobile", testData.userPhone);
    }

    @Test
    void unsuccessfulRegistrationFillWrongEmailTest() {

        registrationFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userWrongEmail)
                .setGender(testData.userGender)
                .setUserNumber(testData.userPhone)
                .clickSubmit();

        registrationFormPage.checkModalDialogHidden();
    }

    @Test
    void unsuccessfulRegistrationNotFillFormTest() {

        registrationFormPage.openPage()
                .clickSubmit();

        registrationFormPage.checkModalDialogHidden();
    }
}
