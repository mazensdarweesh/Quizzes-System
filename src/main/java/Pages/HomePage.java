package Pages;

import Util.UtilityComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends UtilityComponent {
    private final By startQuizBtn = By.cssSelector("a.btn-primary[href='/StudentAnswer']");
    private final By quizzesBtn = By.cssSelector("a.nav-link[href='/StudentAnswer']");
    private final By myAttemptsNavLink = By.cssSelector("a.nav-link[href='/StudentAnswer/History']");
    private final By myAttemptsButtonLink = By.cssSelector("a.btn-outline-secondary[href='/StudentAnswer/History']");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickStartQuiz(){
        click(startQuizBtn);
    }
    


}
