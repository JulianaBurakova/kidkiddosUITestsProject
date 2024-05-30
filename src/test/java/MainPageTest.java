
import Pages.ContactUsPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends UseCaseBase {

    static MainPage mainPage;
    public static final Logger logger = LogManager.getLogger(MainPageTest.class);

    @BeforeAll
    public static void classSetup(){
        mainPage = new MainPage();
    }

    @BeforeEach
    public  void beforeTest(){
        mainPage.navigateToMainPage();
    }

    @Test
    public void mainPageLoadTest() throws IOException {
        logger.info("Main page load test");
        Boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenshot("MainPageTest");
        assertTrue(success);
    }

    @Test
    public void openContactUsPage(){
       ContactUsPage contactUsPage =  mainPage.openContactUsPage();
       boolean isLoaded = contactUsPage.isPageTitleVisible();
       assertTrue(isLoaded);

    }

}

