import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {


    @BeforeMethod
    public void logIn(){
        loginAsValidUser();
    }

    @Test
    public void enterHomePage(){

        homePage.isHomePageDisplayed();
    }

    @Test
    public void myAttempts(){
        homePage.clickMyAttempts();
        homePage.isMyAttemptsPageDisplayed();

    }
    @Test
    public void verifyMyGrade(){

    }
}
