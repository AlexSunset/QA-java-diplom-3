import api.LoginUserPOJO;
import api.RegisterUserPOJO;
import api.UserAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static page_object.PageConstants.MAIN_PAGE;

public class BaseTest {

    private final String email = "alex.sunset87@gmail.com";
    private final String password = "123456";
    private final String name = "Александр";
    private final String incorrectPassword = "12345";

    private WebDriver driver;
    private UserAPI userAPI = new UserAPI();
    private final LoginUserPOJO loginUserPOJO = new LoginUserPOJO(email, password);
    private final RegisterUserPOJO registerUserPOJO = new RegisterUserPOJO(email, password, name);

    public void setDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(MAIN_PAGE);
        driver.manage().window().maximize();
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    }

    @After
    public void cleanUp(){
        Response response = getUserAPI().loginUser(getLoginUserPOJO());
        if(response.jsonPath().get("success").equals(true)){
            getUserAPI().logout(response.jsonPath().get("accessToken"));
            getUserAPI().deleteUser(response.jsonPath().get("accessToken"));
        }
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public UserAPI getUserAPI() {
        return userAPI;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public LoginUserPOJO getLoginUserPOJO() {
        return loginUserPOJO;
    }

    public String getIncorrectPassword() {
        return incorrectPassword;
    }

    public RegisterUserPOJO getRegisterUserPOJO() {
        return registerUserPOJO;
    }
}
