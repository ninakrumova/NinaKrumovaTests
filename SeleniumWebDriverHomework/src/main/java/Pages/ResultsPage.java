package Pages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultsPage {

    public static WebElement findFoundTopic = Browser.driver.findElement(By.xpath("(//a[@class=\"search-link\"])[1]"));

}
