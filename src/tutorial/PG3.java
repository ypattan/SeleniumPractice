package tutorial;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PG3 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.chromedriver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/popuptest2.html");
		
		/*
		 * driver.close();
		 * using close will still leave the pop ups open but close the main
		 * browser window that the WebDriver is controlling
		 */
		
		driver.quit();
	}
}
