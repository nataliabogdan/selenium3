package training.tests;

import org.junit.Test;
import training.pages.AdminPage;
import training.pages.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends TestBase {

  @Test
  public void loginByAdmin(){
    LoginPage loginPage = this.goToAdminPage();
    AdminPage adminPage = loginPage.loginByAdmin();
    assertTrue("All admin elements on page are displayed", adminPage.adminElementsIsDisplayed());
    assertEquals(adminPage.getNoticeMessage(), "You are now logged in as admin");
  }
}
