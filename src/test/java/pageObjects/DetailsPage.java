package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DetailsPage {

 private static WebElement element = null;

 //TextBox 'Computer Name'
 public static WebElement txtbx_Name(WebDriver driver) {

  element = driver.findElement(By.id("name"));

  return element;

 }

 //Text Box 'Introduced Date'
 public static WebElement txtbx_startDate(WebDriver driver) {

  element = driver.findElement(By.id("introduced"));

  return element;

 }

 //Text Box 'Discontinued Date'
 public static WebElement txtbx_endDate(WebDriver driver) {

  element = driver.findElement(By.id("discontinued"));

  return element;

 }

 //List 'Company'
 public static Select lst_Company(WebDriver driver) {

  Select dropdown = new Select(driver.findElement(By.id("company")));

  return dropdown;

 }

 //Button 'Create this Computer'
 public static WebElement btn_Create(WebDriver driver) {

  element = driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/input"));

  return element;

 }

 //Button 'Delete this Computer'
 public static WebElement btn_Delete(WebDriver driver) {

  element = driver.findElement(By.xpath("//*[@id=\"main\"]/form[2]/input"));

  return element;

 }

 //Button 'Save this Computer'
 public static WebElement btn_Save(WebDriver driver) {

  element = driver.findElement(By.xpath("//*[@id=\"main\"]/form[1]/div/input"));

  return element;

 }



}