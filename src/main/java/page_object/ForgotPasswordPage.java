package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;
    private final By enterLinkOnForgotPasswordPage = By.xpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnEnterLinkOnForgotPasswordPage(){
        driver.findElement(enterLinkOnForgotPasswordPage).click();
    }
}
