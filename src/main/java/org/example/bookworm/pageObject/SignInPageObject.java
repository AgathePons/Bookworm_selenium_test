package org.example.bookworm.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SignInPageObject {
    protected WebDriver driver;

    private By signInButtonBy = By.cssSelector("button[value=\"user\"]");
    private By emailBy = By.name("loginEmail");
    private  By passwordBy = By.name("loginPassword");

    private  By signInSubmit = By.cssSelector("button[type=\"submit\"].user__login__form__button");

    public SignInPageObject(WebDriver driver) {
        System.out.println(">> SignInPageObject constructor");
        this.driver = driver;
        driver.get("http://ns3251440.ip-87-98-217.eu/agathe-pons/bookworm-front-app/dist/");
        if(!driver.getTitle().equals("Bookworm Idle")) {
            throw  new IllegalStateException("This is not sign in page, current page is: " + driver.getCurrentUrl());
        }
    }

    public HomePageObject loginValidUser(String userMail, String password) {
        System.out.println(">> loginValidUser");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.findElement(signInButtonBy).click();
        driver.findElement(emailBy).sendKeys(userMail);
        driver.findElement(passwordBy).sendKeys(password);
        System.out.println("elements found");
        driver.findElement(signInSubmit).click();
        System.out.println("btn clicked");

        return new HomePageObject(driver);
    }
}
