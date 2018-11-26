package training;
import com.tngtech.java.junit.dataprovider.DataProvider;

public class DataProviders {
  @DataProvider
  public static Object[][] validCustomers() {
    return new Object[][] {
            { Customer.newEntity()
                    .withFirstname("Adam").withLastname("Smith").withPhone("+0123456789")
                    .withAddress("Hidden Place").withPostcode("12345").withCity("New City")
                    .withCountry("US").withZone("Alaska")
                    .withEmail("adam"+System.currentTimeMillis()+"@smith.me")
                    .withPassword("qwerty").build() },
            /* ... */
    };
  }
}
