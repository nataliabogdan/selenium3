package training.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends BasePage {

  @FindBy(name = "catalog_form")
  private WebElement cataloogForm;
  @FindBy(xpath = "//a[@class='button'][contains(@href, 'edit_product')]")
  private WebElement addNewProductBtn;
  @FindBy(className = "notice success")
  private WebElement notice;
  @FindBy(xpath = "//td/a[contains(@href,'product')][text()]")
  private List<WebElement> products;
  private String category = "http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1";
  @FindBy(xpath = "//tr[contains(@class,'row')]/td[3]/a[contains(@href,'edit')]")
  private List<WebElement> goods;

  CatalogPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public static CatalogPage getNewInstance(WebDriver driver, WebDriverWait wait){
    final CatalogPage catalogPage = new CatalogPage(driver, wait);
    catalogPage.waitUntilVisible();
    return catalogPage;
  }

  public void openCategory(){
    this.driver.findElement(By.xpath("//a[@href = '"+ category+"']")).click();
  }

  public  List<String> getLogsFromNewTab(){
    List<WebElement> goodList = this.goods;
    List<String> logs = new ArrayList<>();
    for (WebElement element : goodList) {
      ((JavascriptExecutor) driver).executeScript("window.open('" + element.getAttribute("href")+"', 'new_window')");
      for(LogEntry l : driver.manage().logs().get("browser").getAll()){
        logs.add(l.toString()+ "\n");
      }
      this.driver.switchTo().window("new_window");
      List<String> tabs = new ArrayList<>(this.driver.getWindowHandles());
      this.driver.close();
      this.driver.switchTo().window(tabs.get(0));
    }
    return logs;
  }

  public  List<String> getLogsFromCurrentPage(){
    List<WebElement> goodList = this.goods;
    List<String> logs = new ArrayList<>();
    for (int i = 0; i < goodList.size(); i++) {
      goodList.get(i).click();
      for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
        logs.add(l.toString() + "\n");
      }
      this.driver.navigate().back();
    }
    return logs;
  }

  private void waitUntilVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.cataloogForm));
  }

  public AddNewProductPage initAddNewProfuct(){
    this.addNewProductBtn.click();
    return AddNewProductPage.getNewInstance(this.driver, this.wait);
  }

  public List<String> getItems(){
    List<WebElement> list = this.products;
    List<String> titles = new ArrayList<>();
    for(WebElement element:list){
      titles.add(element.getText());
    }
    return titles;
  }
}
