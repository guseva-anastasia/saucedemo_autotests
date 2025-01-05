package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class InventoryPage {

    public static String
    sauceLabsBackpack = "Sauce Labs Backpack",
    sauceLabsBackpackDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
    sauceLabsBikeLight = "Sauce Labs Bike Light",
    sauceLabsBikeLightDescription = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
    sauceLabsBoltTShirt = "Sauce Labs Bolt T-Shirt",
    sauceLabsBoltTShirtDescription = "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
    sauceLabsFleeceJacket = "Sauce Labs Fleece Jacket",
    sauceLabsFleeceJacketDescription = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
    sauceLabsOnesie = "Sauce Labs Onesie",
    sauceLabsOnesieDescription = "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
    sauceLabsRedTShirt = "Test.allTheThings() T-Shirt (Red)",
    sauceLabsRedTShirtDescription = "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
    inventoryItemDescription = ".inventory_item_description";

    public InventoryPage checkTheProductDescription (String productName) {
        String textDescription;
        if (productName == sauceLabsBackpack) {
            textDescription = sauceLabsBackpackDescription;
        } if (productName == sauceLabsBikeLight) {
            textDescription = sauceLabsBikeLightDescription;
        } if (productName == sauceLabsBoltTShirt) {
            textDescription = sauceLabsBoltTShirtDescription;
        } if (productName == sauceLabsFleeceJacket) {
            textDescription = sauceLabsFleeceJacketDescription;
        }  if (productName == sauceLabsOnesie) {
            textDescription = sauceLabsOnesieDescription;
        } if (productName == sauceLabsRedTShirt) {
            textDescription = sauceLabsRedTShirtDescription;
        } else {
            System.out.println("Нет такого товара в магазине");
            return this;
        }

        $(byText(productName)).sibling(1).shouldHave(text(textDescription));

        return this;
    }

    public InventoryPage addProductToCart (String productName) {
        $(byText(productName)).ancestor(inventoryItemDescription).$("button").click();
        return this;
    }

    public InventoryPage checkChangeButtonToRemove (String productName) {
        $(byText(productName)).ancestor(inventoryItemDescription).$("button").shouldHave(text("Remove"));
        return this;
    }

}
