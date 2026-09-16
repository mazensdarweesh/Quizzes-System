package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UtilityComponent {
    protected WebDriver driver;

    public UtilityComponent(WebDriver driver){
        this.driver = driver;
    }
    public void waitElementToDisplay(By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitElementToDisappear(By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public boolean waitForTitleIs(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.titleIs(expectedTitle));
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void navigateTo(String url){
        driver.get(url);
    }
    public void senKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

}