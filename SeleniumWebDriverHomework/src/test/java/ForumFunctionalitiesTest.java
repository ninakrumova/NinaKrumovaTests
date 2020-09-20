import Pages.*;
import Utils.Browser;
import Utils.Waiting;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDateTime;


public class ForumFunctionalitiesTest {

    private WebDriverWait wait;

    @Before
    public void testInit(){
        Browser.init("chrome");
        wait = new WebDriverWait(Browser.driver, 10);
        LogInPage.logIn.click();
        LogInPage.emailTextBox.click();
        LogInPage.emailTextBox.sendKeys(LogInPage.EMAIL);
        LogInPage.password.click();
        LogInPage.password.sendKeys(LogInPage.PASSWORD);
        LogInPage.signInButton.click();
    }

    @Test
    public void telerikForumTopicCreation_When_ForumOpened(){
        LocalDateTime dateTime = LocalDateTime.now();
        HomePage.newTopicButton.click();
        HomePage.topicTitleBox.click();
        HomePage.topicTitleBox.sendKeys(HomePage.topicTitle + " " + dateTime.toString());
        HomePage.topicContentBox.click();
        HomePage.topicContentBox.sendKeys(HomePage.topicContent +" " + dateTime.toString());
        HomePage.createTopicButton.click();
        Assert.assertTrue("Topic was not created", Browser.driver.getPageSource().contains(HomePage.topicTitle));
    }

    @Test
    public void telerikForumTopicDeletion_When_TopicWasCreated(){
        UpperMenu.searchForTopic(HomePage.topicTitle);
        ResultsPage.findFoundTopic.click();
        TopicPage.showMoreButton.click();
        TopicPage.deleteButton.click();
        Assert.assertTrue("Deletion was not successful", Browser.driver.getPageSource().contains("topic withdrawn by author, will be automatically deleted in 24 hours unless flagged"));
    }

    @After
    public void testLogOut(){
        Waiting.waitFor(1000);
        UpperMenu.profileIcon.click();
        Waiting.waitFor(1000);
        ProfileSubMenu.profileName.click();
        Waiting.waitFor(1000);
        ProfileSubMenu.logOutButton.click();
        Waiting.waitFor(1000);
        wait.until(ExpectedConditions.elementToBeClickable(LogInPage.logIn));
        Browser.driver.close();
    }
}
