package Pages;

import Util.UtilityComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends UtilityComponent {

    // Locators
    private final By startQuizBtn =
            By.cssSelector("a.btn-primary[href='/StudentAnswer']");

    private final By quizzesBtn =
            By.cssSelector("a.nav-link[href='/StudentAnswer']");

    private final By myAttemptsNavLink =
            By.cssSelector("a.nav-link[href='/StudentAnswer/History']");

    private final By myAttemptsButtonLink =
            By.cssSelector("a.btn-outline-secondary[href='/StudentAnswer/History']");

    private final By grade =
            By.cssSelector("p.page-sub strong");

    private final By signOut =
            By.cssSelector("button.btn-outline-light");


    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }


    // Actions
    public void clickStartQuiz() {
        click(startQuizBtn);
    }

    public void clickQuizzes() {
        click(quizzesBtn);
    }

    public void clickMyAttempts() {
        click(myAttemptsNavLink);
    }

    public void clickMyAttemptsButton() {
        click(myAttemptsButtonLink);
    }

    public void clickSignOut() {
        click(signOut);
    }


    // Verifications
    public boolean isHomePageDisplayed() {
        return waitForTitleIs("Home - Quiz");
    }

    public boolean isQuizzesPageDisplayed() {
        return waitForTitleIs("Quizzes - Quiz");
    }

    public boolean isMyAttemptsPageDisplayed() {
        return waitForTitleIs("My attempts - Quiz");
    }

    public String getGrade() {
        return getText(grade);
    }
}