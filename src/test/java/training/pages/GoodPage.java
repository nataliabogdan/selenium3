package training.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GoodPage extends BasePage {


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

  private GoodPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public static GoodPage getNewInstance(WebDriver driver, WebDriverWait wait){
    final GoodPage goodPage = new GoodPage(driver, wait);
    goodPage.waitUntilVisible();
    return goodPage;
  }

  private void waitUntilVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.productBox));
    this.wait.until(ExpectedConditions.visibilityOf(this.similarProductBox));
  }

  public String getTitle(){
    return this.productBox.findElement(By.cssSelector("h1.title")).getText();
  }

  public List<String> getPrices(){
    List<String> prices = new ArrayList<>();
    String regularPrice =  this.productBox.findElement(By.className("regular-price")).getText();
    String campaignPrice =  this.productBox.findElement(By.className("campaign-price")).getText();
    prices.add(regularPrice);
    prices.add(campaignPrice);
    return prices;
  }

  public void checkThatRegularPriceGrayAndCrossed(){
    String regularPriceStyle = this.productBox.findElement(By.className("regular-price")).getAttribute("tagName");
    String regularPriceColor = this.productBox.findElement(By.className("regular-price")).getCssValue("color");
    Assert.assertTrue(regularPriceStyle.equals("S"));
    Assert.assertTrue(isGray(convertRGB(regularPriceColor, this.driver)));
  }

  public void checkThatCampaignPriceRedAndBold(){
    String campaignPriceStyle =  this.productBox.findElement(By.className("campaign-price")).getAttribute("tagName");
    String campaignPriceColor =  this.productBox.findElement(By.className("campaign-price")).getCssValue("color");
    Assert.assertTrue(isRed(convertRGB(campaignPriceColor, this.driver)));
    Assert.assertTrue(campaignPriceStyle.equals("STRONG"));
  }

  public void checkThatCampaignPriceMoreThanRegular(){
    String font1 =  this.productBox.findElement(By.className("regular-price")).getCssValue("font-size");
    String font2 =  this.productBox.findElement(By.className("campaign-price")).getCssValue("font-size");
    Assert.assertTrue(convertFontSize(font2) > convertFontSize(font1));
  }

  public ShopHomePage addToCart(int i){
    this.addToCart.click();
    this.wait.until(ExpectedConditions.textToBe(By.cssSelector(this.quantityCart), String.valueOf(i)));
    this.driver.navigate().back();
    return ShopHomePage.getNewInstance(this.driver, this.wait);
  }

  public CartPage gotoCartPage(){
    this.cart.click();
    return CartPage.getNewInstance(this.driver, this.wait);
  }

  public boolean isSizeOptionExist(){
    return this.sizeOption.size() > 0;
  }

  public void selectSize(){
    Select option = new Select(this.driver.findElement(By.name("options[Size]")));
    option.selectByVisibleText("Small");
  }
}
