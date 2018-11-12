package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

  CatalogPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public static CatalogPage getNewInstance(WebDriver driver, WebDriverWait wait){
    final CatalogPage catalogPage = new CatalogPage(driver, wait);
    catalogPage.waitUntilVisible();
    return catalogPage;
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
