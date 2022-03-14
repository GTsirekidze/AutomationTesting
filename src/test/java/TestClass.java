import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestClass {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void EditionOfTests() {
        driver.navigate().to("https://demoqa.com/webtables");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//span[@id='edit-record-1']")).click();

        driver.findElement(By.xpath("//input[@id='firstName']")).clear();
        firstdriver.findElement(By.xpath("//input[@id='firstName']"))Name.sendKeys("Gigi");

        driver.findElement(By.cssSelector("input[id='age']")).clear();
        driver.findElement(By.cssSelector("input[id='age']")).sendKeys("20");

        if (driver.findElement(By.cssSelector("input[id='age']")).getAttribute("value").equals("20")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        driver.findElement(By.id("submit")).click();

        driver.findElement(By.xpath("//span[@id='delete-record-2']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group'][1]//div[@class='rt-td'][4]"))
                .getText().equals("cierra@example.com"));

        for (int i = 1; i <= 2; i++) {
            System.out.println(Integer.parseInt(driver.findElement(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group'][" + i + "]//div[@class='rt-td'][3]")).getText()) > 25);
        }
    }

    @AfterClass
    public void ShutDown() {
        driver.close();
    }
}
