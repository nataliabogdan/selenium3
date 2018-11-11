package training.tests;

import org.junit.Assert;
import org.junit.Test;
import training.pages.GoodPage;
import training.pages.ShopHomePage;

import java.util.List;

public class GoodsCampaignsVerification extends TestBase{

  @Test
  public void checkThatCorrectGoodsPageDisplayed(){
    ShopHomePage shop = this.goToShopPage();
    String titleGoodsMain = shop.getTitle();
    List<String> priceGoodsMain = shop.getPrices();

    shop.checkThatRegularPriceGrayAndCrossed();
    shop.checkThatCampaignPriceRedAndBold();
    shop.checkThatCampaignPriceMoreThanRegular();

    GoodPage goodPage = shop.openCampaignGood();
    String titleGoodPage = goodPage.getTitle();
    Assert.assertEquals(titleGoodsMain, titleGoodPage);
    List<String> priceGoodsPage = goodPage.getPrices();
    Assert.assertEquals(priceGoodsMain, priceGoodsPage);

    goodPage.checkThatRegularPriceGrayAndCrossed();
    goodPage.checkThatCampaignPriceRedAndBold();
    goodPage.checkThatCampaignPriceMoreThanRegular();
  }
}
