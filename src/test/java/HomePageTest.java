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
    public void myAttemptsNavBar(){
        homePage.clickMyAttemptsButton();
        homePage.isMyAttemptsPageDisplayed();
    }
    @Test
    public void myQuizzes(){
        homePage.clickQuizzes();
        homePage.isQuizzesPageDisplayed();
    }
    @Test
    public void myQuizzesNaveBar(){
        homePage.clickStartQuiz();
        homePage.isQuizzesPageDisplayed();
    }
    @Test
    public void verifyGrade(){

        Assert.assertEquals(homePage.getGrade(),"Grade 5");

    }
    @Test
    public void signOut(){
        homePage.clickSignOut();
        homePage.isSignInPageDisplayed();

    }
}
