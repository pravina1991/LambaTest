package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Browsers.Base;
import Pom.Header;
import Pom.LoginPage;

public class TestNgCase2 extends Base {

	WebDriver driver;
	Header headers;
	LoginPage loginpage;
	SoftAssert soft;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	
	@Parameters("browserName")
	@BeforeTest
	public void launchBrowser(String browser) {
		
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend =new ExtentReports();
		extend.attachReporter(reporter);
		
		System.out.println("before test");

		if (browser.equals("Chrome"))
		{
			driver= openchromebrowser();
		}
		//		if (browser.equals("edge"))
		//		{
		//			driver= openedgebrowser();
		//		}

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}


	@BeforeClass
	public void createPOMobject() {
		System.out.println("before class");

		loginpage = new LoginPage(driver);
		headers = new Header(driver);
		soft = new SoftAssert();


	}
	@BeforeMethod
	public void loginApplication() throws InterruptedException {
		System.out.println("before method");	
		driver.get("https://accounts.lambdatest.com/login");

		loginpage.sendusername();
		loginpage.sendpassword();
		loginpage.loginbutton(); 


	}
	@Test
	public void varifyTosmartui() throws InterruptedException {
		System.out.println("testA");
		headers.clicksmartui();
		Thread.sleep(4000);
		String url3 =driver.getCurrentUrl() ;
		
		System.out.println(url3);
		String Title3 = driver.getTitle();
		System.out.println(Title3);

		soft.assertEquals(url3, "https://analytics.lambdatest.com/templates");
		soft.assertEquals(Title3, "LambdaTest SmartUI");
		soft.assertAll();

	}
	@Test
	public void testB() throws InterruptedException {
		System.out.println("testB");
		headers.clickanalytics();
		Thread.sleep(2000);
		String url4 =driver.getCurrentUrl() ;
		System.out.println(url4);
		String Title = driver.getTitle();

		soft.assertEquals(url4, "https://analytics.lambdatest.com/templates");
		soft.assertEquals(Title, "Analytics | LambdaTest");
		soft.assertAll();

	}
	@AfterMethod
	public void logoutApllication() {
		System.out.println("after method");
		headers.clicklogout();
		headers.clicklogout2(); 
	}
	@AfterClass
	public void cleanobject()  {
		System.out.println("after class");
		loginpage=null;
		headers=null;
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
		driver=null;
		System.gc();
	} 

}
