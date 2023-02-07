package org.example.codingGame.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPageObject {
    protected WebDriver driver;

    private By signInButtonBy = By.cssSelector("button[value=\"user\"]");
    private By emailBy = By.name("loginEmail");
    private  By passwordBy = By.name("loginPassword");

    private  By signInSubmit = By.cssSelector("button[type=\"submit\"].user__login__form__button");

    public SignInPageObject(WebDriver driver) {
    this.driver = driver;
        if(!driver.getTitle().equals("Bookworm Idle")) {
            throw  new IllegalStateException("This is not sign in page, current page is: " + driver.getCurrentUrl());
        }
    }

    public HomePageObject loginValidUser(String userMail, String password) {
        driver.findElement(signInButtonBy).click();
        driver.findElement(emailBy).sendKeys(userMail);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signInButtonBy).click();

        return new HomePageObject(driver);
    }
}
