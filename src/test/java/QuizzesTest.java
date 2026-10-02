import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QuizzesTest extends BaseTest {
    @BeforeMethod
    public void logIn(){
        loginAsValidUser();
    }

    @BeforeMethod
    public void startQuiz(){
        homePage.clickStartQuiz();
    }

    @Test
    public void verifyNumberOfQuizzes(){


        Assert.assertEquals(quizzesPage.getNumberOfQuizzes(),3);
    }
    @Test
    public void getQuizzesInTheTable(){

        System.out.println(quizzesPage.getQuizTitles());
        quizzesPage.isQuizDisplayed("Test");
    }
    @Test
    public void goToQuizPage(){

        quizzesPage.tableQuizStartBtn();
        quizzesPage.alertDisplayed();

    }
}

