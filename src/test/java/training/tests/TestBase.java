package training.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import training.pages.LoginPage;
import training.pages.ShopHomePage;

import java.util.concurrent.TimeUnit;

public class TestBase {
  WebDriver driver;
  WebDriverWait wait;

  private final String shopURL = "http://localhost/litecart";
  private final String adminURL = "http://localhost/litecart/admin/";

  @Before
  public void start(){
     //full mode
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(ChromeOptions.CAPABILITY, options);
    driver = new ChromeDriver(caps);
    //неявные ожидания. используется для findElement - заметят появление быстрее. Для присутствия элемента
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    //явное ожидание wait.until().... для отсутсвия
    wait = new WebDriverWait(driver, 2);

//    InternetExplorerOptions options = new InternetExplorerOptions();
//    options.ignoreZoomSettings();
//    driver = new InternetExplorerDriver(options);
//    driver.manage().window().maximize();
//    wait = new WebDriverWait(driver, 10);
  }

  public LoginPage goToAdminPage(){
    this.driver.get(this.adminURL);
    return LoginPage.getNewInstance(this.driver, this.wait);
  }

  //Goto Shop page
  public ShopHomePage goToShopPage(){
    this.driver.get(this.shopURL);
    return ShopHomePage.getNewInstance(this.driver, this.wait);
  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
