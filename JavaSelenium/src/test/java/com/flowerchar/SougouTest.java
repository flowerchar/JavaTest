package com.flowerchar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import static java.lang.Thread.sleep;

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
        sleep(3000);
    }

    @Test
    void sogouScreen() throws IOException, InterruptedException {
        driver.get("https://www.sogou.com/");
        File current = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(current, new File("./sogou.png"));
        driver.findElement(By.id("query")).sendKeys("霍格沃兹测试开发");
        driver.findElement(By.id("stb")).click();
        WebElement sogouVr300000000 = driver.findElement(By.id("sogou_vr_30000000_0"));
        File sogou = sogouVr300000000.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sogou, new File("./image/sogou_vr_30000000_0.png"));
//        sleep(30000);
    }

    @Test
    void sogouPageSource() throws InterruptedException, IOException {
        driver.get("https://vip.ceshiren.com/");
        String pageSource = driver.getPageSource();
//        System.out.println(pageSource);
        for (int i = 0; i < 4; i++) {
            sleep(2000);
            String pageSource1 = driver.getPageSource();
            new FileWriter(new File("./sogou"+i+".html")).write(pageSource1);
        }
    }
}
