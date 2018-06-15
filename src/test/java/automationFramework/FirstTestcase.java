package automationFramework;

import pageObjects.*;
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestcase {

    //Location of the Chrome Driver for Selenium.
    String driverpath = "C:\\Users\\Priti\\";

    public WebDriver driver = null;

    @BeforeSuite
    public void startBrowser() {
        //System.setProperty("webdriver.chrome.driver", driverpath + "chromedriver.exe");
        ChromeDriverManager.getInstance().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://computer-database.herokuapp.com/computers");
        System.out.println("The webpage is opened in the Browser.");

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
            HomePage.btn_Add(driver).click();

            DetailsPage.txtbx_Name(driver).sendKeys(Name);
            DetailsPage.txtbx_startDate(driver).sendKeys(startDate);
            DetailsPage.txtbx_endDate(driver).sendKeys(endDate);

            if (Company != "") {
                DetailsPage.lst_Company(driver).selectByValue(Company);
            }

            DetailsPage.btn_Create(driver).click();

            String a = HomePage.alrt_Status(driver).getText();
            assertEquals(a, "Done! Computer " + Name + " has been created");

            System.out.println("Computer "+Name+" has been added correctly.");
        } catch (Exception e) {

            System.out.println("Required elements not found on the screen. Returning to home screen.");
            HomePage.lnk_Home(driver).click();
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
    public void updComputer(String UName, String startDate, String endDate, String Company) throws Exception {

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

   // @Test(priority = 3)
   // @Parameters({
   //         "DName"
   // })
   // public void delComputer(String DName) {

   //     HomePage.txtbx_Filter(driver).sendKeys(DName);
   //     HomePage.btn_Filter(driver).click();
   //     HomePage.lnk_SearchElement(driver).click();

   //    String Comp = DetailsPage.txtbx_Name(driver).getAttribute("value");
   //     DetailsPage.btn_Delete(driver).click();


   //     String a = HomePage.alrt_Status(driver).getText();
   //     assertEquals(a, "Done! Computer has been deleted");

   //     System.out.println("Computer "+Comp+" has been deleted correctly.");
   // }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }
}
