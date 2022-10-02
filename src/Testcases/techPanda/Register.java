package Testcases.techPanda;

import Actions.Common.AbstractTest;
import Actions.PageObject.techPanda.HomePageAdminPageObject;
import Actions.PageObject.techPanda.HomePageUserPageObject;
import Actions.PageObject.techPanda.LoginAdminPageObject;
import Actions.PageObject.techPanda.RegisterUserPageObject;
import Interfaces.techPanda.HomePageAdminUI;
import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Register extends AbstractTest {
    WebDriver driver;
    HomePageAdminPageObject homePageAdminPageObject;
    HomePageUserPageObject homePageUserPageObject;
    RegisterUserPageObject registerUserPageObject;
    LoginAdminPageObject loginAdminPageObject;
    String email, name;
    int number;


    @Parameters({"browsers", "url"})
    @BeforeClass
    public void beforeClass(String browsers, String url) {
        driver = getBrowser(browsers, url);
        homePageAdminPageObject = new HomePageAdminPageObject(driver);
        homePageUserPageObject = new HomePageUserPageObject(driver);
        registerUserPageObject = new RegisterUserPageObject(driver);
        loginAdminPageObject = new LoginAdminPageObject(driver);
        email = generatorEmail();
        number = generatorNumber();
    }

    @Test
    public void TC_01_Register() {
        homePageUserPageObject.clickLinkAccount();
        homePageUserPageObject.clickLinkRegister("Register");
        registerUserPageObject.inputValue("firstname", "wanda");
        registerUserPageObject.inputValue("lastname", "2000");
        registerUserPageObject.inputValue("email_address", email);
        registerUserPageObject.inputValue("password", "123456a");
        registerUserPageObject.inputValue("confirmation", "123456a");
        registerUserPageObject.clickSubmit("Register");
    }

    @Test
    public void TC_02_LoginAdminPage() {
        loginAdminPageObject.openAdminPage();
        loginAdminPageObject.inputValue("username", "user01");
        loginAdminPageObject.inputValue("login", "guru99com");
        loginAdminPageObject.clickSubmit();
    }

    @Test
    public void TC_03_SearchUser() {
        homePageAdminPageObject.clickCloseIcon();
        loginAdminPageObject.inputValue("customerGrid_filter_email", email);
        registerUserPageObject.clickSubmit("Search");
        registerUserPageObject.sleep(2);
        //Assert.assertEquals(homePageAdminPageObject.verifyItem("wanda 2000"),"wanda 2000");
        Assert.assertEquals(homePageAdminPageObject.verifyItem(email), email);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
