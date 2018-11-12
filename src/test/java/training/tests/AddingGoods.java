package training.tests;

import org.junit.Assert;
import org.junit.Test;
import training.Product;
import training.pages.AddNewProductPage;
import training.pages.AdminPage;
import training.pages.CatalogPage;
import training.pages.LoginPage;

import java.io.File;

import static training.Product.Currency.USD;
import static training.pages.BasePage.generateTimeStemp;

public class AddingGoods extends TestBase {

  @Test
  public void addGoodsInAdministration(){

    String path = new File("src/main/resources/1.png").getAbsolutePath();

    Product product = new Product().setName("good" + generateTimeStemp()).setCode("124").setQuantity("20").setPath(path)
            .setDateFrom("12112018").setDateTo("12112019").setKeyword("good1").setShortDescription("short description")
            .setLongDescription("long description").setHead("head title").setMeta("meta").setPrice("30").setCurrency(String.valueOf(USD)).setPriceCurrency("35");
    LoginPage loginPage = this.goToAdminPage();
    AdminPage adminPage = loginPage.loginByAdmin();
    CatalogPage catalogPage = adminPage.goToCatalogPage();
    AddNewProductPage newProductPage = catalogPage.initAddNewProfuct();
    catalogPage = newProductPage.fillData(product);
    Assert.assertTrue(catalogPage.getItems().contains(product.getName()));
  }
}
