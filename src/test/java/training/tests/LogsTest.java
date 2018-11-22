package training.tests;

import org.junit.Assert;
import org.junit.Test;
import training.pages.AdminPage;
import training.pages.CatalogPage;
import training.pages.LoginPage;

import java.util.List;

public class LogsTest extends TestBase {

//  @Test
//  public void getBrowserLogs(){
//    driver.navigate().to("http://selenium2.ru");
//    System.out.println(driver.manage().logs().getAvailableLogTypes());
//    driver.manage().logs().get("performance").forEach(System.out::println);
//  }

  @Test
  public void verifyMessagesInBrowser(){
    LoginPage loginPage = this.goToAdminPage();
    AdminPage adminPage = loginPage.loginByAdmin();
    CatalogPage catalogPage = adminPage.goToCatalogPage();
    catalogPage.openCategory();
    List<String> logs = catalogPage.getLogsFromCurrentPage();
    Assert.assertEquals(0, logs.size());
  }
}
