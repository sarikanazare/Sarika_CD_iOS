package SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ListOfCompany {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		System.out.println("Launch the app");
		driver.manage().window().maximize();
		System.out.println("Windows maximize");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		int total_rows = rows.size();

		ArrayList<String> namesOfCompany = new ArrayList();
		for (int i = 1; i <= total_rows; i++) {
			String name = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + i + "]/td[1]"))
					.getText();
			namesOfCompany.add(name);

		}
		System.out.println(namesOfCompany);
		System.out.println(namesOfCompany.size());

		driver.quit();

	}
}

// table[@class='dataTable']/tbody/tr["+i+"]/td[1]
// table[@class='dataTable']/tbody/tr["+i+"]/td[3]
