package tutorial;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputPractice {
	public static void main(String[]args) {
		System.setProperty("webdriver.chrome.chromedriver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
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
		 */
		//submit() is called on the submit type button
		//submit() can be called from any form element too
		password.submit();
		
		//everything but click is working
		//WebElement login = driver.findElement(By.name("Log In"));
		//login.click();
		
		//driver.findElement(By.className("")).click();
		driver.quit();
		
	}
}
