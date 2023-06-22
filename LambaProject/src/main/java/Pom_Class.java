import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pom_Class {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "E:\\c\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://money.rediff.com/gainers");
	driver.manage().window().maximize();
}
}
