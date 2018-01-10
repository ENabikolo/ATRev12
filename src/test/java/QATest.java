import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class QATest {
    WebDriver driver;
    String url ="https://www.qa.com/";

    //@BeforeClass
    @Before
    public void setUp() {
        System.setProperty("webDriver.chromeDriver", "C:/Users/Admin/Desktop/AT12/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);

    }

    @Test
    public void testQATest()throws InterruptedException{
        String expected = url;
        String actual = "https://www.qa.com/";
        WebElement e = driver.findElement(By.cssSelector("#header > div.header-myqa-navbar.visible-f > div"));
        e.submit();
        Thread.sleep(2000);
        assertEquals("url","https://www.qa.com/" );
    }

    @After
    public void tearDown(){
        driver.quit();

    }
    //@AfterClass
}
