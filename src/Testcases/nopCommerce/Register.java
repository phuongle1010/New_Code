package Testcases.nopCommerce;

import Actions.Common.AbstractTest;
import Actions.PageObject.nopCommerce.EditAccountPageObject;
import Actions.PageObject.nopCommerce.HomePagePageObject;
import Actions.PageObject.nopCommerce.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Register extends AbstractTest {
    WebDriver driver;
    RegisterPageObject registerPageObject;
    HomePagePageObject homePagePageObject;
    EditAccountPageObject editAccountPageObject;

    @Parameters({"browsers", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowser(browserName, url);
        registerPageObject = new RegisterPageObject(driver);
        homePagePageObject = new HomePagePageObject(driver);
        editAccountPageObject = new EditAccountPageObject(driver);
    }

    @Test
    public void TC_01_Register() {
        homePagePageObject.clicklnkRegister("Register");
        registerPageObject.inputFirstname("Khoamama");
        registerPageObject.inputLastname("cancer");
        registerPageObject.inputEmail(generatorEmail());
        registerPageObject.inputPassword("123456a");
        registerPageObject.inputConfirmPassword("123456a");
        registerPageObject.clickRegister();
        homePagePageObject.clicklnkLogout();
    }

    @Test
    public void TC_02_EditAcc() {
        homePagePageObject.clickMyAcc();
        editAccountPageObject.clickMenu("Orders");
        editAccountPageObject.clickMenu("Change password");
        editAccountPageObject.clickMenu("Addresses");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
