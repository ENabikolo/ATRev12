import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static junit.framework.TestCase.assertTrue;

public class ExtentReportTest {
     ExtentReports report;
     ExtentTest test;
     String reportLocation = "\"C:\\Users\\Admin\\Desktop\\AT12\\AutomationReport";
     WebDriver driver;
     String url = "http://thedemosite.co.uk ";

     @BeforeClass
    public void init(){
         //report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AT12\\AutomationReport.html", true);
         String fileName = "AutomationReport" + ".html";
         String filePath = System.getProperty("C:\\Users\\Admin\\Desktop\\AT12\\AutomationReport") + File.separatorChar + fileName;
         report.attachReporter(new ExtentHtmlReporter(filePath));
         System.out.println("INIT");
    }
//    @BeforeTest
//    public void setUp(){
////        driver = new ChromeDriver();
////
//    }

    @Test
    public void testExtentReport() throws InterruptedException{
//        report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AT12\\AutomationReport.html", true);
//        test = report.startTest("Verify Application Test");
//        System.setProperty("webDriver.chromeDriver", "C:/Users/Admin/Desktop/AT12/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //test.log(LogStatus.INFO, "Browser started");
        driver.get(url);

//        report.endTest(test);
        report.flush();

    }

    @Test
    public  void ValidUserLogin() throws InterruptedException {
        String username = "saywhat";
        String password = "igotuboo";

        driver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")).sendKeys(username);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")).sendKeys(password);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")).click();
        Thread.sleep(2000);


    }

    @After
    public void tearDown(){
        driver.quit();
    }
//    @AfterClass

}
