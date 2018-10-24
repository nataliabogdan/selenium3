package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage {

  @FindBy(id = "sidebar")
  private WebElement leftPanel;
  @FindBy(xpath = "//img[@src][@title='My Store']")
  private WebElement logo;
  @FindBy(className = "header")
  private WebElement header;
  @FindBy(id = "box-apps-menu-wrapper")
  private WebElement navigation;
  @FindBy(id = "widget-sales")
  private WebElement widgetSales;
  @FindBy(id = "widget-stats")
  private WebElement widgetStats;
  @FindBy(id = "widget-orders")
  private WebElement widgetOrders;
  @FindBy(id = "widget-addons")
  private WebElement widgetAddons;
  @FindBy(id = "widget-discussions")
  private WebElement widgetDiscussions;
  @FindBy(xpath = "//div[@class='notice success']")
  private WebElement message;

  public AdminPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public Boolean adminElementsIsDisplayed(){
    return this.leftPanel.isDisplayed() &
            this.logo.isDisplayed() &
            this.header.isDisplayed() &
            this.navigation.isDisplayed() &
            this.widgetAddons.isDisplayed() &
            this.widgetDiscussions.isDisplayed() &
            this.widgetOrders.isDisplayed() &
            this.widgetSales.isDisplayed();
  }

  public String getNoticeMessage(){
    return this.message.getText();
  }
}
