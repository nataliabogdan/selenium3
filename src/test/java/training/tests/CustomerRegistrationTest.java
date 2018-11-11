package training.tests;

import org.junit.Assert;
import org.junit.Test;
import training.User;
import training.pages.RegistrationPage;
import training.pages.ShopHomePage;

import static training.pages.BasePage.generateTimeStemp;

public class CustomerRegistrationTest extends TestBase {

  @Test
  public void registerByNewCarrier(){
    final String name = "Alex";
    final String lastname = "Dzikun";
    final String street = "Meininger Allee 15";
    final String code = "89231";
    final String town = "Neu-Ulm";
    final String email = generateTimeStemp() + "@gmail.com";
    final String tel = "+49157575712";
    final String pass = "123";
    final String country = "United States";
    final String state = "Alaska";

    User user = new User().setName(name).setFamilyName(lastname).setStreet(street)
            .setCode(code).setTown(town).setEmail(email).setTel(tel).setPassword(pass).setCountry(country).setState(state);
    ShopHomePage shop = this.goToShopPage();
    RegistrationPage registrationPage = shop.gotoRegistration();
    shop = registrationPage.setData(user);
    Assert.assertTrue(shop.getMessage().contains("Your customer account has been created."));
    shop.logout();
    shop.login(email, pass);
    shop.logout();
  }
}
