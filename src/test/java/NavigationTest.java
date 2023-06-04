import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page_object.LoginPage;
import page_object.MainPage;

public class NavigationTest extends BaseTest{

    @Before
    public void registerUser(){
        getUserAPI().registerUser(getRegisterUserPOJO());
    }

    @Test
    public void moveToConstructorFromProfileOnConstructorLink(){
        setDriver();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnEnterAccountButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalAccount();
        mainPage.clickOnConstructorLink();
        Assert.assertTrue(getDriver().findElement(mainPage.getConstructBurgerHeader()).isDisplayed());
    }

    @Test
    public void moveToConstructorFromProfileOnStellarBurgerLogo(){
        setDriver();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnEnterAccountButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalAccount();
        mainPage.clickOnStellarBurgersLogo();
        Assert.assertTrue(getDriver().findElement(mainPage.getConstructBurgerHeader()).isDisplayed());
    }
}
