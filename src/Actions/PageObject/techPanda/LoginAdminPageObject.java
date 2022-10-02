package Actions.PageObject.techPanda;

import Actions.Common.AbstractPage;
import Interfaces.techPanda.LoginAdminUI;
import org.openqa.selenium.WebDriver;

public class LoginAdminPageObject extends AbstractPage {
    WebDriver driver;

    public LoginAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputValue(String item, String valueInput){
        waitToVisibleDynamic(driver, LoginAdminUI.txtItem,item);
        sendKeysToElementDynamic(driver, LoginAdminUI.txtItem,valueInput,item);
    }
    public void clickSubmit(){
        waitToClickable(driver,LoginAdminUI.btnLogin);
        clickToElement(driver,LoginAdminUI.btnLogin);
    }
    public void openAdminPage(){
        openURL(driver,"http://live.techpanda.org/index.php/backendlogin");

    }
}
