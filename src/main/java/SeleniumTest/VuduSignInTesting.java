package SeleniumTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class VuduSignInTesting {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.vudu.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testVuduSignInTesting() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Deals")).click();
    driver.findElement(By.cssSelector("button.gwt-Button.row-button-viewAll")).click();
    driver.findElement(By.xpath("//img[@alt='Pacific Rim']")).click();
    driver.findElement(By.cssSelector("div.cast-poster-border > img.gwt-Image")).click();
    driver.findElement(By.cssSelector("div.border > img.gwt-Image")).click();
    driver.findElement(By.xpath("//div[@id='widgetContainer']/div/div/div/div[3]/div[2]/div/div/div[3]/div[2]/div")).click();
    driver.findElement(By.cssSelector("div.vudu-star-ratings-comm")).click();
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.cssSelector("td.custom-button-center")).click();
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*This email is not valid[\\s\\S]*$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
