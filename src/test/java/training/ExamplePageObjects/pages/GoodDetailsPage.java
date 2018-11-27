package training.ExamplePageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GoodDetailsPage extends Page {

  @FindBy(id = "box-product")
  private WebElement productBox;
  @FindBy(id = "box-similar-products")
  private WebElement similarProductBox;
  @FindBy(name = "add_cart_product")
  private WebElement addToCart;
  private String quantityCart  = "span.quantity";
  @FindBy(xpath = "//a[text()='Checkout »']")
  private WebElement cart;
  @FindBy(name = "options[Size]")
  List<WebElement> sizeOption;

  public GoodDetailsPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public static GoodDetailsPage getNewInstance(WebDriver driver){
    final GoodDetailsPage goodDetailsPage = new GoodDetailsPage(driver);
    goodDetailsPage.waitUntilVisible();
    return goodDetailsPage;
  }

  private void waitUntilVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.productBox));
    this.wait.until(ExpectedConditions.visibilityOf(this.similarProductBox));
  }

  public boolean isSizeOptionExist(){
    return this.sizeOption.size() > 0;
  }

  public void selectSize(){
    Select option = new Select(this.driver.findElement(By.name("options[Size]")));
    option.selectByVisibleText("Small");
  }

  public ShopPage addToCart(int i){
    this.addToCart.click();
    this.wait.until(ExpectedConditions.textToBe(By.cssSelector(this.quantityCart), String.valueOf(i)));
    this.driver.navigate().back();
    return ShopPage.getNewInstance(this.driver);
  }
}
