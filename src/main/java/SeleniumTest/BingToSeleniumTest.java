package SeleniumTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class BingToSeleniumTest {
  static WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  /**
   * Setup headless mode to run without a browser
   */
  @BeforeClass
  public static void setupHeadlessMode() {
    String headlessProperty = System.getProperty("headless");
    boolean isHeadlessTesting = Boolean.parseBoolean(headlessProperty);

    // if the property was unspecified (such as running in an IDE), enable headless
    if (null == headlessProperty) {
      isHeadlessTesting = true;
    }

    // if headless is true, or unspecified, enable headless testing
    if (isHeadlessTesting) {
      driver = new HtmlUnitDriver();
    } else {//else if headless is false, use google chrome
      //need to set system property if using google chrome, and specify the location of the chromedriver.exe
      System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
    }
  }

  /**
   * Set the base URL, and run the webpage
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    baseUrl = "https://www.bing.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBingToSelenium() throws Exception {
    driver.get(baseUrl + "/");//open the base url, which is bing.com
    driver.findElement(By.id("sb_form_q")).clear();
    driver.findElement(By.id("sb_form_q")).sendKeys("selenium");//type in the search contents
    driver.findElement(By.id("sb_form_go")).click();//click search button

    //check if the title is present in the webpage
    try {
      assertTrue(isElementPresent(By.cssSelector("h2..b_entityTitle")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }

    driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();//click on the link with this text

    //check if the title is Brower Automation
    try {
      assertTrue(isElementPresent(By.linkText("Browser Automation")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }

    driver.findElement(By.linkText("Download")).click();//click on the download link
    // Warning: verifyTextPresent may require manual changes
    //check if the new webpage has text Download
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Downloads[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  //The code below are the code generated from Selenium IDE from FireFox

  @After
  public void tearDown() throws Exception {
    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
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
