package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver openchromebrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		return driver;
	}
//	public static void openedgebrowser() {
//		System.setProperty("webdriver.edge.driver", "E:\\Automation\\edgedriver.exe");	
//		WebDriver driver = new EdgeDriver();
//	}
}
