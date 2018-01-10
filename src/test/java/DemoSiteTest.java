import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
//import com.relevantcodes.extentreports.ExtentReports;

public class DemoSiteTest {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    public WebDriver driver;
    public WebDriverWait wait;
    //private List<String> List = new ArrayList<String>();
    String url = "http://thedemosite.co.uk ";


  @BeforeClass
    public void init(){
      System.out.println("Run Before SetUp");

  }
    @BeforeTest
    public void setUp(){
        System.setProperty("webDriver.chromeDriver", "C:/Users/Admin/Desktop/AT12/chromedriver.exe");
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 5);
        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test (priority = 1, enabled = true)
    public void testAddAUserAndSaveUser() throws InterruptedException{

        String username = "saywhat";
        String password = "igotuboo";
        //IWebElement<IWebDriver> wait =

        driver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")).sendKeys(username);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\'password\']")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\'button\']")).click();

    }

    @Test
    public void testSuccessfulUserLogin() throws InterruptedException{
        String username = "saywhat";
        String password = "igotuboo";

        driver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")).sendKeys(username);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")).sendKeys(password);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")).click();
        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("New User Logged In!", alertText);


    }

    @Test
    public void testInvalidLoginNewUser () throws InterruptedException{
        String username = "Godsblessing";
        String password = "IsdaBest";

        driver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")).sendKeys(username);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")).sendKeys(password);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")).click();
        Thread.sleep(2000);

        //Login attempt failed because this user was never created. Test passed.

    }
/*
    @Test
    public void testLoginValidity() throws InterruptedException{

        //assertTrue();

    }*/

    @After
    public void tearDown(){
        driver.quit();
    }

    //@AfterClass



}