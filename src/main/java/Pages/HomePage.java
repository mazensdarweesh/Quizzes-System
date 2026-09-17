package Pages;

import Util.UtilityComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends UtilityComponent {
    private final By startQuizBtn = By.cssSelector("a.btn-primary[href='/StudentAnswer']");
    private final By quizzesBtn = By.cssSelector("a.nav-link[href='/StudentAnswer']");
    private final By myAttemptsNavLink = By.cssSelector("a.nav-link[href='/StudentAnswer/History']");
    private final By myAttemptsButtonLink = By.cssSelector("a.btn-outline-secondary[href='/StudentAnswer/History']");
    private final By grade = By.cssSelector("p.page-sub strong");
    private final By signOut = By.cssSelector("[type='submit']");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickStartQuiz(){
        click(startQuizBtn);
    }

    public boolean isQuizPageDisplayed(){
        return waitForTitleIs("Quizzes - Quiz");
    }

    public void clickMyAttempts(){
        click(myAttemptsNavLink);
    }

    public boolean isMyAttemptsDisplayed() {
        return waitForTitleIs("My attempts - Quiz");
    }
    public String getGrade(){
        return getText(grade);
    }
    public void clickSignOut(){
        click(signOut);
    }



    


}
