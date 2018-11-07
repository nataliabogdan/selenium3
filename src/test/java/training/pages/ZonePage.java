package training.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ZonePage extends BasePage {

  @FindBy(css = "tr[class*=row]")
  private List<WebElement> rows;
  @FindBy(xpath = "//td[3]/select[contains(@name,'[zone_code]')]//option[@selected='selected']")
  private List<WebElement> selectedZones;

  public ZonePage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void getZones() {
    List<WebElement> rows = this.rows;
    List<String> zones = new ArrayList<>();
    List<String> sortedZones = new ArrayList<>();
    for(int i = 1; i <= rows.size(); i++){
      this.driver.findElement(By.xpath("//tr[@class='row'][" + i + "]/td[3]/a")).click();
      zones.clear();
      sortedZones.clear();
      List<WebElement> rowZ = this.selectedZones;
      for(WebElement el: rowZ){
        String zoneText = el.getText();
        zones.add(zoneText);
        sortedZones.add(zoneText);
      }
      Collections.sort(sortedZones);
      Assert.assertEquals(sortedZones, zones);
      this.driver.navigate().back();
    }
  }
}
