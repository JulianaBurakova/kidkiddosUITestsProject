package Pages;
import Consts.Consts;

public class MainPage extends BasePage{

    private static final String LOGIN_ICON = "//a[@class='site-header__account']";
    private static final String LOGO_IMG = "//img[@itemprop = 'logo']";
    private static final String CONTACT_US_OPTION = "//a[text() = 'Contact us']";

    public void navigateToMainPage(){
        webDriver.get(Consts.MAIN_URL);
    }

    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }
    public ContactUsPage openContactUsPage(){
        clickElementByXpath(CONTACT_US_OPTION);
        return new ContactUsPage();
    }
    public LoginPage clickLoginIcon() {
        clickElementByXpath(LOGIN_ICON);
        return new LoginPage();
    }

}

