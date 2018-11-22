package training.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import training.pages.LoginPage;
import training.pages.ShopHomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class TestBase {

  EventFiringWebDriver driver;
  WebDriverWait wait;

  public static class MyListener extends AbstractWebDriverEventListener{

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
    }
  }

  private final String shopURL = "http://localhost/litecart";
  private final String adminURL = "http://localhost/litecart/admin/";

  @Before
  public void start(){
     //full mode
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");

    DesiredCapabilities caps = DesiredCapabilities.chrome();
    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
    caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);


    driver = new EventFiringWebDriver(new ChromeDriver(caps));
    driver.register(new MyListener());
//   неявные ожидания. используется для findElement - заметят появление быстрее. Для присутствия элемента
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    //явное ожидание wait.until().... для отсутсвия
    wait = new WebDriverWait(driver, 10);

//    driver = new FirefoxDriver();
//    driver.manage().window().maximize();
//    wait = new WebDriverWait(driver, 2);


//    InternetExplorerOptions options = new InternetExplorerOptions();
//    options.ignoreZoomSettings();
//    driver = new InternetExplorerDriver(options);
//    driver.manage().window().maximize();
//    wait = new WebDriverWait(driver, 10);
  }

  LoginPage goToAdminPage(){
    this.driver.get(this.adminURL);
    return LoginPage.getNewInstance(this.driver, this.wait);
  }

  //Goto Shop page
  ShopHomePage goToShopPage(){
    this.driver.get(this.shopURL);
    return ShopHomePage.getNewInstance(this.driver, this.wait);
  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
