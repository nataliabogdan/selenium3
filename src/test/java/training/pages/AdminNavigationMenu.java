package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class AdminNavigationMenu extends BasePage {

  @FindBy(xpath = "//li[@id = 'app-']")
  private List<WebElement> apps;
  @FindBy(xpath = "//li[@id = 'app-']//li")
  private List<WebElement> subApps;
  @FindBy(tagName = "h1")
  private WebElement header;
  @FindBy(id = "box-apps-menu")
  private WebElement appsBox;

  private AdminNavigationMenu(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public static AdminNavigationMenu getNewInstance(WebDriver driver, WebDriverWait wait){
    final AdminNavigationMenu page = new AdminNavigationMenu(driver, wait);
    page.waitUntilVisible();
    return page;
  }

  private void waitUntilVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.appsBox));
  }

  public void openApps(){
    List<WebElement> list = this.apps;
    for (int i = 0; i < list.size(); i++){
      list.get(i).click();
      assertNotNull("Does h1 tag exist", this.header);
      List<WebElement> sublist = this.subApps;
      for (int j = 1; j < sublist.size(); j++) {
        sublist.get(j).click();
        assertNotNull("Does h1 tag exist?", this.header);
        sublist = this.subApps;
      }
      list = this.apps;
    }
  }
}
