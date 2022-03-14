import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
    WebDriver driver;

    @BeforeMethod
    public void driver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/webtables");
        driver.manage().window().maximize();
    }

    @Test
    public void testMethod() {
        driver.findElement(By.xpath("//*[@id='edit-record-1']")).click();

        driver.findElement(By.xpath("//*[@id='firstName']")).clear();
        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Lika");

        driver.findElement(By.cssSelector("input[id=age]")).clear();
        driver.findElement(By.cssSelector("input[id=age]")).sendKeys("20");

        if (driver.findElement(By.cssSelector("input[id=age]")).getAttribute("value").equals("20")) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
        }

        driver.findElement(By.id("submit")).click();

        driver.close();
    }
}
