package SeleniumTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest  {
    //We should add @Test annotation that JUnit will run below method

    //Start to write our test method. It should ends with "Test"
    public static void main(String [] args){
        //create firefox driver
        WebDriver driver;// = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        driver.close();
        driver.quit();


    }

}