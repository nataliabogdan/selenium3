package training.ExamplePageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasketPage extends Page {

  @FindBy(name = "remove_cart_item")
  private WebElement remove;
  @FindBy(id = "box-checkout-summary")
  private List<WebElement> table;
  @FindBy(id = "checkout-cart-wrapper")
  private WebElement message;

  public BasketPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public static BasketPage getNewInstance(WebDriver driver){
    final BasketPage basketPage = new BasketPage(driver);
    basketPage.waitUntilVisible();
    return basketPage;
  }

  public void waitUntilVisible() {
    this.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main")));
  }

  public void deleteGoodsFromCart() {
    WebElement row;
    while (this.table.size() > 0) {
      row = this.driver.findElement(By.xpath("//tr[@class='footer']"));
      this.remove.click();
      this.wait.until(ExpectedConditions.stalenessOf(row));
    }
  }

  public String getMessage(){
    return this.message.getAttribute("textContent");
  }
}
