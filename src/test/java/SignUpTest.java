import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class SignUpTest extends BaseTest {


    @BeforeMethod(dependsOnMethods = "setUp")
    public void goToSignUpPage() {
        signInPage.clickSignUp();
    }


    @Test
    public void validSignUp(){

        signUpPage.signUp("Mazen",
                "Kahlil",
                "Darweesh124",
                "Test123!",
                "Test123!",
                1,
                "mazend12@test.co");
        signUpPage.signInPageIsDisplayed();


    }

    @Test
    public void emptyFirstName(){
        signUpPage.signUp(" ",
                "Kahlil",
                "MazenSayed011",
                "Test123!",
                "Test123!",
                1,
                "mazensayed@test.co");

        Assert.assertTrue(
                signUpPage.getErrorMessage()
                        .contains("FirstName Is Required !!")
        );

    }
    @Test
    public void emptyLastName(){
        signUpPage.signUp("Mazen",
                " ",
                "MazenSayed",
                "Test123!",
                "Test123!",
                1,
                "mazen@test.co");

        Assert.assertTrue(
                signUpPage.getErrorMessage()
                        .contains("LastName Is Required !!")
        );

    }
    @Test

    public void duplicatedUserName(){

        signUpPage.signUp("Mazen",
                "Kahlil",
                "MazenSayed",
                "Test123!",
                "Test123!",
                1,
                "mazen@test.co");
        signInPage.clickSignUp();
        Assert.assertTrue(
                signUpPage.getErrorMessage()
                        .contains("Username is already taken!")
        );

    }
    @Test

    public void duplicatedEmail(){

        signUpPage.signUp("Mazen",
                "Kahlil",
                "mazen011",
                "Test123!",
                "Test123!",
                1,
                "mazen@test.co");

        Assert.assertTrue(
                signUpPage.getErrorMessage()
                        .contains("Email is already in use!")
        );

    }
}
