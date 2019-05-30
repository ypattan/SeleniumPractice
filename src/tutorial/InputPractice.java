package tutorial;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class InputPractice {
	public static void clickLinkByHref(String href, String tag) {
		System.setProperty("webdriver.chrome.chromedriver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		List<WebElement> anchors = driver.findElements(By.tagName(tag));
		Iterator<WebElement> i = anchors.iterator();
		
		while(i.hasNext()) {
			WebElement anchor = i.next();
			if(anchor.getAttribute("href").contains("href")) {
				anchor.click();
				break;
			}
		}
		
	}
	
	public static void main(String[]args) {
		System.setProperty("webdriver.chrome.chromedriver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
		driver.get("https://www.pandora.com/account/sign-in");
		WebElement email = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		
		
		email.sendKeys("ypattanjunk@gmail.com");
		password.sendKeys("1hsv1k1ngs");
		
		
		/*
		 * submit buttons are used to submit the entire form to the server
		 * we can either use the click() method on the web element like a 
		 * normal button as I tried to do below or use the submit() method 
		 * on any web element in the form or on the submit button itself
		 * submit() is called on the submit type button
		 * submit() can be called from any form element too
		 */
		password.submit();
		
		//everything but click is working
		//WebElement login = driver.findElement(By.name("Log In"));
		//login.click();
		
		//try to click on Browse button using href
		//https://www.testingexcellence.com/click-link-href-value-webdriver/
		//clickLinkByHref("Browse", "span");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click(, arg1);", driver.findElement(By.xpath("//span[@class='NavHorizontal_item']//a")));
		
		//Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.xpath("//span[@class='NavHorizontal_item']//a"))).click().perform();
		
		//driver.findElement(By.linkText("browse")).click();
		//driver.findElement(By.href("NavHorizontal__item__link")).click();
		driver.quit();
		
	}
}
