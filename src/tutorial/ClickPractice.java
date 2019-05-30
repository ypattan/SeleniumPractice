package tutorial;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickPractice {
	
	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.chromedriver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.vans.com/");
		
		//try click on "Shop" link using href
		driver.findElement(By.xpath("//a[@href='/shop.html']")).click(); //works as expected
		
		//try to click on "Womens" → "Shoes" using JSE
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='/shop/womens-shoes']")));
		
		//click on a specific shoe using a cssSelector
		//Note: space in a class name indicates multiple classes not just one with a space
		WebElement element = driver.findElement(By.cssSelector("a.product-block-pdp-url.pdp-url-js"));
		element.click();
		
		driver.quit();
		
	}

}
