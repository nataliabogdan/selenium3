package training.ExamplePageObjects.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import training.ExamplePageObjects.pages.AdminPanelLoginPage;
import training.ExamplePageObjects.model.Customer;
import training.ExamplePageObjects.pages.CustomerListPage;
import training.ExamplePageObjects.pages.RegistrationPage;

import java.util.Set;

public class Application {

  private WebDriverWait wait;
  private WebDriver driver;

  private RegistrationPage registrationPage;
  private final AdminPanelLoginPage adminPanelLoginPage;
  private CustomerListPage customerListPage;

  public Application() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
    registrationPage = new RegistrationPage(driver);
    adminPanelLoginPage = new AdminPanelLoginPage(driver);
    customerListPage = new CustomerListPage(driver);
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
}
