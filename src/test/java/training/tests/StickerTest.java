package training.tests;

import org.junit.Test;
import training.pages.ShopHomePage;

public class StickerTest extends TestBase {

  @Test
  public void checkStikers(){
    ShopHomePage shop = this.goToShopPage();
    shop.stickersVerification();
  }
}
