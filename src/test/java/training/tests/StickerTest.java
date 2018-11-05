package training.tests;

import org.junit.Test;
import training.pages.ShopHomePage;

public class StickerTest extends TestBase {

  @Test
  public void checkStikers(){
    this.goToShopPage();
    ShopHomePage shop = new ShopHomePage(driver, wait);
    shop.stickersVerification();
  }
}
