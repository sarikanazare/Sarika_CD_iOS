package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class launchBrowserFirefox {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		System.out.println("Launch the app");
		driver.manage().window().maximize();
		System.out.println("Windows maximise");

		String title = driver.getTitle();
		System.out.println("Title of the pagr is = " + title);

		String url = driver.getCurrentUrl();
		System.out.println("url is " + url);

		// String source=driver.getPageSource();
		// System.out.println(source);

		driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_7']")).click();
		driver.navigate().back();
		driver.navigate().forward();

		driver.navigate().refresh();

		driver.quit();
		System.out.println("Close the browser");

	}

}
