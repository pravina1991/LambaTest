package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
	@FindBy (xpath = "//a[@id='dashboard_sidebar']")
	private WebElement dashboard;
	
	@FindBy (xpath = "//a[@class='aside__menu__link active']")
	private WebElement smartui;
	
	@FindBy (xpath = "//div[@id='hypertest__link']")
	private WebElement hyperexute;
	
	@FindBy(xpath="//div[@class='try-now-modal-heading-icon-container']")//pop up
	private WebElement popup;
	
	
	@FindBy (xpath = "(//a[@class='aside__menu__link'])[3]")
	private WebElement analytics;
	
	@FindBy (xpath = "//a[@id='profile__dropdown']")
	private WebElement logout;
	
	@FindBy (xpath = "//a[@id='app__logout']")
	private WebElement logout2;
	WebDriver driver;
	
	
	public Header(WebDriver driver) {
		PageFactory.initElements(driver, this);
//		this.driver= driver;
	}
	public void clickdashboard() {
		dashboard.click();
	}
	public void clicksmartui() throws InterruptedException {
		Thread.sleep(3000);
		smartui.click();	
	}
	public void clickhyperexute() {
		hyperexute.click();
	}
	public void clickonpopup() {
		popup.click();
	}
	public void clickanalytics() {
		analytics.click();
	}
	public void clicklogout() {
		logout.click();
	}
	public void clicklogout2() {
		logout2.click();
	}
}

