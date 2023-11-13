package pages;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Helpers {
    void removeBannersFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
