package org.example.samples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class BookwormTest {
    @Test
    public void signInUser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://ns3251440.ip-87-98-217.eu/agathe-pons/bookworm-front-app/dist/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        System.out.println(driver.getTitle());

        WebElement signInButton = driver.findElement(By.cssSelector("button[value=\"user\"]"));
        signInButton.click();

        WebElement emailInput = driver.findElement(By.name("loginEmail"));
        emailInput.sendKeys("test@test.test");
        WebElement passwordInput = driver.findElement(By.name("loginPassword"));
        passwordInput.sendKeys("test");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type=\"submit\"].user__login__form__button"));
        submitButton.click();

        Thread.sleep(2000); // wait

        WebElement closeWelcomeBackButton = driver.findElement(By.className("loginmodal__header__btn"));
        closeWelcomeBackButton.click();

        WebElement pseudoLi = driver.findElement(By.className("user__info__list__info"));
        Thread.sleep(2000); // wait

        assertEquals("pseudo: r0xx0r2000", pseudoLi.getAttribute("innerHTML"));

        driver.quit();
    }
}
