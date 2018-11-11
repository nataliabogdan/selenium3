package training.tests;

import org.junit.Test;
import training.pages.*;

public class CountiesTests extends TestBase{

  @Test
  public void checkAlphebeticalCounties(){
    LoginPage loginPage = this.goToAdminPage();
    AdminPage adminPage = loginPage.loginByAdmin();
    CountryPage countryPage = adminPage.goToCountryPage();
    countryPage.checkCountries();
    ZonePage zonePage = adminPage.goToZonePage();
    zonePage.getZones();
  }
}
