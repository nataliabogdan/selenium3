package training.tests;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import training.Customer;
import training.DataProviders;

@RunWith(DataProviderRunner.class)
public class PageObjectExampleTest extends TestBase {

  @Test
  @UseDataProvider(value = "validCustomers", location = DataProviders.class)
  public void canRegisterCustomer(Customer customer) {
    
    driver.get("http://localhost/litecart/en/create_account");

    driver.findElement(By.name("firstname")).sendKeys(customer.getFirstname());
    driver.findElement(By.name("lastname")).sendKeys(customer.getLastname());
    driver.findElement(By.name("address1")).sendKeys(customer.getAddress());
    driver.findElement(By.name("postcode")).sendKeys(customer.getPostcode());
    driver.findElement(By.name("city")).sendKeys(customer.getCity());

    driver.findElement(By.cssSelector("[id ^= select2-country_code]")).click();
    driver.findElement(By.cssSelector(String.format(".select2-results__option[id $= %s", customer.getCountry()))).click();
    wait.until((WebDriver d) -> d.findElement(By.cssSelector("select[name=zone_code] option[value=KS]")));

    Select zoneselector = new Select(driver.findElement(By.xpath("//select[@name='zone_code']")));
    zoneselector.selectByVisibleText(customer.getZone());

    driver.findElement(By.name("email")).sendKeys(customer.getEmail());
    driver.findElement(By.name("phone")).sendKeys(customer.getPhone());
    driver.findElement(By.name("password")).sendKeys(customer.getPassword());
    driver.findElement(By.name("confirmed_password")).sendKeys(customer.getPassword());
    driver.findElement(By.name("create_account")).click();




  }
}
