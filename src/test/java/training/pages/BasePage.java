package training.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
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

  static int[] convertRGB(String color, WebDriver driver) {
    String[] rgbstr = new String[0];
    Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
    String browserName = cap.getBrowserName().toLowerCase();
    switch (browserName) {
      case "chrome":
        rgbstr = color.replace("rgba(", "")
                .replace(")", "")
                .replace(" ", "")
                .split(",");
        break;
      case "firefox":
        rgbstr = color.replace("rgb(", "")
                .replace(")", "")
                .replace(" ", "")
                .split(",");
        break;
      case "internet explorer":
        rgbstr = color.replace("rgb(", "")
                .replace(")", "")
                .replace(" ", "")
                .split(",");
        break;
    }
    return Arrays.stream(rgbstr).mapToInt(Integer::parseInt).toArray();
  }
  static double convertFontSize(String fontSize){
    return Double.parseDouble(fontSize.replace("px", ""));
  }

  static boolean isGray(int[] colorArr){
    return (colorArr[0] == colorArr[1] && colorArr[1] == colorArr[2]);
  }

  static boolean isRed(int[] colorArr){
    return (colorArr[0] > 0 && colorArr[1] == 0 && colorArr[2] == 0);
  }

  static boolean isGreen(int[] colorArr){
    return (colorArr[1] > 0 && colorArr[0] == colorArr[2] && colorArr[2] == 0);
  }

  static boolean isBlue(int[] colorArr){
    return (colorArr[2] > 0 && colorArr[0] == colorArr[1] && colorArr[1] == 0);
  }

}
