package Pages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopicPage {

    public static WebElement showMoreButton = Browser.driver.findElement(By.xpath("//button[@class=\"widget-button btn-flat show-more-actions no-text btn-icon\"]"));
    public static WebElement deleteButton = Browser.driver.findElement(By.xpath("//button[@aria-label=\"delete topic\"]"));

}
