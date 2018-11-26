package training.ExamplePageObjects.tests;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import training.ExamplePageObjects.model.Customer;

import static org.junit.Assert.assertTrue;

import java.util.Set;

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
