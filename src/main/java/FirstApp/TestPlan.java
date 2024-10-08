package FirstApp;

import FirstApp.pages.loginTask;
import FirstApp.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPlan {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            loginTask loginPage = new loginTask(driver);
            loginPage.openPage();
            loginPage.fillOutForm(Utils.USERNAME, Utils.PASS);
            loginPage.clickLoginButton();
            loginPage.checkHomePage();
            loginPage.logOut();

        } finally {
            driver.quit();
        }
    }
}
