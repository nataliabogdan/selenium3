package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import training.User;

public class RegistrationPage extends BasePage {
  @FindBy(id = "create-account")
  private WebElement createAccountBox;
  @FindBy(xpath = "//form[@name='customer_form']")
  private WebElement customerForm;
  @FindBy(xpath = "//input[@name='firstname']")
  private WebElement firstname;
  @FindBy(xpath = "//input[@name='lastname']")
  private WebElement lastname;
  @FindBy(xpath = "//input[@name='address1']")
  private WebElement address1;
  @FindBy(xpath = "//input[@name='postcode']")
  private WebElement postcode;
  @FindBy(xpath = "//input[@name='city']")
  private WebElement city;
  @FindBy(xpath = "//input[@name='email']")
  private WebElement email;
  @FindBy(xpath = "//input[@name='phone']")
  private WebElement phone;
  @FindBy(xpath = "//input[@name='password']")
  private WebElement password;
  @FindBy(xpath = "//input[@name='confirmed_password']")
  private WebElement confirmed_password;
  @FindBy(xpath = "//input[@name='captcha']")
  private WebElement captcha;
  @FindBy(xpath = "//button[@type='submit']")
  private WebElement submit;
  @FindBy(xpath = "//select[@name='country_code']")
  private WebElement countryDropdown;
  @FindBy(xpath = "//select[@name='zone_code']")
  private WebElement zoneDropdown;

  RegistrationPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public static RegistrationPage getNewInstance(WebDriver driver, WebDriverWait wait){
    final RegistrationPage registrationPage = new RegistrationPage(driver, wait);
    registrationPage.waitUntilVisible();
    return registrationPage;
  }

  private void waitUntilVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.createAccountBox));
    this.wait.until(ExpectedConditions.visibilityOf(this.customerForm));
  }

  public ShopHomePage setData(final User user){
    type(this.firstname, user.getName());
    type(this.lastname, user.getFamilyName());
    type(this.address1, user.getStreet());
    type(this.postcode, user.getCode());
    type(this.city, user.getTown());
    Select countryselector = new Select(this.countryDropdown);
    countryselector.selectByVisibleText(user.getCountry());
    Select zoneselector = new Select(this.zoneDropdown);
    zoneselector.selectByVisibleText(user.getState());
    type(this.email, user.getEmail());
    type(this.phone, user.getTel());
    type(this.password, user.getPassword());
    type(this.confirmed_password, user.getPassword());
    this.submit.click();
    return ShopHomePage.getNewInstance(this.driver, this.wait);
  }

}
