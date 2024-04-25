package com.flowerchar.wait;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitAdvancedTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    @Test
    void waitByCondition() throws InterruptedException {
        driver.get("https://vip.ceshiren.com/#/ui_study/frame");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#success_btn"))).click();
    }

    @Test
    void waitByLambda() {
        driver.get("https://vip.ceshiren.com/#/ui_study/frame");
        WebElement ele =  wait.until(
                (driver) -> {
                    driver.findElement(By.cssSelector("#primary_btn")).click();
                    return driver.findElement(By.xpath("//*[text()='该弹框点击两次后才会弹出'"));
                }
        );
        System.out.println(ele.getText());
    }

}
