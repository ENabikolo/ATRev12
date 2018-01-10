import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class myTestMethod {
    //private webDriver driver;
    //@BeforeClass
    @Before
    public void setUp(){
        System.out.println("setMandemsUp");
        //driver = new ChromeDriver();
    }
    @Test
    public void testMyTestMethod() throws InterruptedException{
        System.out.println("Test");
        //driver. navigate(). to(url);

    }

    @After
    public void tearDown(){
        System.out.println("After");
        //driver.quit();
    }
    //@AfterClass
}
