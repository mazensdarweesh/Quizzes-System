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

    public void selectAnswer(String question, String answer) {
        By locator = By.xpath(
                "//div[contains(@class,'question-card')]" +
                        "[.//p[contains(@class,'question-text') and normalize-space()='" + question + "']]" +
                        "//label[.//span[contains(@class,'answer-text') and normalize-space()='" + answer + "']]" +
                        "//input[@type='checkbox']"
        );

        selectCheckBox(locator);
    }

    public void submitAnswer(){
        click(submitBtn);
    }
}
