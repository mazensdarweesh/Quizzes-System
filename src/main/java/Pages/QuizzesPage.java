package Pages;

import Util.UtilityComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QuizzesPage extends UtilityComponent {

    private final By quizRows = By.cssSelector("table tbody tr");



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
        return driver.findElements(quizRows).size();
    }

    public boolean isQuizDisplayed(String quizTitle) {
        return getQuizTitles().contains(quizTitle);
    }

}
