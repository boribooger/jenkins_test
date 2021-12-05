package tests;

import lombok.extern.log4j.Log4j;
import main.main;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import other.GoogleConstant;
import other.OnlinerConstants;
import pageobjects.HomePage;
import pageobjects.TiresPage;
import steps.Steps;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Log4j
public class FirstTest {
    //public static WebDriver driver;
    public static RemoteWebDriver driver;
    //private static org.apache.log4j.Logger log = Logger.getLogger("test");

    @Parameters("browser")
    @BeforeClass
    public void Start(String browser) throws MalformedURLException {
        log.info(new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(browser.equals("firefox")) {
            capabilities.setCapability("browserName", "firefox");
            capabilities.setCapability("browserVersion", "94.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
        }
        else if(browser.equals("chrome")) {
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "96.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
        }
        else if(browser.equals("opera")) {
            capabilities.setCapability("browserName", "opera");
            capabilities.setCapability("browserVersion", "81.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
        }

        driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, TiresPage.class);
    }

/*    @BeforeSuite
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver", "/Users/one/IdeaProjects/untitled6/drivers/chromedriver");
    }

    @BeforeClass
    public void chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, TiresPage.class);
    }*/

    @AfterMethod
    public void tearDown(){
        //driver.close();

    }
/*    @AfterSuite
    public void tearDownClass(){
        driver.close;
    }*/

    @Test
    public void test1(){
        log.info(new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName());
        assertThat(Steps.openUrl(GoogleConstant.GOOGLE_URL).getCurrentUrl(), is("https://www.google.com/"));
    }

    @Test(enabled = false)
    public void test2(){
        log.info(new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName());
        assertThat(Steps.getElementText(HomePage.button, OnlinerConstants.ONLINER_URL), is("Автомобильные шины"));
    }

    @Test(enabled = false)
    public void test3() throws InterruptedException {
        log.info(new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName());
        assertThat(Steps.clickElement(HomePage.button, TiresPage.heading, OnlinerConstants.ONLINER_URL),
            is("Электроника"));
    }
}
