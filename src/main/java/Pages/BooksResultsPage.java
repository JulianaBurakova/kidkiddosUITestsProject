package Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class BooksResultsPage extends BasePage {

    private static final String BOOKS_BY_LANGUAGE_DROPDOWN = "(//a[@aria-controls='SiteNavLabel-books-by-language'])";
    private static final String ENGLISH_ONLY_OPTION = "(//a[text()='English Only'])";
    private static final String BOOK_ITEM = "//div[@class='grid__item grid__item--collection-template small--one-half medium-up--one-fifth']/div[@class='grid-view-item']/a[@class='grid-view-item__link']";
    public void selectEnglishOnlyBooks() {
        clickElementByXpath(BOOKS_BY_LANGUAGE_DROPDOWN);
        clickElementByXpath(ENGLISH_ONLY_OPTION);
        wait.until(ExpectedConditions.urlContains("english-only"));
    }
    public boolean isEnglishOnlyBooksPageLoaded() {
        String englishOnlyBooksPageIndicator = "//*[contains(text(),'English Only')]";
        return elementExists(englishOnlyBooksPageIndicator);
    }
    public ProductPage selectBook() {
        clickElementByXpath(BOOK_ITEM);
        return new ProductPage();
    }

}
