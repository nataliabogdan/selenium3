package training.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

class BasePage {
  WebDriver driver;
  WebDriverWait wait;

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

  //areElementsPresent
  public boolean areElementsPresent(final List<WebElement> elements){
    return elements.size() > 0;
  }

  public boolean isElementPresent(final By locator){
    try {
      wait.until((WebDriver d) -> d.findElement(locator));
      //this.driver.findElement(locator);
      return true;
    } catch (InvalidSelectorException ex) {
      throw ex;
    } catch (TimeoutException ex) {
      return false;
    }
  }

}
