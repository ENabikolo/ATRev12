import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    WebDriver driver;
    String url = "http://www.seleniumhq.org";

    //@BeforeClass
    @Before
    public void setUp() {
        System.setProperty("webdriver.chromeDriver", "C:/Users/Admin/Desktop/AT12/Web_Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void selHqTest() throws InterruptedException{
             String username = "enabikolo";
             String password = "Whodat1";

            driver.findElement(By.cssSelector("#menu_support > a")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#mainContent > h1"));
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#mainContent > p:nth-child(7) > a:nth-child(1)")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#ircui > div.dynamicpanel.qwebirc-qui.middleboundpanel.lines > table > tbody > tr > td > table > tbody > tr.tr2 > td > form > table > tbody > tr:nth-child(1) > td:nth-child(2) > input")).sendKeys("loco");
            driver.findElement(By.xpath("//*[@id=\'ircui\']/div[4]/table/tbody/tr/td/table/tbody/tr[2]/td/form/table/tbody/tr[3]/td[2]/input")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\'ircui\']/div[4]/table/tbody/tr/td/table/tbody/tr[2]/td/form/table/tbody/tr[4]/td[2]/input")).sendKeys(username);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\'ircui\']/div[4]/table/tbody/tr/td/table/tbody/tr[2]/td/form/table/tbody/tr[5]/td[2]/input")).sendKeys(password);
            Thread.sleep(2000);
            //Checkbox throws a NoSuchElementException
            //driver.findElement(By.cssSelector("body > div.rc-anchor.rc-anchor-compact.rc-anchor-light.rc-anchor-error > div.rc-anchor-content > div:nth-child(1) > div > div")).click();
            //Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\'ircui\']/div[4]/table/tbody/tr/td/table/tbody/tr[2]/td/form/table/tbody/tr[8]/td[2]/input")).click();
            Thread.sleep(2000);
    }


    @After
    public void tearDown(){
        driver.quit();
    }
    //@AfterClass
}
