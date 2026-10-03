import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentAnswerTest extends BaseTest {
    @BeforeMethod
    public void login(){
        loginAsValidUser();
    }
    @BeforeMethod
    public void startQuiz(){
        homePage.clickStartQuiz();
        quizzesPage.startQuiz();
    }

    @Test
    public void completeQuiz() {

        studentAnswerPage.selectAnswer("2 + 2 = ?", "4");

        studentAnswerPage.selectAnswer("5 * 6 = ?", "30");

        studentAnswerPage.selectAnswer("10 - 7 = ?", "3");

        studentAnswerPage.submitAnswer();
    }

}
