package Pages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProfileSubMenu {

    public static WebElement profileName = Browser.driver.findElement(By.xpath("//a[@class=\"widget-link user-activity-link\"]"));
    public static WebElement logOutButton = Browser.driver.findElement(By.xpath("//li[@class=\"logout read\"]"));

}
