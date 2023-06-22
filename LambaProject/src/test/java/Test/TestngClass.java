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

public class TestngClass extends Base{
	
	WebDriver driver;
	Header headers;
	LoginPage loginpage;
	SoftAssert soft;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters("browserName")
	@BeforeTest
	public void beforetest(String browser) {
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend =new ExtentReports();
		extend.attachReporter(reporter);
		
		System.out.println("before test");

		if (browser.equals("Chrome"))
		{
			driver= openchromebrowser();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	@BeforeClass
	public void LaunchBrowser() {
		System.out.println("before class");	
		loginpage = new LoginPage(driver);
		headers = new Header(driver);
		soft= new SoftAssert();

		
	}
	@BeforeMethod
	public void loginApplication() throws InterruptedException {
		System.out.println("before method");
		driver.get("https://accounts.lambdatest.com/login");

		loginpage.sendusername();
		loginpage.sendpassword();
		loginpage.loginbutton(); 

	}
	@Test(priority = 1)
	public void toVaroifyDashbord() {
		System.out.println("test");

		headers.clickdashboard();
		String url =driver.getCurrentUrl() ;
		String Title = driver.getTitle();
		soft.assertEquals(url, "https://accounts.lambdatest.com/dashboard");
		soft.assertEquals(Title,"Welcome - LambdaTest");
		soft.assertAll();
		
	}
	@Test(priority = 2)
	public void tovarifyhyperexcute() throws InterruptedException {
		System.out.println("testB");
		headers.clickhyperexute();
		Thread.sleep(2000);

		headers.clickonpopup();
		Thread.sleep(2000);
		String url2 =driver.getCurrentUrl() ;
		System.out.println(url2);
		String Title = driver.getTitle();
		
		soft.assertEquals(url2, "https://hyperexecute.lambdatest.com/");
		soft.assertEquals(Title,"LambdaTest-HyperExecute");
		soft.assertAll();

	}
	@AfterMethod
	public void logoutfromApplication() {
		System.out.println("after method");
		headers.clicklogout();
		headers.clicklogout2(); 
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		System.out.println("after class");
		Thread.sleep(2000);
		loginpage=null;
		headers=null;
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
		driver=null;
		System.gc();
	}
}
