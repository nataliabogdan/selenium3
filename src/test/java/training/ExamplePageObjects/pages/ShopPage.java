package training.ExamplePageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShopPage extends Page{

  @FindBy(xpath = "(//li[@class='product column shadow hover-light'])[1]")
  private WebElement firstGood;
  @FindBy(name = "options[Size]")
  List<WebElement> sizeOption;
  @FindBy(name = "add_cart_product")
  private WebElement addToCart;
  private String quantityCart  = "span.quantity";
  @FindBy(xpath = "//a[text()='Checkout »']")
  private WebElement cart;
  @FindBy(id = "page")
  private WebElement page;
  @FindBy(id = "box-campaigns")
  private WebElement campaigns;

  public ShopPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public static ShopPage getNewInstance(WebDriver driver){
    final ShopPage shopPage = new ShopPage(driver);
    shopPage.waitUntilVisible();
    return shopPage;
  }

  private void waitUntilVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.page));
    this.wait.until(ExpectedConditions.visibilityOf(this.campaigns));
  }

  public void open() {
    driver.get("http://localhost/litecart");
  }

  public void openFirstGood(){
    this.firstGood.click();
  }

  public void gotoBasket(){
    this.cart.click();
  }
}
