package pageObjects;

import org.openqa.selenium.*;

//This is a page object class for the Home Screen.
public class HomePage {

 private static WebElement element = null;

 //Button 'Add a new computer'
 public static WebElement btn_Add(WebDriver driver) {

  element = driver.findElement(By.id("add"));

  return element;

 }
 
 //Link 'Play sample application — Computer database'
 public static WebElement lnk_Home(WebDriver driver) {

	  element = driver.findElement(By.xpath("/html/body/header/h1/a"));

	  return element;

	 }

 //Button 'Filter by name'
 public static WebElement btn_Filter(WebDriver driver) {

  element = driver.findElement(By.id("searchsubmit"));

  return element;

 }

//Link 'First element returned after Filtering..'
 public static WebElement lnk_SearchElement(WebDriver driver) {

  element = driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a"));

  return element;

 }

 //Alert Message when Computer id Added, Updated or Deleted
 public static WebElement alrt_Status(WebDriver driver) {

  element = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]"));

  return element;

 }

 //TextBox Filter Computer
 public static WebElement txtbx_Filter(WebDriver driver) {

  element = driver.findElement(By.id("searchbox"));

  return element;

 }

}