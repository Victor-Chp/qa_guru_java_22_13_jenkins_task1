package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    Helpers helper = new Helpers();

    String outputLocator = "#output";
    SelenideElement titleLabel = $(".main-header"),
        userNameInput = $("#userName"),
        userEmailInput = $("#userEmail"),
        currentAddressInput = $("#currentAddress"),
        permanentAddressInput = $("#permanentAddress"),
        submitButton = $("#submit"),
        outputField = $(outputLocator),
        outputName = $(outputLocator + " #name"),
        outputEmail = $(outputLocator + " #email"),
        outputCurrentAddress = $(outputLocator + " #currentAddress"),
        outputPermanentAddress = $(outputLocator + " #permanentAddress"),
        invalidEmail = $("#userEmail.field-error");

    public TextBoxPage openPage() {
        open("/text-box");
        titleLabel.shouldHave(text("Text Box"));
        helper.removeBannersFooter();

        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage clickSubmit() {
        submitButton.click();

        return this;
    }

    public TextBoxPage checkResultOutput(String name, String email, String currentAddress, String permanentAddress) {
        outputName.shouldHave(exactText("Name:" + name));
        outputEmail.shouldHave(exactText("Email:" + email));
        outputCurrentAddress.shouldHave(exactText("Current Address :" + currentAddress));
        outputPermanentAddress.shouldHave(exactText("Permananet Address :" + permanentAddress));

        return this;
    }

    public TextBoxPage checkInvalidEmail() {
        invalidEmail.shouldBe(visible);

        return this;
    }

    public TextBoxPage checkOutputFieldIsEmpty() {
        outputField.shouldBe(empty);

        return this;
    }
}
