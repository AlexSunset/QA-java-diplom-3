package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;
    private final By personalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']");
    private final By constructBurgerHeader = By.xpath(".//h1[text()='Соберите бургер']");
    private final By stellarBurgersLogo = By.xpath(".//div/header/nav/div/a");

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

    public By getConstructBurgerHeader() {
        return constructBurgerHeader;
    }
}
