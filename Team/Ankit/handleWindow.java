package SeleniumPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class handleWindow {
	WebDriver driver;

	@BeforeMethod
	void LaunchBrowser() {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Launch the app");
		driver.manage().window().maximize();
		System.out.println("Windows maximize");
	}

	@Test
	void action() {
		 String id=driver.getWindowHandle();
		 System.out.println(id);
		driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);
        driver.switchTo().window("CDwindow-6043B147C394B87EE9837CE4F66D1DB3");
		String value = driver.findElement(By.xpath("//a[text()='Courses']")).getText();
		System.out.println(value);
	}

}
