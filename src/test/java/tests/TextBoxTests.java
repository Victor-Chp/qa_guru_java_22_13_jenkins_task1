package tests;

import org.junit.jupiter.api.Test;


public class TextBoxTests extends TestBase {

    @Test
    void successfulFillAllFields() {

        textBoxPage.openPage()
                .setUserName(testData.firstName + " " + testData.lastName)
                .setUserEmail(testData.userEmail)
                .setCurrentAddress(testData.address)
                .setPermanentAddress(testData.permanentAddress)
                .clickSubmit();

//        $("#output #name").shouldHave(exactText("Nicolay Tolstoy"));
        textBoxPage.checkResultOutput(
                testData.firstName + " " + testData.lastName,
                testData.userEmail,
                testData.address,
                testData.permanentAddress);

    }

    @Test
    void unsuccessfulFillWithWrongEmail() {
        textBoxPage.openPage()
                .setUserName(testData.firstName + " " + testData.lastName)
                .setUserEmail(testData.userWrongEmail)
                .setCurrentAddress(testData.address)
                .setPermanentAddress(testData.permanentAddress)
                .clickSubmit();

        textBoxPage.checkInvalidEmail();
    }

    @Test
    void unsuccesfulEmptyFields() {
        textBoxPage.openPage()
                .setUserName("")
                .setUserEmail("")
                .setCurrentAddress("")
                .setPermanentAddress("")
                .clickSubmit();

        textBoxPage.checkOutputFieldIsEmpty();
    }
}
