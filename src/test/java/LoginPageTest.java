import Pages.LoginPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest  extends UseCaseBase {
    private static MainPage mainPage;
    private static LoginPage loginPage;

    @BeforeAll
    public static void classSetup(){
        mainPage = new MainPage();
        loginPage = new LoginPage();
    }
    @BeforeEach
    public void beforeTest(){
        mainPage.navigateToMainPage();
    }

    @Test
    public void loginIconOpensLoginPageTest() {
        loginPage = mainPage.clickLoginIcon();
        assertTrue(loginPage.isLoginPageOpened());
    }

    @Test
    public void emptyUsernameAndPasswordTest() {
        loginPage = mainPage.clickLoginIcon();
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        assertEquals("Incorrect email or password.", loginPage.getErrorMessage());
    }

    @Test
    public void incorrectUsernameAndPasswordTest() {
        loginPage = mainPage.clickLoginIcon();
        loginPage.enterUsername("123456@gmail");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
        assertEquals("Incorrect email or password.", loginPage.getErrorMessage());
    }
}
