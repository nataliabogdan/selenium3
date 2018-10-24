package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
  WebDriver driver;
  private WebDriverWait wait;

  //Constructor
  BasePage(WebDriver driver, WebDriverWait wait){
    PageFactory.initElements(driver, this);
    this.driver = driver;
    this.wait = wait;
  }

  //Click Method
  void type(WebElement element, String text) {
    element.click();
    element.clear();
    element.sendKeys(text);
  }
}
