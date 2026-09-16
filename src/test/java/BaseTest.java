import Pages.SignInPage;
import Pages.SignUpPage;
import Util.UtilityComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected SignUpPage signUpPage;
    protected SignInPage signInPage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        signUpPage = new SignUpPage(driver);
        signInPage = new SignInPage(driver);
        signInPage.navigateTo("http://quizy-front.runasp.net/");
        signInPage.clickSignUp();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
