package Actions.PageObject.techPanda;

import Actions.Common.AbstractPage;
import Interfaces.techPanda.HomePageAdminUI;
import org.openqa.selenium.WebDriver;

public class HomePageAdminPageObject extends AbstractPage {
    WebDriver driver;

    public HomePageAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickCloseIcon(){
        waitToClickable(driver, HomePageAdminUI.iconClose);
        clickToElement(driver,HomePageAdminUI.iconClose);
    }
    public String verifyItem(String email){
        return getTextDynamic(driver,HomePageAdminUI.lblItem, email);
    }
}

