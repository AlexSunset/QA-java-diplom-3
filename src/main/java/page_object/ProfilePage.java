package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private final WebDriver driver;
    private final By nameField = By.xpath(".//input[@value='Александр']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public By getNameField() {
        return nameField;
    }
}
