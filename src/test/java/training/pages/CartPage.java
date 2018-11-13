package training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage {

  private WebElement row;

  @FindBy(id = "main")
  private WebElement mainId;
  @FindBy(name = "remove_cart_item")
  private WebElement remove;
  @FindBy(id = "box-checkout-summary")
  private List<WebElement> table;
  @FindBy(id = "checkout-cart-wrapper")
  private WebElement message;

  private CartPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public static CartPage getNewInstance(WebDriver driver, WebDriverWait wait){
    final CartPage cartPage = new CartPage(driver, wait);
    cartPage.waitUntilVisible();
    return cartPage;
  }

  private void waitUntilVisible() {
    this.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main")));
  }

  public void deleteGoodsFromCart() {
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
