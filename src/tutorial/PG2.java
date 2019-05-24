package tutorial;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PG2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.vans.com/";
		String tagName = "";
		
		driver.get(baseUrl);
		tagName = driver.findElement(By.id("search")).getTagName();
		//only input areas seem to have id's and tag names that can be used in the above command
		System.out.println(tagName);
		driver.close();
		System.exit(0);
	}
}
