package Pages;

import Util.UtilityComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignInPage extends UtilityComponent {
    private final By loginEmail = By.id("Email");
    private final By loginPassword = By.id("Password");
    private final By signUp = By.cssSelector("button[type='submit'].btn-primary");
    private final By signUpLink = By.cssSelector("a[href='/Account/SignUp']");
    private final By errorMessage = By.cssSelector("span.field-validation-error");




    public SignInPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public SignUpPage clickSignUp(){
        click(signUpLink);
        return new SignUpPage(driver);
    }

    public void signIn(String email,String password){
        senKeys(loginEmail,email);
        senKeys(loginPassword,password);
        click(signUp);
    }
    public List<String> getErrorMessage(){
        return driver.findElements(errorMessage)
                .stream()
                .map(WebElement::getText)
                .toList();
    }
    public boolean homePageIsDisplayed() {
        return waitForTitleIs("Home - Quiz");
    }

}

