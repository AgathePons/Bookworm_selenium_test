package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class TestSelenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        System.out.println("Successfully opened the website");
        String title = driver.getTitle();
        System.out.println("Title :" + title);
        // wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        // get elements
        WebElement textBox = driver.findElement(By.name("my-text"));
        System.out.println(textBox);
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        System.out.println(submitButton);

        // interact with elements
        Thread.sleep(3000); // wait
        textBox.sendKeys("Youpiyeah");
        Thread.sleep(2000); // wait

        // get elements informations
        WebElement colorInput = driver.findElement(By.name("my-colors"));
        System.out.println("color: " + colorInput.getAttribute("value"));
        colorInput.sendKeys("#49F031");
        Thread.sleep(3000); // wait

        // Submit
        submitButton.click();

        driver.quit();
        System.out.println("Successfully executed");
    }
}
