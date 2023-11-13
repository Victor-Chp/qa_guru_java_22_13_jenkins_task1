package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginInBookStorePage {

    Helpers helper = new Helpers();

    SelenideElement titleLabel = $(".main-header"),
        userName = $("#userName"),
        password = $("#password"),
        loginButton = $("#login"),
        invalidLoginMessage = $("#name"),
        invalidUserName = $("#userName.is-invalid"),
        invalidPassword = $("#password.is-invalid"),
        logOutButton = $("#submit");

    public LoginInBookStorePage openPage() {
        open("/login");
        helper.removeBannersFooter();
        titleLabel.shouldHave(text("Login"));

        return this;
    }

    public LoginInBookStorePage setUserName(String value) {
        userName.setValue(value);

        return this;
    }

    public LoginInBookStorePage setPassword(String value) {
        password.setValue(value);

        return this;
    }

    public LoginInBookStorePage clickLogin() {
        loginButton.click();

        return this;
    }

    public LoginInBookStorePage checkRedirectToPage(String value) {
        titleLabel.shouldHave(text(value));

        return this;
    }

    public LoginInBookStorePage checkMessageInvalidLogin() {
        invalidLoginMessage.shouldHave(text("Invalid username or password!"));

        return this;
    }

    public LoginInBookStorePage checkInvalidUserName() {
        invalidUserName.shouldBe(visible);

        return this;
    }

    public LoginInBookStorePage checkInvalidPassword() {
        invalidPassword.shouldBe(visible);

        return this;
    }

    public LoginInBookStorePage clickLogOut() {
        logOutButton.shouldHave(text("Log out"));
        logOutButton.click();

        return this;
    }
}
