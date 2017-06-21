package SeleniumTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest  {
    //We should add @Test annotation that JUnit will run below method

    //Start to write our test method. It should ends with "Test"
    public static void main(String [] args) throws InterruptedException {
        //create firefox driver
        WebDriver driver;// = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\firefoxdriver\\geckodriver.exe");
//        System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
//        System.out.println(System.getProperty("webdriver.chrome.driver"));
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //open indeed
        driver.get("https://www.indeed.com/");
        //find the what field
        Thread.sleep(2000);//slow down the process
        driver.findElement(By.id("what")).sendKeys("Selenium");

        //find the loaction field
        Thread.sleep(2000);//slow down the process
        driver.findElement(By.id("where")).clear();//clear the current text first
        driver.findElement(By.id("where")).sendKeys("London");//then replace the new text

        //click on find job buttons
        Thread.sleep(2000);//slow down the process
        driver.findElement(By.id("fj")).click();

        //close the pop up
        driver.findElement(By.id("prime-popover-close-button")).click();

        //from job search result page, get page title and jobs count message
        //search count
        driver.getTitle();
        driver.findElement(By.id("searchCount")).getText();
        System.out.println("Title: " + driver.getTitle());
        System.out.println("search count: " + driver.findElement(By.id("searchCount")).getText());
        //driver.close();
        //driver.quit();


    }

}