package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[1]/div/div[1]/ul[2]/li[1]/a/span/span")
    public static WebElement button;
}
