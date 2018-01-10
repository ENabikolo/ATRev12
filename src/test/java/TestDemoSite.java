import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestDemoSite {
    WebDriver driver;
    String url = "http://thedemosite.co.uk";
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void init(){
        report = new ExtentReports("C:/Users/Admin/Desktop/AT12/AutomationReport.html", true);
        test = report.startTest("Verify New User Addition");
    }

    @Before
    public void setUp(){
        //System.setProperty("webDriver.Firefox", "C:/Users/Admin/Desktop/AT12/Web_Driver/geckodriver.exe");
        System.setProperty("webDriver.Firefox", "C:/Users/Admin/Desktop/AT12/Web_Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //WebDriverWait<WebDriver> wait = driver.;
        test.log(LogStatus.INFO, "Browser started");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
    }

    @Test
    public void testCreateUser() throws InterruptedException{
        String username = "disadrag";
        String password = "Thisfault";

        driver.findElement(By.cssSelector("body > div:nth-child(1) > center:nth-child(1) > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > div:nth-child(2) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > p:nth-child(1) > small:nth-child(1) > a:nth-child(6)")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")).sendKeys(username);
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
        Thread.sleep(2000);

        Assert.assertEquals("Please be right!", username, "disadrag");
        Assert.assertEquals("You got that right!", password, "Thisfault");

        report.endTest(test);
        report.flush();

    }

    @After
    public void tearDown(){
        driver.quit();
    }
//    @AfterClass
}


