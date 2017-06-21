1. Set up gradle dependencies
 
// Selenium Client & WebDriver Language Bindings: in java
testCompile group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '3.4.0'

// Selenium standalone webdriver
testCompile group: 'org.seleniumhq.selenium', name: 'selenium-server', version: '3.4.0'

// WebDriver for using google chrome as browser for tests
testCompile group: 'org.seleniumhq.selenium', name: 'selenium-chrome-driver', version: '3.4.0'

==================================================================================================

2. Download chromedriver to use google chrome

LINK: https://sites.google.com/a/chromium.org/chromedriver/downloads

In order to use chrome driver, before initializing the WebDriver:
  need to set System property to : "webdriver.chrome.driver", "$path\\chromedriver.exe"

==================================================================================================
3. User Selenium IDE

Selenium IDE only works on Firefox, it is use to identify the id or the name of the element 
that is being located during the test.

Download extension or plugin in FireFox, choose to open in pop up

It alows you to record your actions when browsing the web, and create commands such as assert 
and verify to test if the web application is performing in the expected way. 

Selenium IDE also allow you to export the recorded commands into other programming languages.
From then, you could modify the generated code from the IDE in your own way. 

==================================================================================================
4. To run headless mode

Use HtmlUnitDriver, initialize WebDriver to HtmlUnitDriver, and the test will run without any 
pop ups. 

# SeleniumTest
