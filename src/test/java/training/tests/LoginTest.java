package training.tests;

import org.junit.Assert;
import org.junit.Test;
import training.pages.AdminPage;
import training.pages.HomePage;
import training.pages.LoginPage;

public class LoginTest extends TestBase {

  @Test
  public void loginByAdmin(){
    HomePage homePage = new HomePage(driver,wait);
    homePage.goToLoginPage();
    LoginPage loginPage = new LoginPage(driver,wait);
    loginPage.loginByAdmin();
    AdminPage adminPage = new AdminPage(driver, wait);
    Assert.assertTrue("All admin elements on page are displayed", adminPage.adminElementsIsDisplayed());
    Assert.assertEquals(adminPage.getNoticeMessage(), "You are now logged in as admin");
  }
}
