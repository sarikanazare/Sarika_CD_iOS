package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class launchBrowserChrome {

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\ankit.dhakulkar\\Downloads\\Software\\Chromedriver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver","./src/test/java/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
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
		// driver.navigate().refresh();

		String Actual = driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).getText();
		System.out.println(Actual);

		String Expected = "Hello, Sign in";
		
		if (Expected.equals(Actual)) {
			System.out.println("test case pass");
		} else
			System.out.println("test case fail");

		driver.quit();
		System.out.println("Close the browser");

	}

}
