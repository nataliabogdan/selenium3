package training.tests;

import org.junit.Test;
import training.pages.AdminNavigationMenu;
import training.pages.LoginPage;

public class NavigationByMenuTest extends TestBase {

  @Test
  public void openAllAppsByAdmin(){
    LoginPage loginPage = this.goToAdminPage();
    loginPage.loginByAdmin();
    AdminNavigationMenu navigationMenu = AdminNavigationMenu.getNewInstance(this.driver, this.wait);
    navigationMenu.openApps();
  }
}
