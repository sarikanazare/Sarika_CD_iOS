package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {
WebDriver driver;

void launchBrowser()
{
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	 driver= new ChromeDriver();
  driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
	System.out.println("Launch the app");
	driver.manage().window().maximize();
	System.out.println("Windows maximize");
}


	public static void main(String[] args) {
		

	}

}
