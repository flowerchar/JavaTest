package com.flowerchar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

//import java.util.logging.Logger;

public class SougouTest {

    public static WebDriver driver;
    public static Logger logger;

    @BeforeAll
    static void setUp() {
        logger = LoggerFactory.getLogger(SougouTest.class);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void searchTest() throws InterruptedException {
        driver.get("https://www.sogou.com/");
        logger.debug("打开搜狗首页");
        driver.findElement(By.id("query")).sendKeys("霍格沃兹测试开发");
        logger.debug("搜索霍格沃兹测试开发");
        driver.findElement(By.id("stb")).click();
        String sogouVr300000000 = driver.findElement(By.id("sogou_vr_30000000_0")).getText();
        logger.info("获取搜索结果"+sogouVr300000000);
        Thread.sleep(3000);
    }
}
