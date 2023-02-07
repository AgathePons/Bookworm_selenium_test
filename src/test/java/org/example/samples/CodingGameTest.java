package org.example.samples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CodingGameTest {
    @Test
    public void signInPageTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.codingame.com/start");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        System.out.println(driver.getTitle());

        WebElement signInButton = driver.findElement(By.className("navigation-auth_login-button"));
        signInButton.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("ponsagathe37@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Xj91E57PM543qgTk");
        WebElement submitButton = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        submitButton.click();

        Thread.sleep(7000); // wait

        driver.quit();
    }
}
