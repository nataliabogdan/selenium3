package training.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShopHomePage extends BasePage {
  @FindBy(css = "li[class*=product]")
  private List<WebElement> products;
  final String sticker = "div[class*=sticker]";

  public ShopHomePage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }


  public void stickersVerification(){
    List<WebElement> stickers;
    List<WebElement> products = this.products;
    for (WebElement element:products){
      stickers = element.findElements(By.cssSelector(this.sticker));
      Assert.assertEquals(stickers.size(), 1);
    }
  }



}
