import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGDemo {
    private String baseURL = "http://www.leafground.com/pages/checkbox.html";
    private By javaCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[1]/input[1]");
    private By seleniumCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[2]/input");
    private By iAmSelectedCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[3]/input[2]");
    private By optionOneCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[1]");
    private By optionTwoCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[2]");
    private By optionThreeCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[3]");
    private By optionFourCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[4]");
    private By optionFiveCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[5]");
    private By optionSixCheckboxLocator = By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[6]");
    private WebDriver driver;
    private WebElement javaCheckbox;
    private WebElement seleniumCheckbox;
    private WebElement iAmSelectedCheckbox;
    private WebElement optionOneCheckbox;
    private WebElement optionTwoCheckbox;
    private WebElement optionThreeCheckbox;
    private WebElement optionFourCheckbox;
    private WebElement optionFiveCheckbox;
    private WebElement optionSixCheckbox;

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURL);
        javaCheckbox = driver.findElement(javaCheckboxLocator);
        seleniumCheckbox = driver.findElement(seleniumCheckboxLocator);
        iAmSelectedCheckbox = driver.findElement(iAmSelectedCheckboxLocator);
        optionOneCheckbox = driver.findElement(optionOneCheckboxLocator);
        optionTwoCheckbox = driver.findElement(optionTwoCheckboxLocator);
        optionThreeCheckbox = driver.findElement(optionThreeCheckboxLocator);
        optionFourCheckbox = driver.findElement(optionFourCheckboxLocator);
        optionFiveCheckbox = driver.findElement(optionFiveCheckboxLocator);
        optionSixCheckbox = driver.findElement(optionSixCheckboxLocator);
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
}
