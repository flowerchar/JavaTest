package com.flowerchar.litemall;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class LitemallTest {
    private static WebDriver driver;

    @BeforeAll
    static void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    void saveScreen(){
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String fileName = "./image/"+currentTimeMillis+".png";
            File currentScreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(currentScreen, new File(fileName));
            Allure.addAttachment("pitcure1", "image/png", new FileInputStream(fileName), ".jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterAll
    static void tearDown(){
        driver.quit();
    }
    @Test
    void loginTest() throws InterruptedException {
        driver.get("http://litemall.hogwarts.ceshiren.com/#/login");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("manage");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("manage123");
        driver.findElement(By.cssSelector("button")).click();
        sleep(3000);
        driver.findElement(By.xpath("//ul//*[text()='商场管理']")).click();
        driver.findElement(By.xpath("//ul//*[text()='商品类目']")).click();
        sleep(1000);
        saveScreen();
        sleep(3000);
    }

//    @Test
//    void addProductType(){
////        ExpectedConditions.ele
//        driver.findElement(By.cssSelector(".el-icon-edit")).click();
//        driver.findElement(By.cssSelector(".el-form-item:nth-child(1) input ")).sendKeys("测试添加商品");
//        driver.findElement(By.cssSelector(".el-dialog__footer .el-button--primary")).click();
//    }
}
