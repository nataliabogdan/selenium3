package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import training.Product;

import static training.Product.Currency.EURO;

public class AddNewProductPage extends BasePage {

  @FindBy(xpath = "//form[@method='post']")
  private WebElement form;
  @FindBy(xpath = "//input[@value='1'][@type='radio']")
  private WebElement enabled;
  @FindBy(xpath = "//input[@value='0'][@type='radio']")
  private WebElement disabled;
  @FindBy(xpath = "//input[@name='name[en]']")
  private WebElement name;
  @FindBy(name = "code")
  private WebElement code;
  @FindBy(xpath = "//input[@value='1-2']")
  private WebElement female;
  @FindBy(xpath = "//input[@value='1-1']")
  private WebElement male;
  @FindBy(xpath = "//input[@value='1-3']")
  private WebElement unisex;
  @FindBy(name = "quantity")
  private WebElement quantity;
  @FindBy(name = "new_images[]")
  private WebElement image;
  @FindBy(name = "date_valid_from")
  private WebElement dateFrom;
  @FindBy(name = "date_valid_to")
  private WebElement dateTo;
  @FindBy(xpath = "//a[text()='Information']")
  private WebElement informationTabBtn;
  @FindBy(id = "tab-information")
  private WebElement infoTab;
  @FindBy(name = "manufacturer_id")
  private WebElement manufacter;
  @FindBy(name = "keywords")
  private WebElement keywords;
  @FindBy(name = "short_description[en]")
  private WebElement shortDescription;
  @FindBy(name = "description[en]")
  private WebElement longDescription;
  @FindBy(name = "head_title[en]")
  private WebElement head;
  @FindBy(name = "meta_description[en]")
  private WebElement meta;
  @FindBy(xpath = "//a[text()='Prices']")
  private WebElement pricesTabBtn;
  @FindBy(id = "tab-prices")
  private WebElement pricesTab;
  @FindBy(name = "purchase_price")
  private WebElement price;
  @FindBy(name = "purchase_price_currency_code")
  private WebElement currency;
  @FindBy(name = "prices[EUR]")
  private WebElement priceEuro;
  @FindBy(name = "prices[USD]")
  private WebElement priceUSD;
  @FindBy(name = "save")
  private WebElement saveBtn;


  AddNewProductPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public static AddNewProductPage getNewInstance(WebDriver driver, WebDriverWait wait){
    AddNewProductPage addNewProductPage = new AddNewProductPage(driver, wait);
    addNewProductPage.waitUntilVisible();
    return addNewProductPage;
  }

  private void waitUntilVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.form));

  }

  public CatalogPage fillData(Product product){
    this.fillGeneralInfo(product);
    this.gotoInformmationTab();
    this.fillInformationInfo(product);
    this.gotoPricesTab();
    this.fillPricesInfo(product);
    this.saveBtn.click();
    return CatalogPage.getNewInstance(this.driver, this.wait);
  }

  private void fillGeneralInfo(Product product){
    this.enabled.click();
    type(this.name, product.getName());
    type(this.code, product.getCode());
    this.male.click();
    type(this.quantity, product.getQuantity());
    this.image.sendKeys(product.getPath());
    this.dateFrom.click();
    this.dateFrom.sendKeys(product.getDateFrom());
    this.dateTo.click();
    this.dateTo.sendKeys(product.getDateTo());
  }

  private void gotoInformmationTab(){
    this.informationTabBtn.click();
    this.wait.until(ExpectedConditions.visibilityOf(this.infoTab));
  }

  private void fillInformationInfo(Product product){
    Select man = new Select(this.manufacter);
    man.selectByVisibleText("ACME Corp.");
    type(this.keywords, product.getKeyword());
    type(this.shortDescription, product.getShortDescription());
    type(this.longDescription, product.getLongDescription());
    type(this.head, product.getHead());
    type(this.meta, product.getMeta());
  }

  private void gotoPricesTab(){
    this.pricesTabBtn.click();
    this.wait.until(ExpectedConditions.visibilityOf(this.pricesTab));
  }

  private void fillPricesInfo(Product product){
    type(this.price, product.getPrice());
    Select cur = new Select(this.currency);
    cur.selectByVisibleText(product.getCurrency());
    if (product.getCurrency().equals(String.valueOf(EURO))){
      type(this.priceEuro, product.getPriceCurrency());
    } else {
      type(this.priceUSD, product.getPriceCurrency());
    }
  }
}
