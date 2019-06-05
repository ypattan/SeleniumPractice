package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ToolTip {
	public static String baseUrl = "http://demo.guru99.com/test/social-icon.html";
	public static WebDriver driver = new ChromeDriver();
	
	public static void ToolTip1() {
		driver.get(baseUrl);;
		String expectedTooltip = "Github";
		
		//Find the Gitbug icon at the top right of the header
		WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));
		
		//get the value of the "title" attribute of the github icon
		String actualTooltip = github.getAttribute("title");
		
		//Assert the tooltip's value is as expected
		System.out.println("actual Title of Tool Tip" + actualTooltip);
		if ( actualTooltip.contentEquals(expectedTooltip)) {
			System.out.println("Test Case Passed");
		}
		
		/*
		 * Explanation of code:
		 * 1. Find the WebElement representing the "github" icon
		 * 2. Get its "title" attribute using the getAttribute() method
		 * 3. Assert the value against the expected tooltip value
		 */
	}
	
	public static void ToolTip2() {
		baseUrl = "http://demo.guru99.com/test/tooltip.html";
		
		String expectedTooltip = "What's new in 3.2";
		driver.get(baseUrl);

		
		WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));
		Actions builder = new Actions(driver);
		
		builder.clickAndHold().moveToElement(download);
		builder.moveToElement(download).build().perform();
		
		WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));
		String actualTooltip = toolTipElement.getText();
		
		System.out.println("Actual Title of Tool Tip " + actualTooltip);
		if(actualTooltip.contentEquals(expectedTooltip)) {
			System.out.println("Test Case Passed");
		}
		/*
		 * Code Explanation:
		 * 1. Find the WebElement that corresponds to the element "download now" that we will mouse-hover
		 * 2. Using the Interactions API, mouse hover on to the "Download now"
		 * 3. Assuming the tooltip is displayed, find the WebElement that corresponds to the link inside the tooltip i.e. the "a" tag
		 * 4. Verify the link's  tooltip text retrieved using the getText() against an expected value we have stored in "expectedToolTip"
		 */
	}
			
	public static void main(String[] args) {
		ToolTip1();
		ToolTip2();
		driver.quit();
	}
}
