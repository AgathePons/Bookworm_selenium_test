package org.example.samples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ExplicitWaitTest {
    @Test
    public void testWaitUntilOnWiki() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://google.com/ncr");

            WebElement rejectAllBtn = driver.findElement(By.id("W0wltc"));
            rejectAllBtn.click();

            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
            WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
            System.out.println(firstResult.getText());
            Thread.sleep(3000); // wait

            firstResult.click();
            String currentUrl = driver.getCurrentUrl();
            System.out.println(currentUrl);

            assertEquals("https://en.wikipedia.org/wiki/Cheese", currentUrl);
        } finally {
            driver.quit();
        }
    }
}
