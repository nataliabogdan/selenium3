package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

  private final String baseURL = "http://localhost/litecart/admin/";

  public HomePage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  //Goto Admin page
  public void goToLoginPage(){
    this.driver.get(baseURL);
  }
}
