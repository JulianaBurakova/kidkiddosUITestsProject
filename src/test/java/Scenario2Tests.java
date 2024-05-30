import Pages.BooksResultsPage;
import Pages.CartPage;
import Pages.MainPage;
import Pages.ProductPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        cartPage.updateQuantity(6);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        cartPage.clickUpdate();
    }

}


