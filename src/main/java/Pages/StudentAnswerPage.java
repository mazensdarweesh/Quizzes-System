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

    public void selectAnswer(String questionIndex, String answerIndex) {
        By answer = By.cssSelector(
                "div.question-card:nth-of-type(" + questionIndex +
                        ") label.answer-option:nth-of-type(" + answerIndex +
                        ") input.answer-checkbox"
        );

        selectCheckBox(answer);
    }

    public void submitAnswer(){
        click(submitBtn);
    }
}
