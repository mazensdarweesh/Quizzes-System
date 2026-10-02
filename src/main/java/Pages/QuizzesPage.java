package Pages;

import Util.UtilityComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QuizzesPage extends UtilityComponent {

    private final By quizRows = By.cssSelector("table tbody tr");
    private final  By quizBtn = By.cssSelector("a[href='/StudentAnswer/StudentMaster/1']");
    private final By startQuizBtn = By.cssSelector("a[href='/StudentAnswer/StudentAnswer/1']");
    private final By quizAlert = By.cssSelector(".alert-warning");



    public QuizzesPage(WebDriver driver){
        super(driver);
    }


    public List<String> getQuizTitles(){
        return driver.findElements(quizRows)
                .stream()
                .map(row -> row.findElement(
                        By.cssSelector("td.fw-medium")
                ).getText())
                .toList();
    }

    public int getNumberOfQuizzes(){
        waitElementToDisplay(quizRows);
        return driver.findElements(quizRows).size();
    }

    public boolean isQuizDisplayed(String quizTitle) {
        return getQuizTitles().contains(quizTitle);
    }
    public void tableQuizStartBtn(){
        click(quizBtn);
    }
    public void startQuiz(){
        click(startQuizBtn);
    }

    public WebElement alertDisplayed(){
        waitElementToDisplay(quizAlert);
        return findElement(quizAlert);
    }

}
