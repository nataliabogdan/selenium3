package training;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
  WebDriver driver;
  WebDriverWait wait;

  @Before
  public void start(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 10);
  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
