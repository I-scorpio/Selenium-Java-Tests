package FirstApp.pages;

import FirstApp.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class loginTask {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public loginTask(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage() {
        driver.get(Utils.BASE_URL);
        System.out.println("Swag Labs Demo Page");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='login-button']")));// Ensure page is loaded
    }

    public void fillOutForm(String username, String password) {
        WebElement userID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))); // Corrected the ID
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))); // Corrected the ID
        wait.until(ExpectedConditions.elementToBeClickable(userID));
        userID.sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
        System.out.println("Input login credentials");
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.cssSelector("[data-test='login-button']"));
        loginButton.click();
        System.out.println("Click login");
    }

    public void checkHomePage() {
        WebElement hamburgerButton = driver.findElement(By.cssSelector(".bm-burger-button"));
        assert hamburgerButton.isDisplayed() : "Hamburger menu button is not displayed.";

        WebElement appLogo = driver.findElement(By.cssSelector(".app_logo"));
        assert appLogo.isDisplayed() : "App logo is not displayed.";

        WebElement shoppingCartIcon = driver.findElement(By.cssSelector(".shopping_cart_link"));
        assert shoppingCartIcon.isDisplayed() : "Shopping cart icon is not displayed.";
        System.out.println("Welcome to Swag Labs Home Page");
    }

   public void logOut() {
       WebElement hamburgerButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bm-burger-button")));
       hamburgerButton.click();
       // Wait for the logout button to become clickable after the menu has opened
       WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='logout-sidebar-link']")));
       logoutButton.click();
       System.out.println("Click logout");
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='login-button']")));
       System.out.println("Logging off from Swag Labs Home Page");
   }
}
