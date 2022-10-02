package Actions.PageObject.techPanda;

import Actions.Common.AbstractPage;
import Interfaces.techPanda.RegisterUserUI;
import org.openqa.selenium.WebDriver;

public class RegisterUserPageObject extends AbstractPage {
    WebDriver driver;

    public RegisterUserPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void inputValue(String item,String valueInput){
        waitToVisibleDynamic(driver, RegisterUserUI.txtItem, item);
        sendKeysToElementDynamic(driver, RegisterUserUI.txtItem,valueInput,item);
    }
    public void clickSubmit(String item){
        waitToClickableDynamic(driver,RegisterUserUI.btnSubmit,item);
        clickToElementDynamic(driver,RegisterUserUI.btnSubmit,item);
    }
}
