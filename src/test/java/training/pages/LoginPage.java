package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

  private String user = "admin";
  private String password = "admin";

  @FindBy(xpath = "//input[@name='username']")
  private WebElement usernameInput;
  @FindBy(name = "password")
  private WebElement passwordInput;
  @FindBy(name = "login")
  private WebElement loginBtn;

  private LoginPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public static LoginPage getNewInstance(WebDriver driver, WebDriverWait wait){
    final LoginPage loginPage = new LoginPage(driver, wait);
    loginPage.waitUntilVisible();
    return loginPage;
  }

  private void waitUntilVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.usernameInput));
  }

  public AdminPage loginByAdmin(){
    this.type(this.usernameInput, user);
    this.type(this.passwordInput, password);
    this.loginBtn.click();
    return AdminPage.getNewInstance(this.driver, this.wait);
  }
}
