package Pages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    public static WebElement newTopicButton = Browser.driver.findElement(By.id("create-topic"));
    public static WebElement topicTitleBox = Browser.driver.findElement(By.id("reply-title"));
    public static WebElement topicContentBox = Browser.driver.findElement(By.xpath("//textarea[@placeholder='Type here. Use Markdown, BBCode, or HTML to format. Drag or paste images.']"));
    public static WebElement createTopicButton = Browser.driver.findElement(By.xpath("//button[@aria-label=\"Create Topic\"]"));
    public static final String topicTitle = "I like the sea";
    public static final String topicContent = "I like testing with SeleniumWebDriver";

}
