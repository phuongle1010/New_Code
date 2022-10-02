package Actions.PageObject.techPanda;

import Actions.Common.AbstractPage;
import Interfaces.techPanda.HomePageUserUI;
import org.openqa.selenium.WebDriver;

public class HomePageUserPageObject extends AbstractPage {
    WebDriver driver;

    public HomePageUserPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLinkAccount(){
        waitToClickable(driver, HomePageUserUI.lnkAcc);
        clickToElement(driver, HomePageUserUI.lnkAcc);
    }
    public void clickLinkRegister(String item){
        waitToClickableDynamic(driver, HomePageUserUI.lnkRegister,item);
        clickToElementDynamic(driver, HomePageUserUI.lnkRegister,item);
    }

}
