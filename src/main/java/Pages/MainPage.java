package Pages;

import Consts.Consts;

public class MainPage extends BasePage{

   private static final String LOGO_IMG = "//img[@itemprop = 'logo']";

    public void navigateToMainPage(){
        webDriver.get(Consts.MAIN_URL);
    }

    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }
}

