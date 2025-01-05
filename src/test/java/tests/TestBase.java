package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void configurationBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWebDriver();
    }
}
