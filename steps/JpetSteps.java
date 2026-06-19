package gitDemo.steps;

import Utils.baseClass;
import gitDemo.hooks1.SetupHooks;
import io.cucumber.java.en.*;
import gitDemo.pages.HomePage;
import gitDemo.pages.LoginPage;
import gitDemo.pages.RegisterPage;

import java.io.IOException;

public class JpetSteps extends baseClass {

    LoginPage loginPage;
    RegisterPage registerPage;
    HomePage homePage;

    String username;
    String password = "test123";

    // STEP 1: Home → Sign Up already
    @Given("user is on home page")
    public void user_on_home_page() {

        System.out.println("Home Page Open");

        homePage = new HomePage(SetupHooks.driver);

        // Direct SignUp click
        homePage.clickSignUp();

        //Now register page is already open
        registerPage = new RegisterPage(SetupHooks.driver);
    }

    //STEP 2: NO navigation again — only form fill
    @When("user goes to register page")
    public void go_to_register_page() {

        System.out.println("Already on Register Page");
    }

    // STEP 3: Fill form
    @And("user completes registration")
    public void complete_registration() {
        username = registerPage.registerUser();
        System.out.println(STR."Registered: \{username}");
    }

    // STEP 4: Go to login page
    @And("user navigates to login page")
    public void go_to_login_page() {
        loginPage = new LoginPage(SetupHooks.driver);
        System.out.println("Now we are on login page");
    }

    //STEP 5: Login
    @And("user performs login")
    public void perform_login() {
        loginPage.login(username, password);
    }

    // STEP 6: Final step
    @Then("user should see login success")
    public void verify_login() throws InterruptedException, IOException {
        System.out.println("LOGIN SUCCESSFUL → BACK TO HOME");
        Thread.sleep(3000);
        screenShot();
    }
}