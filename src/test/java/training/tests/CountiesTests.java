package training.tests;

import org.junit.Test;
import training.pages.*;

public class CountiesTests extends TestBase{

  @Test
  public void checkAlphebeticalCounties(){
    HomePage homePage = new HomePage(driver,wait);
    homePage.goToLoginPage();
    LoginPage loginPage = new LoginPage(driver,wait);
    loginPage.loginByAdmin();
    AdminPage adminPage = new AdminPage(driver, wait);
    adminPage.goToCountryPage();
    CountryPage countryPage = new CountryPage(driver, wait);
    countryPage.getCountries();
    adminPage.goToZonePage();
    ZonePage zonePage = new ZonePage(driver, wait);
    zonePage.getZones();
  }
}
