package tutorial;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvents {
	public static void mouseOver(WebDriver driver) {
		WebElement link_Home = driver.findElement(By.linkText("Home"));
		WebElement td_Home = driver.findElement(By.xpath("//html/body/div" +
														"/table/tbody/tr/td" +
														"/table/tbody/tr/td" +
														"/table/tbody/tr/td"+
														"/table/tbody/tr"));
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(link_Home).build();
		String bgColor = td_Home.getCssValue("background-color");
		System.out.println("Before hover: " + bgColor);
		mouseOverHome.perform();
		bgColor = td_Home.getCssValue("background-color");
		System.out.println("After hove: " + bgColor);
	}
	
	public static void seqActions (WebDriver driver) {
		WebElement txtUsername = driver.findElement(By.id("email"));
		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(txtUsername)
				.click()
				.keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "hello")
				.keyUp(txtUsername, Keys.SHIFT)
				.doubleClick(txtUsername)
				.contextClick()
				.build();
		seriesOfActions.perform();
	}
	
	public static void main(String[] args) {
		String baseUrl = "https://demo.guru99.com/test/newtours/";
		System.setProperty("webdriver.chorme.chromedriver", "chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);
		mouseOver(driver);
		
		baseUrl = "http://www.fb.com/";
		driver.get(baseUrl);
		seqActions(driver);
		
		driver.quit();
	}
}
