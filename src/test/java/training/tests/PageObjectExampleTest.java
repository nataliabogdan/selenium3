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
import training.TestBase2;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RunWith(DataProviderRunner.class)
public class PageObjectExampleTest extends TestBase2 {

  @Test
  @UseDataProvider(value = "validCustomers", location = DataProviders.class)
  public void canRegisterCustomer(Customer customer) {
    Set<String> oldIds = app.getCustomerIds();
    app.registerNewCustomer(customer);
    Set<String> newIds = app.getCustomerIds();
    assertTrue(newIds.containsAll(oldIds));
    assertTrue(newIds.size() == oldIds.size() + 1);
  }




}
