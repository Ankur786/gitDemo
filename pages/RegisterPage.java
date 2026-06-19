package gitDemo.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // IMPORTANT
        PageFactory.initElements(driver, this);
    }

    // USER INFO
    @FindBy(xpath="//input[@name='username']") WebElement userName;
    @FindBy(xpath="//input[@name='password']") WebElement newPassword;
    @FindBy(xpath="//input[@name='repeatedPassword']") WebElement confirmPassword;

    //------ACCOUNT INFORMATION ELEMENTS-------
    @FindBy(xpath="//input[@name='firstName']")WebElement firstName;
    @FindBy(xpath="//input[@name='lastName']")WebElement lastName;
    @FindBy(xpath="//input[@name='email']")WebElement email;
    @FindBy(xpath="//input[@name='phone']")WebElement phone;
    @FindBy(xpath="//input[@name='address1']")WebElement address1;
    @FindBy(xpath="//input[@name='address2']")WebElement address2;
    @FindBy(xpath="//input[@name='city']")WebElement city;
    @FindBy(xpath="//input[@name='state']")WebElement state;
    @FindBy(xpath="//input[@name='zip']")WebElement zip;
    @FindBy(xpath="//input[@name='country']")WebElement country;

    //-------PROFILE INFORMATION ELEMENTS-------
    @FindBy(xpath="//select[@name='languagePreference']")WebElement languagePreference;
    @FindBy(xpath="//select[@name='favouriteCategoryId']")WebElement favouriteCategory;
    @FindBy(xpath="//input[@name='listOption']")WebElement myList;
    @FindBy(xpath="//input[@name='bannerOption']")WebElement myBanner;

    //------SAVE ACCOUNT INFORMATION ELEMENTS------
    @FindBy(xpath="//button[@type='submit']")WebElement saveAccountInformationBtn;

    public String registerUser() {
        String user = "User" + System.currentTimeMillis();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOf(firstName));

        //USER INFO
        userName.sendKeys(user);
        newPassword.sendKeys("test123");
        confirmPassword.sendKeys("test123");

        //ACCOUNT INFO
        firstName.sendKeys("Ankur");
        lastName.sendKeys("Nigam");
        email.sendKeys("test@gmail.com");
        phone.sendKeys("9999999999");

        //SCROLL TO ADDRESS
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", address1);

        // ADDRESS INFO
        address1.sendKeys("Pune");
        address2.sendKeys("Hinjewadi");
        city.sendKeys("Pune");
        state.sendKeys("MH");
        zip.sendKeys("411057");
        country.sendKeys("India");

        //SCROLL + CLICK CHECKBOX (FIXED)
        WebElement list = wait.until(ExpectedConditions.elementToBeClickable(myList));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", list);
        js.executeScript("arguments[0].click();", list);

        //SCROLL + CLICK SAVE BUTTON
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(saveAccountInformationBtn));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
        js.executeScript("arguments[0].click();", btn);

        return user;

    }

}