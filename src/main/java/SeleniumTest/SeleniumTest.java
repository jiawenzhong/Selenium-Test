package SeleniumTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest  {
    //We should add @Test annotation that JUnit will run below method

    //Start to write our test method. It should ends with "Test"
    public static void main(String [] args){
        //create firefox driver
        WebDriver driver = new FirefoxDriver();
//        System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");

        //open indeed homepage

        //find what field and enter selenium

        //find location field and enter london

        //click on find job button

        //from job search results page, get page title and jobs counts msg

//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        //Step 1- Driver Instantiation: Instantiate driver object as FirefoxDriver
//        driver = new ChromeDriver();

        driver.get("http://www.google.com");
    }
}