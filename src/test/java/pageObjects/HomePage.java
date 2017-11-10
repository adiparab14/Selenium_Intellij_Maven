package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



//This is a page object class for the Home Screen.
public class HomePage {

 private WebElement element = null;
 String driverpath = "C:\\Users\\PA2771\\workspace\\";

 //Button 'Add a new computer'
 public WebElement btn_Add(WebDriver driver) {

  element = driver.findElement(By.id("add"));

  return element;

 }
 
 //Link 'Play sample application � Computer database'
 public WebElement lnk_Home(WebDriver driver) {

	  element = driver.findElement(By.xpath("/html/body/header/h1/a"));

	  return element;

	 }

 //Button 'Filter by name'
 public WebElement btn_Filter(WebDriver driver) {

  element = driver.findElement(By.id("searchsubmit"));

  return element;

 }

//Link 'First element returned after Filtering..'
 public WebElement lnk_SearchElement(WebDriver driver) {

  element = driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a"));

  return element;

 }

 //Alert Message when Computer id Added, Updated or Deleted
 public WebElement alrt_Status(WebDriver driver) {

  element = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]"));

  return element;

 }

 //TextBox Filter Computer
 public WebElement txtbx_Filter(WebDriver driver) {

  element = driver.findElement(By.id("searchbox"));

  return element;

 }
 
 public void startBrowser(WebDriver driver) {
	 
	  //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	  ChromeDriverManager.getInstance().setup();	
	 
	  driver = new ChromeDriver();

	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	  driver.get("http://computer-database.herokuapp.com/computers");
	  System.out.println("The webpage is opened in the Browser.");

	 }

}
