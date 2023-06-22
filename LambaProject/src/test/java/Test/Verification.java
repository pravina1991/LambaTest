package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pom.Header;
import Pom.LoginPage;

public class Verification {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

		//testcase 1= dashboard 
//		driver.get("https://accounts.lambdatest.com/login");
//
//		LoginPage loginpage = new LoginPage(driver);
//		loginpage.sendusername();
//		loginpage.sendpassword();
//		loginpage.loginbutton();
//
//		Header headers = new Header(driver);
//		headers.clickdashboard();
//		String url =driver.getCurrentUrl() ;
//		String Title = driver.getTitle();
//
//		if (url .equals("https://accounts.lambdatest.com/dashboard")&& Title.equals("Welcome - LambdaTest")) {
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
//		headers.clicklogout();
//		headers.clicklogout2(); 
		//testcase = 2
		driver.get("https://accounts.lambdatest.com/login");

		LoginPage	loginpage = new LoginPage(driver);
		loginpage.sendusername();
		loginpage.sendpassword();
		loginpage.loginbutton();

		Header headers = new Header(driver);
		Thread.sleep(3000);
		headers.clicksmartui();
		Thread.sleep(4000);
		String url3 =driver.getCurrentUrl() ;
		System.out.println(url3);
		String Title3 = driver.getTitle();
		System.out.println(Title3);

		if (url3 .equals("https://smartui.lambdatest.com/onBoard")&& Title3.equals("LambdaTest SmartUI")) {
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}
		headers.clicklogout();
		headers.clicklogout2(); 
		//test case = 3
//		driver.get("https://accounts.lambdatest.com/login");
//
//		loginpage = new LoginPage(driver);
//		loginpage.sendusername();
//		loginpage.sendpassword();
//		loginpage.loginbutton();
//
//		headers = new Header(driver);
//		Thread.sleep(3000);
//		headers.clickhyperexute();
//		Thread.sleep(2000);
//		String url2 =driver.getCurrentUrl() ;
//		System.out.println(url2);
//		Title = driver.getTitle();
//
//		if (url2 .equals("https://hyperexecute.lambdatest.com/quickstart?origin=try-now")&& Title.equals("LambdaTest-HyperExecute")) {
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
//		headers.clicklogout();
//		headers.clicklogout2(); 
//		//        driver.quit();
//		//test case = 4 
//		driver.get("https://accounts.lambdatest.com/login");
//
//		loginpage = new LoginPage(driver);
//		loginpage.sendusername();
//		loginpage.sendpassword();
//		loginpage.loginbutton();
//
//		headers = new Header(driver);
//		Thread.sleep(3000);
		headers.clickanalytics();
		Thread.sleep(2000);
		String url4 =driver.getCurrentUrl() ;
		System.out.println(url4);
		String Title = driver.getTitle();

		if (url4.equals("https://analytics.lambdatest.com/templates")&& Title.equals("Analytics | LambdaTest")) {
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}
		headers.clicklogout();
		headers.clicklogout2(); 
	}

}


