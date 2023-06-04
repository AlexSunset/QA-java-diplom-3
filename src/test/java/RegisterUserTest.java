import org.junit.Assert;
import org.junit.Test;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.RegisterPage;

public class RegisterUserTest extends BaseTest{


    @Test
    public void registerUserSuccess(){
        setDriver();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegisterLink();
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.registerNewUser(getName(), getEmail(), getPassword());
        Assert.assertTrue(getDriver().findElement(loginPage.getEnterHeader()).isDisplayed());
    }

    @Test
    public void registerUserWithIncorrectPassword(){
        setDriver();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegisterLink();
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.registerNewUser(getName(), getEmail(), getIncorrectPassword());
        Assert.assertTrue(getDriver().findElement(registerPage.getIncorrectPassword()).isDisplayed());
    }
}
