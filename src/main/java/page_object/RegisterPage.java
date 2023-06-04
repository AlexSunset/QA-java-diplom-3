package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final WebDriver driver;
    private final By nameField = By.xpath(".//form/fieldset[1]/div/div/input");
    private final By emailField = By.xpath(".//form/fieldset[2]/div/div/input");
    private final By passwordField = By.xpath(".//form/fieldset[3]/div/div/input");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By incorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");
    private final By enterLinkOnRegisterPage = By.xpath(".//a[text()='Войти']");


    public void inputName(String name){
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }

    public void inputEmail(String name){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(name);
    }

    public void inputPassword(String name){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(name);
    }

    public void clickOnRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public void registerNewUser(String name, String email, String password){
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        clickOnRegisterButton();
    }

    public void clickOnEnterLinkOnRegisterPage(){
        driver.findElement(enterLinkOnRegisterPage).click();
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getIncorrectPassword() {
        return incorrectPassword;
    }
}
