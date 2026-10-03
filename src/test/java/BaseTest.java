import Pages.*;
import Util.UtilityComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected SignUpPage signUpPage;
    protected SignInPage signInPage;
    protected HomePage homePage;
    protected QuizzesPage quizzesPage;
    protected StudentAnswerPage studentAnswerPage;

    private final String BASE_URL = "http://quizy-front.runasp.net/";
    private final String VALID_EMAIL = "mazend@test.co";
    private final String VALID_PASSWORD = "Test123!";

    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        signUpPage = new SignUpPage(driver);
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        quizzesPage = new QuizzesPage(driver);
        studentAnswerPage = new StudentAnswerPage(driver);

        signInPage.navigateTo(BASE_URL);




    }
    public void loginAsValidUser(){
        signInPage.signIn(VALID_EMAIL,VALID_PASSWORD);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
