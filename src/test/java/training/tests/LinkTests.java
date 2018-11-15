package training.tests;

import org.junit.Test;
import training.pages.AdminPage;
import training.pages.CountryPage;
import training.pages.LoginPage;

public class LinkTests extends TestBase {

  @Test
  public void openLinksInAdmin(){
    LoginPage loginPage = this.goToAdminPage();
    AdminPage adminPage = loginPage.loginByAdmin();
    CountryPage countryPage = adminPage.goToCountryPage();
    countryPage.initNewCountryCreation();
    countryPage.openLinks(countryPage.getExternalLinks());
  }
}
