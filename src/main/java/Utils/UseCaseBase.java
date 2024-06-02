package Utils;

import Pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class UseCaseBase {

    public static WebDriver webDriver;
    protected static BasePage page;

    @BeforeAll
    public static void setupMain(){
        page = new BasePage();
        webDriver = SharedDriver.getWebDriver(SharedDriver.Browser.CHROME);
        WebDriverManager.chromedriver().clearDriverCache().setup();
        page.setWebDriver(webDriver);
    }

    @AfterAll
    public static void tearDownMain(){
        SharedDriver.closeDriver();
        webDriver = null;

    }

}