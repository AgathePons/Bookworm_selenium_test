package org.example;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class FillAllInputsTest {

    @Test
    public void testFillForm() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");
            // --- wait
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            // --- get elements
            WebElement textBox = driver.findElement(By.name("my-text"));
            WebElement passwordBox = driver.findElement(By.name("my-password"));
            WebElement textareaBox = driver.findElement(By.name("my-textarea"));
            // select
            WebElement selectBox = driver.findElement(By.name("my-select"));
            Select selectElement = new Select(selectBox);
            // input list
            WebElement inputOption = driver.findElement(By.name("my-datalist"));
            WebElement option = driver.findElement(By.cssSelector("datalist#my-options option[value=\"Chicago\"]"));
            // file input
            WebElement fileBox = driver.findElement(By.name("my-file"));
            // check / radio
            WebElement checkedBox = driver.findElement(By.id("my-check-1"));
            WebElement defaultCheckBox = driver.findElement(By.id("my-check-2"));
            WebElement radioBox = driver.findElement(By.id("my-radio-2"));
            WebElement colorBox = driver.findElement(By.name("my-colors"));
            WebElement dateBox = driver.findElement(By.name("my-date"));
            WebElement rangeBox = driver.findElement(By.name("my-range"));

            // Interact with elements
            textBox.sendKeys("Youpiyeah!");
            passwordBox.sendKeys("t0p_s3cr3t_p4ssw0rd");
            textareaBox.sendKeys("Blablabla, blabliblou.\nBlabla.");
            selectElement.selectByValue("2");
            inputOption.click();
            inputOption.sendKeys(option.getAttribute("value"));
            driver.findElement(By.xpath("//html")).click();
            fileBox.sendKeys("C:/Users/agathe.pons/image-attractive-960x540.jpg");
            System.out.println("checked value: " + checkedBox.getAttribute("checked"));
            checkedBox.click();
            System.out.println("checked value: " + checkedBox.getAttribute("checked"));
            checkedBox.click();
            System.out.println("checked value: " + checkedBox.getAttribute("checked"));
            defaultCheckBox.click();
            radioBox.click();
            // color
            colorBox.sendKeys("#49F031");
            // date
            dateBox.sendKeys("04/03/1991");
            driver.findElement(By.xpath("//html")).click();
            // range
            rangeBox.sendKeys(Keys.ARROW_RIGHT);
            Thread.sleep(4000); // wait
            rangeBox.sendKeys(Keys.ARROW_RIGHT);
            Thread.sleep(4000); // wait

            Dimension rangeSize = rangeBox.getSize();
            System.out.println(rangeSize);


            // Wait
            Thread.sleep(4000); // wait

            WebElement submitButton = driver.findElement(By.cssSelector("button"));

            // Submit
            submitButton.click();
            // wait
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            // Verify submission is done
            WebElement message = driver.findElement(By.id("message"));
            String value = message.getText();
            assertEquals("Received!", value);
        } finally {
            // Quit browser
            driver.quit();
        }
    }

}
