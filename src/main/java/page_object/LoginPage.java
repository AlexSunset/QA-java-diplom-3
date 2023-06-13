package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By enterHeader = By.xpath(".//h2[text()='Вход']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By emailField = By.xpath(".//form/fieldset[1]/div/div/input");
    private final By passwordField = By.xpath(".//form/fieldset[2]/div/div/input");
    private final By restorePasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnRegisterLink(){
        driver.findElement(registerLink).click();
    }

    public void enterEmail(String email){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnEnterButton(){
        driver.findElement(enterButton).click();
    }

    public void clickOnRestorePasswordLink(){
        driver.findElement(restorePasswordLink).click();
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickOnEnterButton();
    }

    public By getEnterHeader() {
        return enterHeader;
    }
}
