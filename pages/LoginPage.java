package gitDemo.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    By signIn = By.linkText("Sign In");
    By username = By.name("username");
    By password = By.name("password");
    @FindBy(xpath="//button[@type='submit']")WebElement LoginBtn;

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(LoginBtn));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", login);
    }
}