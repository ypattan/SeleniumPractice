package tutorial;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadDownloadFiles {
	public static void main(String[]args) {
		System.setProperty("webdriver.chrome.chromedriver", "chromedriver");
		String baseUrl = "http://demo.guru99.com/test/upload/";
		WebDriver driver = new ChromeDriver();
		
		driver.get(baseUrl);
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		
		//enter the file path onto the file-selection input field
		uploadElement.sendKeys("/Users/yaminipattan/workspace/SeleniumPractice/newfile.txt");
		
		//check the "I accept the terms of service" check box
		driver.findElement(By.id("terms")).click();
		System.out.println("Accepted terms of service");
		
		//click the "UploadFile" button
		driver.findElement(By.name("send")).click();
		System.out.println("Upload successful");
		driver.quit();
	}
}
