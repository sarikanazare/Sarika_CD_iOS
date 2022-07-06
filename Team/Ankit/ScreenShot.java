package SeleniumPractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShot {
	WebDriver driver;

	@BeforeMethod
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		System.out.println("Launch the app");
		driver.manage().window().maximize();
		System.out.println("Windows maximize");
	}

	@Test
	void PerformAction() {
		WebElement list = driver.findElement(By.xpath("//select[@id='first']"));
		Select s = new Select(list);
		// s.selectByValue("Google");
		s.selectByVisibleText("Iphone");
	}

	@Test
	void SelectSecondOption() {
		WebElement list = driver.findElement(By.xpath("//select[@id='first']"));
		Select s = new Select(list);
		s.selectByValue("Google");
		// s.selectByVisibleText("Iphone");
	}

	@AfterMethod
	void Takescreenshot(ITestResult result) throws IOException {
		String name = result.getName(); // get method name like screenshot,
										// launchbrowser
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./src/test/java/Screenshot/" + name + ".png"));

	}

}

// Screenshot with simple method
// TakesScreenshot ts= (TakesScreenshot) driver;
// File file=ts.getScreenshotAs(OutputType.FILE);
// FileUtils.copyFile(file, new File ("./src/test/java/Screenshot/xyz.png"));