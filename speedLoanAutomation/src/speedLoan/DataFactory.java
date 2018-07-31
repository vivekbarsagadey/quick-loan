package speedLoan;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataFactory {

	public static String getEmailString() {

		String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder email = new StringBuilder();
		Random rnd = new Random();
		while (email.length() < 4) { // length of the random string.
			int index = (int) (rnd.nextFloat() * chars.length());
			email.append(chars.charAt(index));
		}

		email.append("@gmail.com");
		return email.toString();

	}

	public static String getNameString() {

		String chars = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder name = new StringBuilder();
		Random rnd = new Random();
		while (name.length() < 4) { // length of the random string.
			int index = (int) (rnd.nextFloat() * chars.length());
			name.append(chars.charAt(index));
		}
		return name.toString();
	}

	public static String getPasswordString() {

		String chars = "abcdefghijklmnopqrstuvwxyz#@$+-";
		StringBuilder password = new StringBuilder();
		Random rnd = new Random();
		while (password.length() < 8) { // length of the random string.
			int index = (int) (rnd.nextFloat() * chars.length());
			password.append(chars.charAt(index));
		}

		return password.toString();

	}

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\project\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://whizit.co.in/");
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#live-chat > header > h4")).click();
		driver.findElement(By.linkText("CONTACT")).click();
		driver.findElement(By.id("name")).sendKeys(getNameString());
		driver.findElement(By.id("email")).sendKeys(getEmailString());

	}

}
