package pages;

import com.codeborne.selenide.SelenideElement;
import models.UserType;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    public SelenideElement
    userNameInput = $("#user-name"),
    userPasswordInput = $("#password"),
    loginButtonInput = $("#login-button"),
    errorMessage = $(".error-button"),
    title = $(".title");

    private final String userPassword = "secret_sauce",
    lockErrorMessage = "Epic sadface: Sorry, this user has been locked out.",
    products = "Products",
    standardUser = "standard_user",
    lockedUser = "locked_out_user";

    public String userName;

    public RegistrationPage openPage() {
        open("");
        return this;
    }

   public RegistrationPage setUserName (UserType userType) {
        if (userType == UserType.STANDARD_USER) {
           userName = standardUser;
       }  else if (userType == UserType.LOCKED_USER) {
           userName = lockedUser;
       } else {
            System.out.println("Пользователь " + userType + " не найден");
            return this;
       }
        userNameInput.setValue(userName);

       return this;
   }

    public RegistrationPage setUserPassword () {

        userPasswordInput.setValue(userPassword);

        return this;
    }

    public RegistrationPage clickLoginButton () {

        loginButtonInput.click();

        return this;
    }

    public RegistrationPage validateErrorMessage (UserType userName) {
        String message;
        if (userName == UserType.LOCKED_USER) {
            message = lockErrorMessage;
        } else {
            System.out.println("Непредвиденная ошибка при авторизации");
            return this;
        }
        errorMessage.parent().shouldHave(text(message));
        return this;
    }

    public RegistrationPage checkRedirectOnTheMainPage (){
        title.shouldHave(text(products));
        return this;
    }


}
