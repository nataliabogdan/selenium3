package training.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryPage extends BasePage {

  @FindBy(css = "tr[class*=row]")
  private List<WebElement> rows;
  @FindBy(xpath = "//*[@name='countries_form']")
  private WebElement countryGrid;

  private CountryPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public static CountryPage getNewInstance(WebDriver driver, WebDriverWait wait){
    final CountryPage countryPage = new CountryPage(driver, wait);
    countryPage.waitUntilVisible();
    return countryPage;
  }

  private void waitUntilVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.countryGrid));
  }

  public void checkCountries() {
    List<WebElement> rows = this.rows;
    List<String> displayedCountries = new ArrayList<>();
    List<String> sortedCountries = new ArrayList<>();
    List<String> displayedZones = new ArrayList<>();
    List<String> sortedZones = new ArrayList<>();
    for(int i = 1; i < rows.size(); i++){
      String country = this.driver.findElement(By.xpath("//tr[@class='row'][" + String.valueOf(i) + "]/td[5]")).getText();
      displayedCountries.add(country);
      sortedCountries.add(country);
      String KO = this.driver.findElement(By.xpath("//tr[@class='row'][" + String.valueOf(i) + "]/td[6]")).getText();
      if(!KO.equals("0")) {
        this.driver.findElement(By.xpath("//tr[@class='row'][" + String.valueOf(i) + "]/td[5]/a")).click();
        List<WebElement> rowszone = this.driver.findElements(By.xpath("//*[@id='table-zones']//tr"));
        displayedZones.clear();
        sortedZones.clear();
        for (int j = 2; j < rowszone.size() - 2; j++) {
          String zone = this.driver.findElement(By.xpath("//*[@id='table-zones']//tr[" + String.valueOf(j) + "]/td[3]")).getText();
          displayedZones.add(zone);
          sortedZones.add(zone);
        }
        Collections.sort(sortedZones);
        Assert.assertEquals(sortedZones, displayedZones);
        this.driver.navigate().back();
      }
      Collections.sort(sortedCountries);
      Assert.assertEquals(sortedCountries, displayedCountries);
    }
  }


}
