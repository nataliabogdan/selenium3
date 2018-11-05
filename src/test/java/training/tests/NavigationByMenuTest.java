package training.tests;

import org.junit.Test;
import training.pages.AdminNavigationMenu;

public class NavigationByMenuTest extends TestBase {

  @Test
  public void openAllAppsByAdmin(){
    this.loginByAdmin();
    AdminNavigationMenu navigationMenu = new AdminNavigationMenu(driver, wait);
    navigationMenu.openApps();
  }

}
