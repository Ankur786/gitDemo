package gitDemo.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // DIRECT SIGN UP BUTTON (important)
    By signUpBtn = By.linkText("Sign Up");

    public void clickSignUp() {
        WebElement signup = wait.until(
                ExpectedConditions.elementToBeClickable(signUpBtn)
        );
        try {
            signup.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", signup);
        }
    }
}