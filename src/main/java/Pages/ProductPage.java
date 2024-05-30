package Pages;

import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    private static final String FORMAT_DROPDOWN = "//select[@id='SingleOptionSelector-0']";
    private static final String HARDCOVER_OPTION = "//option[text()='Paperback']";
    private static final String QUANTITY_INPUT = "//input[@id='Quantity']";
    private static final String ADD_TO_CART_BUTTON = "//button[@id='AddToCart-product-template']";

    public void selectHardcoverFormat() {
        clickElementByXpath(FORMAT_DROPDOWN);
        clickElementByXpath(HARDCOVER_OPTION);
    }

    public void setQuantity(int quantity) {
        WebElement quantityInput = findElementByXpath(QUANTITY_INPUT);
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }
    public boolean isProductPageLoaded() {
        String productPageIndicator = "//*[contains(text(),'I Love to Eat')]";
        return elementExists(productPageIndicator);
    }

    public int getQuantity() {
        WebElement quantityInput = findElementByXpath(QUANTITY_INPUT);
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }
    public CartPage addToCart() {
        clickElementByXpath(ADD_TO_CART_BUTTON);
        return new CartPage();
    }
}
