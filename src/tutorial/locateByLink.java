package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locateByLink {
	public static void main(String[] args) {
		String baseUrl = "http://demo.guru99.com/test/link.html";
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//by exact text match
		driver.get(baseUrl);
		driver.findElement(By.linkText("click here")).click();
		System.out.println("Title of page is: " + driver.getTitle());
		
		//by partial text match
		//baseUrl = "file:///D:/partial_match.html";
		driver.get(baseUrl);
		
		driver.findElement(By.partialLinkText("here")).click();
		System.out.println("Title of page is: " + driver.getTitle());
		
		//another example
		baseUrl = "http://newtours.demoaut.com/";
		driver.get(baseUrl);
		
		String theLinkText = driver.findElement(By.partialLinkText("egis")).getText();
		System.out.println(theLinkText);
		theLinkText = driver.findElement(By.partialLinkText("EGIS")).getText();
		System.out.println(theLinkText);
		
		//link outside and inside a block
		baseUrl = "http://demo.guru99.com/test/block.html";
		driver.get(baseUrl);
		driver.findElement(By.partialLinkText("Inside")).click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Outside")).click();
		System.out.println(driver.getTitle());
		
		
		driver.quit();
	}
}
