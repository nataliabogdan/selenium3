package training.tests;

import org.junit.Assert;
import org.junit.Test;
import training.pages.CartPage;
import training.pages.GoodPage;
import training.pages.ShopHomePage;

public class CartTest extends TestBase {
  private GoodPage goodPage;

  @Test
  public void addingAndRemovingGoodsFromCart(){
    ShopHomePage shop = this.goToShopPage();
    for (int i = 1; i < 3; i++){
      goodPage = shop.findFirstGoodAndOpenIt();
      if(goodPage.isSizeOptionExist()){
        goodPage.selectSize();
      }
      goodPage.addToCart(i);
    }
    CartPage cartPage = goodPage.gotoCartPage();
    cartPage.deleteGoodsFromCart();
    Assert.assertTrue(cartPage.getMessage().contains("There are no items in your cart."));
  }
}
