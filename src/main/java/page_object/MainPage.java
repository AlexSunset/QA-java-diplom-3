package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.html.parser.Element;

public class MainPage {

    private final WebDriver driver;
    private final By personalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']");
    private final By constructBurgerHeader = By.xpath(".//h1[text()='Соберите бургер']");
    private final By stellarBurgersLogo = By.xpath(".//div/header/nav/div/a");
    private final By bunsSection  = By.xpath(".//span[text()='Булки']");
    private final By saucesSection  = By.xpath(".//span[text()='Соусы']");
    private final By ingredientsSection  = By.xpath(".//span[text()='Начинки']");
    private final By theChosenElement  = By.className("tab_tab_type_current__2BEPc");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPersonalAccount(){
        driver.findElement(personalAccount).click();
    }

    public void clickOnEnterAccountButton(){
        driver.findElement(enterAccountButton).click();
    }

    public void clickOnConstructorLink(){
        driver.findElement(constructorLink).click();
    }

    public void clickOnStellarBurgersLogo(){
        driver.findElement(stellarBurgersLogo).click();
    }

    public void clickOnBunsSection(){
        driver.findElement(bunsSection).click();
    }

    public void clickOnSaucesSection(){
        driver.findElement(saucesSection).click();
    }

    public void clickOnIngredientsSection(){
        driver.findElement(ingredientsSection).click();
    }

    public String getTextFromTheChosenElement(){
        return driver.findElement(theChosenElement).getText();
    }

    public By getConstructBurgerHeader() {
        return constructBurgerHeader;
    }
}
