package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalTableComponent;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormPage {

    Helpers helper = new Helpers();
    CalendarComponent calendar = new CalendarComponent();
    ModalTableComponent modalTable = new ModalTableComponent();

    SelenideElement titleLabel = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureUploadInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            modalDialog = $(".modal-dialog");

    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
        helper.removeBannersFooter();

        return this;
    }

    public StudentRegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public StudentRegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public StudentRegistrationFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationFormPage uploadPicture(String value) {
        pictureUploadInput.uploadFromClasspath("img/" + value);

        return this;
    }

    public StudentRegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationFormPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationFormPage clickSubmit() {
        submitButton.click();

        return this;
    }

    public StudentRegistrationFormPage checkResultModalTable(String key, String value) {
        modalTable.checkResult(key, value);

        return this;
    }

    public StudentRegistrationFormPage checkModalDialogHidden() {
        modalDialog.shouldBe(hidden);

        return this;
    }
}
