package training;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyFirstTest extends TestBase {

  @Test
  public void myFirstTest(){
    String value = "webdriver";
    driver.navigate().to("https://search.maven.org/classic/");
    wait.until(ExpectedConditions.elementToBeClickable(By.id("query"))).sendKeys(value);
    driver.findElement(By.id("queryButton")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
    String artifactId = driver.findElement(By.xpath("//a[@id='artifactId']")).getText();
    Assert.assertEquals(artifactId, value);

  }
}
