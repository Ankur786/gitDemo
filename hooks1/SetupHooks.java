package gitDemo.hooks1;

import Utils.baseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SetupHooks extends baseClass {

    @Before
    public void startBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://jpetstore.aspectran.com/");
    }
    @After
    public static void closeBrowser() {
        driver.quit();
    }
}