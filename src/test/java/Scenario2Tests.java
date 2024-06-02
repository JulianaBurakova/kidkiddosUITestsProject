import Pages.BooksResultsPage;
import Pages.CartPage;
import Pages.MainPage;
import Pages.ProductPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Scenario2Tests extends UseCaseBase {

    private MainPage mainPage;
    private BooksResultsPage booksResultsPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeEach
    public void beforeTest() {
        mainPage = new MainPage();
        mainPage.navigateToMainPage();
        booksResultsPage = new BooksResultsPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
    }

    @Test
    public void testNavigateToHomePage() {
        mainPage = new MainPage();
        assertTrue(mainPage.isLogoVisible());
    }

    @Test
    public void testSelectEnglishOnlyBooks() {
        booksResultsPage.selectEnglishOnlyBooks();
        assertTrue(booksResultsPage.isEnglishOnlyBooksPageLoaded());

    }

    @Test
    public void testSelectBook() {
        booksResultsPage.selectEnglishOnlyBooks();
        productPage = booksResultsPage.selectBook();
        assertTrue(productPage.isProductPageLoaded());
        productPage.selectHardcoverFormat();
        productPage.setQuantity(5);
        assertEquals(5, productPage.getQuantity());
    }

    @Test
    public void testAddToCart() {
        booksResultsPage.selectEnglishOnlyBooks();
        productPage = booksResultsPage.selectBook();
        cartPage = productPage.addToCart();
        assertTrue(cartPage.isCartPageOpened());
    }
    @Test
    public void testUpdateQuantityInCart() {
        booksResultsPage.selectEnglishOnlyBooks();

        productPage = booksResultsPage.selectBook();

        cartPage = productPage.addToCart();
        double priceOfBook = productPage.getPriceOfBook();
        cartPage.updateQuantity(6);

        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0, document.body.scrollHeight)");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        cartPage.clickUpdate();

        assertEquals(6, cartPage.getQuantity());
        double expectedTotalPrice = priceOfBook * cartPage.getQuantity();
        assertEquals(expectedTotalPrice, cartPage.getTotalPrice(), "The total price is not updated correctly.");
    }

}


