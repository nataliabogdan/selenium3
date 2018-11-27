package training.ExamplePageObjects.tests;

import org.junit.Assert;
import org.junit.Test;

public class CartPageObjectTest extends TestBase2{

  @Test
  public void addingAndRemovingGoodsFromCart(){
    app.addGoodsToBasket();
    app.deleteGoods();
    Assert.assertTrue(app.getMessage().contains("There are no items in your cart."));
  }
}
