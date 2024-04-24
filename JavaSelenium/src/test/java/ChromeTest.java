import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {

    @Test
    void demo() {
//        System.out.println("Hello world!");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        driver.quit();
    }
}
