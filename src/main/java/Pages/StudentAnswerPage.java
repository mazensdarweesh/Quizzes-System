package Pages;

import Util.UtilityComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StudentAnswerPage extends UtilityComponent {
    private final By submitBtn = By.id("finish-btn");
    private final By answerCheckbox = By.cssSelector("input.answer-checkbox");

    public StudentAnswerPage(WebDriver driver){
        super(driver);
    }

    public void selectAnswer(By locator){
        selectCheckBox(locator);
    }

    public void submitAnswer(){
        click(submitBtn);
    }
}
