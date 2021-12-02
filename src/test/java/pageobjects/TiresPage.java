package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TiresPage {
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[2]/span[2]/span")
    public static WebElement heading;

}
