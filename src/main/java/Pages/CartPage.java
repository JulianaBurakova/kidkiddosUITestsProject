package Pages;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private static final String QUANTITY_INPUT = "//input[@name='updates[]']";
    private static final String UPDATE_BUTTON = "//input[@name='update' and @type='submit' and contains(@class, 'btn') and contains(@class, 'cart__update') and contains(@class, 'small--hide')]";
    private static final String TOTAL_PRICE = "//span[@class='cart__subtotal']";

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


    public int getQuantity() {
        WebElement quantityInput = findElementByXpath(QUANTITY_INPUT);
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }
    public double getTotalPrice() {
        WebElement totalPriceElement = findElementByXpath(TOTAL_PRICE);
        return Double.parseDouble(totalPriceElement.getText().replace("$", "").replace("CAD", ""));
    }

}