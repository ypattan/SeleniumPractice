package tutorial;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickPractice {
	
	public static void clickLinkByHref(String href, String tag) {
		System.setProperty("webdriver.chrome.chromerdriver", "chromedriver");
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
	
	public void main (String[]args) {
		System.setProperty("webdriver.chrome.chromedriver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.vans.com/");
		
		//try click on link using href
		clickLinkByHref("/shop.html", "a");
		
	}

}
