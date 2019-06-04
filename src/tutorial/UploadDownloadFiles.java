package tutorial;

import org.openqa.selenium.*;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadDownloadFiles {
	public static String baseUrl = "http://demo.guru99.com/test/upload/";
	public static WebDriver driver = new ChromeDriver();
	
	public static void uploadFile() {
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		
		//enter the file path onto the file-selection input field
		uploadElement.sendKeys("/Users/yaminipattan/workspace/SeleniumPractice/newfile.txt");
		
		//check the "I accept the terms of service" check box
		driver.findElement(By.id("terms")).click();
		System.out.println("Accepted terms of service");
		
		//click the "UploadFile" button
		driver.findElement(By.name("send")).click();
		System.out.println("Upload successful");
	}
	
	/*
	 * I can't figure out how to get it to get this to work on a Mac
	 * don't need this to get the test cases working for SD
	 * 
	 * public static void downloadFile() {
	 *	baseUrl = "http://demo.guru99.com/test/yahoo.html";
	 *	driver.get(baseUrl);
	 *	
	 *	WebElement downloadButton = driver.findElement(By.id("messenger-download"));
	 *	String sourceLocation = downloadButton.getAttribute("href");
	 *	String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;
	 *	
	 *	try {
	 *		Process exec = Runtime.getRuntime().exec(wget_command);
	 *		int exitVal = exec.waitFor();
	 *		System.out.println("Exit value: " + exitVal);
	 *	} catch (InterruptedException | IOException ex) {
	 *		System.out.println(ex.toString());
	 *		}
	 *	driver.close();
	 *}
	 * 
	 */
	
	public static void main(String[]args) {
		driver.get(baseUrl);
		uploadFile();
		//downloadFile();
		driver.quit();
	}
}
