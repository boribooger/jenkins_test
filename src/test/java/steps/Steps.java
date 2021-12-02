package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.FirstTest;

public class Steps extends FirstTest {

    @Step("Steps.openUrl {str1}")
    public static WebDriver openUrl(String Url){
        driver.get(Url);
        return driver;
    }

    @Step("Steps.getElementText")
    public static String getElementText(WebElement webElement, String Url){
        openUrl(Url);
        return webElement.getText();
    }

    @Step("Steps.clickElement")
    public static String clickElement(WebElement webElementForClick, WebElement webElementForCheck, String Url)
            throws InterruptedException {
        openUrl(Url);
        webElementForClick.click();
        Thread.sleep(5000);
        return webElementForCheck.getText();
    }
}
