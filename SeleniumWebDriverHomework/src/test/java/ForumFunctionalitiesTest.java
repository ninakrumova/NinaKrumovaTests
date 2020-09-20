import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


public class ForumFunctionalitiesTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String telerikForumUrl = "https://stage-forum.telerikacademy.com/";
    private static final String topicTitle = "I like the sea";
    private static final String topicContent = "I like testing with SeleniumWebDriver";
    LocalDateTime dateTime = LocalDateTime.now();

    @BeforeClass
    public static void classInit(){
        System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Courses\\Telerik\\Drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\Documents\\Courses\\Telerik\\Drivers\\geckodriver.exe");
    }

    @Before
    public void testInit() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(telerikForumUrl);
    }

    @Before
    public void testLogIn(){

        WebElement login = driver.findElement(By.xpath("//button[@class=\"widget-button btn btn-primary btn-small login-button btn-icon-text\"]"));
        login.click();

        WebElement emailTextBox = driver.findElement(By.id("Email"));
        emailTextBox.click();
        emailTextBox.sendKeys("ninak_test@abv.bg");

        WebElement password = driver.findElement(By.id("Password"));
        password.click();
        password.sendKeys("@12345678");

        WebElement signInButton = driver.findElement(By.id("next"));
        signInButton.click();
    }

    @Test
    public void telerikForumTopicCreation_When_ForumOpened(){
        WebElement newTopicButton = driver.findElement(By.id("create-topic"));
        newTopicButton.click();

        WebElement topicTitleBox = driver.findElement(By.id("reply-title"));
        topicTitleBox.click();
        topicTitleBox.sendKeys(topicTitle + " " + dateTime.toString());

        WebElement topicContentBox = driver.findElement(By.xpath("//textarea[@placeholder='Type here. Use Markdown, BBCode, or HTML to format. Drag or paste images.']"));
        topicContentBox.click();
        topicContentBox.sendKeys(topicContent +" " + dateTime.toString());

        WebElement createTopicButton = driver.findElement(By.xpath("//button[@aria-label=\"Create Topic\"]"));
        createTopicButton.click();

        Assert.assertTrue("Topic was not created", driver.getPageSource().contains(topicTitle));

        waiting(1000);
    }

    @Test
    public void telerikForumTopicDeletion_When_TopicWasCreated(){
        WebElement searchCreatedTopic = driver.findElement(By.xpath("//li[@class='header-dropdown-toggle search-dropdown']//a[@class='icon btn-flat']//*[local-name()='svg']"));
        searchCreatedTopic.click();

        WebElement searchTextField = driver.findElement(By.id("search-term"));
        searchTextField.click();
        searchTextField.sendKeys(topicTitle + Keys.ENTER);

        WebElement findCreatedTopic = driver.findElement(By.xpath("(//a[@class=\"search-link\"])[1]"));
        findCreatedTopic.click();

        WebElement showMoreButton = driver.findElement(By.xpath("//button[@class=\"widget-button btn-flat show-more-actions no-text btn-icon\"]"));
        showMoreButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[@aria-label=\"delete topic\"]"));
        deleteButton.click();

        Assert.assertTrue("Deletion was not successful", driver.getPageSource().contains("topic withdrawn by author, will be automatically deleted in 24 hours unless flagged"));
    }

    @After
    public void testLogOut(){
        WebElement profileIcon = driver.findElement(By.xpath("//a[@class=\"icon\"]"));
        profileIcon.click();

        waiting(1000);

        WebElement profileName = driver.findElement(By.xpath("//a[@class=\"widget-link user-activity-link\"]"));
        profileName.click();

        waiting(1000);

        WebElement logOut = driver.findElement(By.xpath("//li[@class=\"logout read\"]"));
        logOut.click();

        waiting(1000);

        WebElement login = driver.findElement(By.xpath("//button[@class=\"widget-button btn btn-primary btn-small login-button btn-icon-text\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(login));

        driver.close();
    }

    private void waiting(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
