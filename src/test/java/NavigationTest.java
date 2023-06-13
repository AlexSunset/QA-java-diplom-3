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
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnEnterAccountButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalAccount();
        mainPage.clickOnStellarBurgersLogo();
        Assert.assertTrue(getDriver().findElement(mainPage.getConstructBurgerHeader()).isDisplayed());
    }

    @Test
    public void correctTransitionsBetweenSections(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnSaucesSection();
        mainPage.clickOnBunsSection();
        Assert.assertEquals("Булки", mainPage.getTextFromTheChosenElement());
        mainPage.clickOnSaucesSection();
        Assert.assertEquals("Соусы", mainPage.getTextFromTheChosenElement());
        mainPage.clickOnIngredientsSection();
        Assert.assertEquals("Начинки", mainPage.getTextFromTheChosenElement());
    }
}
