package training;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyFirstTest extends TestBase {

  @Test
  public void myFirstTest(){
    String value = "webdriver";
    driver.navigate().to("https://search.maven.org/");
    wait.until(ExpectedConditions.elementToBeClickable(By.id("mat-input-1"))).sendKeys(value + Keys.ENTER);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-result")));
    String artifactId = driver.findElement(By.xpath("//td[contains(@class, 'cdk-column-artifactId')]//a")).getText();
    Assert.assertEquals(artifactId, value);




  }
}
