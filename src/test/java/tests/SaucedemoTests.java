package tests;

import models.UserType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.InventoryPage;
import pages.RegistrationPage;

import static models.UserType.*;

public class SaucedemoTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    InventoryPage inventoryPage = new InventoryPage();

    private static final String
    sauceLabsBackpack = "Sauce Labs Backpack",
    sauceLabsBikeLight = "Sauce Labs Bike Light",
    sauceLabsBoltTShirt = "Sauce Labs Bolt T-Shirt",
    sauceLabsFleeceJacket = "Sauce Labs Fleece Jacket",
    sauceLabsOnesie = "Sauce Labs Onesie",
    sauceLabsRedTShirt = "Test.allTheThings() T-Shirt (Red)";



    @EnumSource(UserType.class)
    @DisplayName("Авторизация выбранным польльзователем")
    @ParameterizedTest()
    void authorizationAnyUserTest(UserType userType) {
        registrationPage
                .openPage()
                .setUserName(userType)
                .setUserPassword()
                .clickLoginButton();
        if (userType == STANDARD_USER) {
            registrationPage
                    .checkRedirectOnTheMainPage();
        } else {
            registrationPage
                    .validateErrorMessage(userType);
        }
    }

    @ValueSource(strings = {sauceLabsBackpack,sauceLabsBikeLight,sauceLabsBoltTShirt,sauceLabsFleeceJacket,sauceLabsOnesie,sauceLabsRedTShirt})
    @DisplayName("Проверить описание у товара")
    @ParameterizedTest()
    void checkTheProductDescriptionTest(String productName) {
        registrationPage
                .openPage()
                .setUserName(STANDARD_USER)
                .setUserPassword()
                .clickLoginButton();
        inventoryPage
                .checkTheProductDescription(productName);

    }

    @ValueSource(strings = {sauceLabsBackpack,sauceLabsBikeLight,sauceLabsBoltTShirt,sauceLabsFleeceJacket,sauceLabsOnesie,sauceLabsRedTShirt})
    @DisplayName("Добавить товар в корзину")
    @ParameterizedTest()
    void addProductToCardTest(String productName) {
        registrationPage
                .openPage()
                .setUserName(STANDARD_USER)
                .setUserPassword()
                .clickLoginButton();
        inventoryPage
                .addProductToCart(productName)
                .checkChangeButtonToRemove(productName);
    }

}
