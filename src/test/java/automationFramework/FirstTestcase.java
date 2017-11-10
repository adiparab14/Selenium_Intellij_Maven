package automationFramework;

import pageObjects.*;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestcase {

 //Location of the Chrome Driver for Selenium.
 String driverpath = "C:\\Users\\PA2771\\workspace\\";

 public static WebDriver driver = null;

 @BeforeSuite
 public static void setUp(){
	HomePage Page = new HomePage();
    Page.startBrowser(driver);
 }

 @Test(priority = 1)
 @Parameters({
  "Name",
  "startDate",
  "endDate",
  "Company"
 })
 public void addComputer(String Name, String startDate, String endDate, String Company) throws Exception {

  try {
	  
	  HomePage HPage = new HomePage();
	  DetailsPage Dpage = new DetailsPage();
	  
	  getscreenshot(); 
	  
	  HPage.btn_Add(driver).click();
	
	  Dpage.txtbx_Name(driver).sendKeys(Name);
	  Dpage.txtbx_startDate(driver).sendKeys(startDate);
	  Dpage.txtbx_endDate(driver).sendKeys(endDate);
	
	  if (Company != "") {
		  Dpage.lst_Company(driver).selectByValue(Company);
	  }
	
	  Dpage.btn_Create(driver).click();
	
	  String a = HPage.alrt_Status(driver).getText();
	  assertEquals(a, "Done! Computer " + Name + " has been created");
	  
	  System.out.println("Computer "+Name+" has been added correctly.");
} catch (Exception e) {

	 System.out.println("Required elements not found on the screen. Returning to home screen.");
	 HomePage HPage = new HomePage();
	 HPage.lnk_Home(driver).click();
	 throw(e);
}
 }
 
 @Test(priority = 2)
 @Parameters({
  "UName",
  "startDate",
  "endDate",
  "Company"
 })
 /*public void updComputer(String UName, String startDate, String endDate, String Company) throws Exception {

  try {
	  HomePage.txtbx_Filter(driver).sendKeys(UName);
	  HomePage.btn_Filter(driver).click();
	  HomePage.lnk_SearchElement(driver).click();
	
	  String Comp = DetailsPage.txtbx_Name(driver).getAttribute("value");
	  DetailsPage.txtbx_Name(driver).sendKeys("Upd");
	  DetailsPage.txtbx_startDate(driver).clear();
	  DetailsPage.txtbx_startDate(driver).sendKeys(startDate);
	  DetailsPage.txtbx_endDate(driver).clear();
	  DetailsPage.txtbx_endDate(driver).sendKeys(endDate);
	
	  if (Company != "") {
	   DetailsPage.lst_Company(driver).selectByValue(Company);
	  }
	  
	  DetailsPage.btn_Save(driver).click();
	
	  String a = HomePage.alrt_Status(driver).getText();
	  assertEquals(a, "Done! Computer " + Comp + "Upd" + " has been updated");
	  
	  System.out.println("Computer "+Comp + "Upd" +" has been updated correctly.");
} catch (Exception e) {

	System.out.println("Required elements not found on the screen. Returning to home screen.");
	HomePage.lnk_Home(driver).click();
	throw(e);
}
 }

 @Test(priority = 3)
 @Parameters({
  "DName"
 })
 public void delComputer(String DName) {

  HomePage.txtbx_Filter(driver).sendKeys(DName);
  HomePage.btn_Filter(driver).click();
  HomePage.lnk_SearchElement(driver).click();

  String Comp = DetailsPage.txtbx_Name(driver).getAttribute("value");
  DetailsPage.btn_Delete(driver).click();

  
  String a = HomePage.alrt_Status(driver).getText();
  assertEquals(a, "Done! Computer has been deleted");
  
  System.out.println("Computer "+Comp+" has been deleted correctly.");
 }
*/
 
 public void getscreenshot() throws Exception 
 {
         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      //The below method will save the screen shot in d drive with name "screenshot.png"
         FileUtils.copyFile(scrFile, new File("/screenshot.png"));
 }
 
 @AfterSuite
 public void closeBrowser() {
  driver.quit();
 }
}