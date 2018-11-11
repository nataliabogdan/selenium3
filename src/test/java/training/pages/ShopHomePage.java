package training.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ShopHomePage extends BasePage {
  @FindBy(css = "li[class*=product]")
  private List<WebElement> products;
  final String sticker = "div[class*=sticker]";
  @FindBy(id = "page")
  private WebElement page;
  @FindBy(id = "box-campaigns")
  private WebElement campaigns;
  @FindBy(xpath = "//*[@id='box-campaigns']//a[@class='link']")
  private List<WebElement> campaignGoods;

  private ShopHomePage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public static ShopHomePage getNewInstance(WebDriver driver, WebDriverWait wait){
    final ShopHomePage shopHomePage = new ShopHomePage(driver, wait);
    shopHomePage.waitUntilVisible();
    return shopHomePage;
  }

  private void waitUntilVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.page));
    this.wait.until(ExpectedConditions.visibilityOf(this.campaigns));
  }

  public void stickersVerification(){
    List<WebElement> stickers;
    List<WebElement> products = this.products;
    for (WebElement element:products){
      stickers = element.findElements(By.cssSelector(this.sticker));
      Assert.assertEquals(stickers.size(), 1);
    }
  }

  private WebElement findFirstCampaignGood(){
    List<WebElement> goods = this.campaignGoods;
    WebElement firstGood = goods.get(0);
    return firstGood;
  }

  public String getTitle(){
    return findFirstCampaignGood().findElement(By.className("name")).getText();
  }

  public List<String> getPrices(){
    List<String> prices = new ArrayList<>();
    String regularPrice =  findFirstCampaignGood().findElement(By.className("regular-price")).getText();
    String campaignPrice =  findFirstCampaignGood().findElement(By.className("campaign-price")).getText();
    prices.add(regularPrice);
    prices.add(campaignPrice);
    return prices;
  }

  public void checkThatRegularPriceGrayAndCrossed(){
    String regularPriceStyle = findFirstCampaignGood().findElement(By.className("regular-price")).getAttribute("tagName");
    String regularPriceColor = findFirstCampaignGood().findElement(By.className("regular-price")).getCssValue("color");
    Assert.assertTrue(regularPriceStyle.equals("S"));
    Assert.assertTrue(isGray(convertRGB(regularPriceColor, this.driver)));
  }

  public void checkThatCampaignPriceRedAndBold(){
    String campaignPriceStyle =  findFirstCampaignGood().findElement(By.className("campaign-price")).getAttribute("tagName");
    String campaignPriceColor =  findFirstCampaignGood().findElement(By.className("campaign-price")).getCssValue("color");
    Assert.assertTrue(isRed(convertRGB(campaignPriceColor, this.driver)));
    Assert.assertTrue(campaignPriceStyle.equals("STRONG"));
  }

  public void checkThatCampaignPriceMoreThanRegular(){
    String font1 =  findFirstCampaignGood().findElement(By.className("regular-price")).getCssValue("font-size");
    String font2 =  findFirstCampaignGood().findElement(By.className("campaign-price")).getCssValue("font-size");
    Assert.assertTrue(convertFontSize(font2) > convertFontSize(font1));
  }

  public GoodPage openCampaignGood() {
    findFirstCampaignGood().click();
    return GoodPage.getNewInstance(this.driver, this.wait);
  }
}
