package org.example.codingGame.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject {
    protected WebDriver driver;
    private By pseudoLi = By.className("user__info__list__info");

    public HomePageObject(WebDriver driver) {
        this.driver = driver;

        if(!driver.findElement(pseudoLi).getAttribute("innerHTML").equals("pseudo: r0xx0r2000")) {
            throw new IllegalStateException("Not logged on the application");
        }
    }
}
