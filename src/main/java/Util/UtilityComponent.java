package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UtilityComponent {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public UtilityComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitElementToDisplay(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean waitForTitleIs(String expectedTitle) {
        return wait.until(ExpectedConditions.titleIs(expectedTitle));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void sendKeys(By locator, String text) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(text);
    }

    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void selectCheckBox(By locator) {
        WebElement checkBox = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        if (checkBox.isSelected()) {
            return;
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
        } catch (ElementClickInterceptedException e) {
            // custom-styled checkbox: click the parent label like a real user would
            checkBox.findElement(By.xpath("./ancestor::label")).click();
        }

        wait.until(d -> checkBox.isSelected());
    }
}