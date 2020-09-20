package Pages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class UpperMenu {

    public static WebElement searchButton = Browser.driver.findElement(By.xpath("//li[@class='header-dropdown-toggle search-dropdown']//a[@class='icon btn-flat']//*[local-name()='svg']"));
    public static WebElement profileIcon = Browser.driver.findElement(By.xpath("//a[@class=\"icon\"]"));
    public static WebElement searchTextField = Browser.driver.findElement(By.id("search-term"));
    public static ProfileSubMenu profileSubMenu;


    public static void logOut(){
        profileIcon.click();
        profileSubMenu.profileName.click();
        profileSubMenu.logOutButton.click();
    }

    public static void searchForTopic(String topicTitle) {
        searchButton.click();
        searchTextField.click();
        searchTextField.sendKeys(topicTitle + Keys.ENTER);
    }

}
