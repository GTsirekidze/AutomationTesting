import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void editTest() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/webtables");
        driver.manage().window().maximize();

        driver.findElement(By.id("edit-record-1")).click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));

        firstName.clear();
        firstName.sendKeys("Mikheil");

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
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
