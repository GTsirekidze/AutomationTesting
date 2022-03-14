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
    public void editTest() {
        driver.navigate().to("https://demoqa.com/webtables");
        driver.manage().window().maximize();

        WebElement record1 = driver.findElement(By.xpath("//span[@id='edit-record-1']"));
        record1.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.clear();
        firstName.sendKeys("Lika");

        WebElement age = driver.findElement(By.cssSelector("input[id='age']"));
        String ourAge = "20";

        age.clear();
        age.sendKeys(ourAge);

        if (age.getAttribute("value").equals(ourAge)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        driver.findElement(By.id("submit")).click();

        driver.findElement(By.xpath("//span[@id='delete-record-2']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group'][1]//div[@class='rt-td'][4]"))
                .getText().equals("cierra@example.com"));

        for (int i = 1; i <= 2; i++) {
            String xpath = "//div[@class='rt-tbody']//div[@class='rt-tr-group'][" + i + "]//div[@class='rt-td'][3]";
            System.out.println(Integer.parseInt(driver.findElement(By.xpath(xpath)).getText()) > 25);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
