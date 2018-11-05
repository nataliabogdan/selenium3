package training.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import training.pages.AdminPage;
import training.pages.HomePage;
import training.pages.LoginPage;

public class TestBase {
  WebDriver driver;
  WebDriverWait wait;

  @Before
  public void start(){
     //full mode
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(ChromeOptions.CAPABILITY, options);
    driver = new ChromeDriver(caps);

//    InternetExplorerOptions options = new InternetExplorerOptions();
//    options.ignoreZoomSettings();
//    driver = new InternetExplorerDriver(options);
//    driver.manage().window().maximize();
//    wait = new WebDriverWait(driver, 10);
  }

  public void loginByAdmin(){
    HomePage homePage = new HomePage(driver,wait);
    homePage.goToLoginPage();
    LoginPage loginPage = new LoginPage(driver,wait);
    loginPage.loginByAdmin();
  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
