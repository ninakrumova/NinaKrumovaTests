package Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Browser {

    public final static String PATHFIREFOX = "D:\\Documents\\Courses\\Telerik\\Drivers\\geckodriver.exe";
    public final static String PATHCHROME = "D:\\Documents\\Courses\\Telerik\\Drivers\\chromedriver.exe";
    public final static String telerikForumUrl = "https://stage-forum.telerikacademy.com/";
    public static WebDriver driver;



    public static void init(String browser) {
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", PATHFIREFOX);
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", PATHCHROME);
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(telerikForumUrl);
    }
}
