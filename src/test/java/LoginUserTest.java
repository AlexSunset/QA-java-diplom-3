import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page_object.*;

public class LoginUserTest extends BaseTest{

    @Before
    public void registerUser(){
        getUserAPI().registerUser(getRegisterUserPOJO());
    }

    @Test
    public void successLoginOnEnterAccountButton(){
        setDriver();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnEnterAccountButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalAccount();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

    @Test
    public void successLoginOnClickPersonalAccount(){
        setDriver();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalAccount();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

    @Test
    public void successLoginOnClickEnterButtonOnRegisterPage(){
        setDriver();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegisterLink();
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.clickOnEnterLinkOnRegisterPage();
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalAccount();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

    @Test
    public void successLoginOnForgotPasswordPage(){
        setDriver();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRestorePasswordLink();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
        forgotPasswordPage.clickOnEnterLinkOnForgotPasswordPage();
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalAccount();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }
}
