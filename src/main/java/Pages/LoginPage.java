package Pages;
import Consts.Consts;

public class LoginPage extends BasePage{

    public static final String LOGIN_HEADER = "//h1[text()='Login']";
    private static final String EMAIL_FIELD = "//input[@id='CustomerEmail']";
    private static final String PASSWORD_FIELD = "//input[@id='CustomerPassword']";
    private static final String LOGIN_BUTTON = "//*[@value='Sign In']";
    private static final String ERROR_MESSAGE = "//div[@class='errors']";


    public void navigateToLoginPage() {
        webDriver.get(Consts.LOGIN_URL);
    }

    public void login(String username, String password) {
        sendTextToElementByXpath(EMAIL_FIELD, username);
        sendTextToElementByXpath(PASSWORD_FIELD, password);
        clickElementByXpath(LOGIN_BUTTON);
    }
    public boolean isLoginPageOpened() {
        return elementExists(LOGIN_HEADER);
    }

    public void enterUsername(String username) {
        sendTextToElementByXpath(EMAIL_FIELD, username);
    }

    public void enterPassword(String password) {
        sendTextToElementByXpath(PASSWORD_FIELD, password);
    }

    public void clickLoginButton() {
        clickElementByXpath(LOGIN_BUTTON);
    }

    public String getErrorMessage() {
        return findElementByXpath(ERROR_MESSAGE).getText();
    }

}



