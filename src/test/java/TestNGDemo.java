import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGDemo {
    private String baseURL = "http://www.leafground.com/pages/checkbox.html";
    private By javaCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[1]/input[1]");
    private By seleniumCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[2]/input");
    private By iAmSelectedCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[3]/input[2]");
    private WebDriver driver;
    private WebElement javaCheckbox;
    private WebElement seleniumCheckbox;
    private WebElement iAmSelectedCheckbox;

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURL);
        javaCheckbox = driver.findElement(javaCheckboxLocator);
        seleniumCheckbox = driver.findElement(seleniumCheckboxLocator);
        iAmSelectedCheckbox = driver.findElement(iAmSelectedCheckboxLocator);
    }

    @Test
    public void firstTest() {
        javaCheckbox.click();
        Assert.assertTrue(javaCheckbox.isSelected());
    }

    @Test
    public void secondTest() {
        Assert.assertTrue(seleniumCheckbox.isSelected());
    }

    @Test
    public void thirdTest() {
        iAmSelectedCheckbox.click();
        Assert.assertTrue(!iAmSelectedCheckbox.isSelected());
    }

    @Test
    public void fourthTest() {
        By inputListLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input");
        List<WebElement> checkboxes = driver.findElements(inputListLocator);
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
            Assert.assertTrue(checkbox.isSelected());
        }
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
