package org.example.bookwormTest;

import org.example.bookworm.pageObject.HomePageObject;
import org.example.bookworm.pageObject.SignInPageObject;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestLogin {
    @Test
    public void testLogin() {
        WebDriver driver = new ChromeDriver();
        SignInPageObject signInPage = new SignInPageObject(driver);
        HomePageObject homePage = signInPage.loginValidUser("test@test.test", "test");
        assertEquals("pseudo: r0xx0r2000", homePage.getPseudoLi());
    }
}
