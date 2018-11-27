package training.ExamplePageObjects.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import training.ExamplePageObjects.pages.*;
import training.ExamplePageObjects.model.Customer;

import java.util.Set;

public class Application {

  private WebDriverWait wait;
  private WebDriver driver;

  private RegistrationPage registrationPage;
  private final AdminPanelLoginPage adminPanelLoginPage;
  private CustomerListPage customerListPage;
  private final ShopPage shopPage;
  private final BasketPage basketPage;
  private final GoodDetailsPage goodDetailsPage;

  public Application() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
    registrationPage = new RegistrationPage(driver);
    adminPanelLoginPage = new AdminPanelLoginPage(driver);
    customerListPage = new CustomerListPage(driver);
    shopPage = new ShopPage(driver);
    basketPage = new BasketPage(driver);
    goodDetailsPage = new GoodDetailsPage(driver);
  }

  public void quit() {
    driver.quit();
  }

  public void registerNewCustomer(Customer customer) {
    registrationPage.open();
    registrationPage.firstnameInput.sendKeys(customer.getFirstname());
    registrationPage.lastnameInput.sendKeys(customer.getLastname());
    registrationPage.address1Input.sendKeys(customer.getAddress());
    registrationPage.postcodeInput.sendKeys(customer.getPostcode());
    registrationPage.cityInput.sendKeys(customer.getCity());
    registrationPage.selectCountry(customer.getCountry());
    registrationPage.selectZone(customer.getZone());
    registrationPage.emailInput.sendKeys(customer.getEmail());
    registrationPage.phoneInput.sendKeys(customer.getPhone());
    registrationPage.passwordInput.sendKeys(customer.getPassword());
    registrationPage.confirmedPasswordInput.sendKeys(customer.getPassword());
    registrationPage.createAccountButton.click();
  }

  public Set<String> getCustomerIds() {
    if (adminPanelLoginPage.open().isOnThisPage()) {
      adminPanelLoginPage.enterUsername("admin").enterPassword("admin").submitLogin();
    }

    return customerListPage.open().getCustomerIds();
  }

  public void login(final String username, final String password){
    adminPanelLoginPage.enterUsername(username).enterPassword(password).submitLogin();
  }

  public void addGoodsToBasket(){
    shopPage.open();
    for (int i = 1; i < 4; i++){
      shopPage.openFirstGood();
      if(goodDetailsPage.isSizeOptionExist()){
        goodDetailsPage.selectSize();
      }
      goodDetailsPage.addToCart(i);
    }
  }

  public void deleteGoods(){
    shopPage.gotoBasket();
    basketPage.deleteGoodsFromCart();
  }

  public String getMessage(){
    return basketPage.getMessage();
  }
}
