package Pages;

import Util.UtilityComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpPage extends UtilityComponent {
    private final By userFirstName = By.id("FirstName");
    private final By userLastName = By.id("LastName");
    private final By userName = By.id("UserName");
    private final By userEmail = By.id("Email");
    private final By userPassword = By.id("Password");
    private final By userConfirmPassword = By.id("ConfirmPassword");
    private final By gradeId = By.id("GradeId");
    private final By signUp = By.cssSelector("button[type='submit'].btn-primary");
    private final By errorMessage = By.cssSelector("span.field-validation-error");
    

    public SignUpPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void signUp(String firstName,String lastName,
                       String username, String password,
                       String confirmPassword, int grade,
                       String email)
    {
        senKeys(userFirstName,firstName);
        senKeys(userLastName,lastName);
        senKeys(userName,username);
        senKeys(userPassword,password);
        senKeys(userConfirmPassword,confirmPassword);
        senKeys(userEmail,email);
        Select gradeDropDown = new Select(driver.findElement(gradeId));
        gradeDropDown.selectByIndex(grade);
        click(signUp);

    }

    public List<String> getErrorMessage(){
       return driver.findElements(errorMessage)
               .stream()
               .map(WebElement::getText)
               .toList();
    }

    public boolean signInPageIsDisplayed() {
        return waitForTitleIs("Sign in - Quiz");
    }


}
