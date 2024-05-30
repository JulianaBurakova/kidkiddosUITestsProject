package Pages;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private static final String QUANTITY_INPUT = "//input[@name='updates[]']";
    private static final String UPDATE_BUTTON = "//input[@value='Update']";
    private static final String TOTAL_PRICE = "//span[@id='total_price']";

    public void updateQuantity(int quantity) {
        WebElement quantityInput = findElementByXpath(QUANTITY_INPUT);
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));

    }
    public boolean isCartPageOpened() {
        String cartPageIndicator = "//h1[text()='Your cart']";
        return elementExists(cartPageIndicator);
    }
    public void clickUpdate() {
        clickElementByXpath(UPDATE_BUTTON);
    }

}