import Pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {
    @Test
    public void validLogin(){
        signInPage.signIn("mazen@test.co","Test123!");
        signInPage.homePageIsDisplayed();
    }

    @Test
    public void invalidEmail(){
        signInPage.signIn("mazen2test.co","Test123!");
        Assert.assertTrue(
                signInPage.getErrorMessage()
                        .contains("EmailAddress Is Not Vailed !!")
        );
    }
    @Test
    public void invalidPassword(){
        signInPage.signIn("mazen@test.co","Test123");
        Assert.assertTrue(
                signInPage.getErrorMessage()
                        .contains("Password Is Required !!")
        );
    }
}
