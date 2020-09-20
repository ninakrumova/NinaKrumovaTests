package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utils.Browser;

import java.util.concurrent.TimeUnit;

public class LogInPage {

    public final static String EMAIL = "ninak_test@abv.bg";
    public final static String PASSWORD = "@12345678";
    public static WebElement logIn = Browser.driver.findElement(By.xpath("//button[@class=\"widget-button btn btn-primary btn-small login-button btn-icon-text\"]"));
    public static WebElement emailTextBox = Browser.driver.findElement(By.id("Email"));
    public static WebElement password = Browser.driver.findElement(By.id("Password"));
    public static WebElement signInButton = Browser.driver.findElement(By.id("next"));

}
