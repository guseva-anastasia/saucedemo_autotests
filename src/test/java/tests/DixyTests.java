package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import models.Categories;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DixyTests extends TestBase{


    @DisplayName("Проверить элементы подкатегории каталога продуктов")
    @ParameterizedTest()
    @MethodSource("checkCategoriesItem")
    void checkListOfProductElementsTest(Categories categories,List<String> subcategories) {

        open("https://dixy.ru/");
        if ($(".onboarding-card visible").is(visible)); {
            $(".onboarding-card__close").click();
        }
            $(".header-mobile_menu").sibling(1).click();
            $$(".item.first-level .item-link.dedicated").findBy(partialText(categories.description)).hover();
            $$(".item.first-level.active  .item-content  .wrapper .item-link").shouldHave(texts(subcategories));

    }

    static Stream<Arguments> checkCategoriesItem() {
        return Stream.of(
                Arguments.of(
                        Categories.VEGETABLES_AND_FRUITS,
                        List.of("Грибы","Зелень и салаты","Наша марка","Овощи","Фрукты","Экзотика","Ягоды")
              ),
                Arguments.of(
                        Categories.CHEESE,
                        List.of("Мягкие, копченые сыры", "Наша Марка", "Плавленый сыр",
                               "Сырная нарезка", "Сыры","Сыры для гурманов", "Сыры на любой вкус", "Сыры с плесенью", "Твёрдые сыры", "Творожный сыр")
             ),
               Arguments.of(
                       Categories.MILK_EGGS,
                       List.of("Наша Марка", "Йогурты и творожки", "Молоко", "Яйцо", "Мороженое","Сырки и десерты","Для детей", "Творог" , "Майонез", "Масло и маргарин", "Питьевые йогурты", "Сметана", "Кефир и ряженка", "Сливки", "Сгущенное молоко", "Молочные коктейли, напитки", "Веганские напитки", "Чистый протеин", "Безлактозный уголок", "Натуральный вкус", "Греческие йогурты")
               )
        );
    }
}
