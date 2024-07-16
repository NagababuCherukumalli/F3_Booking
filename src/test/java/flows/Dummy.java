package flows;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Dummy {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.gecko.driver","D:\\Softwares\\geckodriver.exe"); 
		FirefoxOptions options = new
		FirefoxOptions();  
		options.addPreference("layout.css.devPixelsPerPx", "0.3");
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		System.out.println(driver.manage().window().getSize());
		driver.manage().deleteAllCookies();
        driver.manage().deleteAllCookies();
        driver.get("https://www.flyadeal.com/en/booking/select?destination1=RUH&inf1=0&currency=SAR&source=airtrfx&chd1=0&adt1=1&origin1=AHB&departure1=2024-06-25");
		driver.manage().window().maximize(); 
		System.out.println("URL IS:-"+driver.getCurrentUrl()); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 15); // Set the maximum wait
		 * time to 60 seconds boolean isPageLoaded = false; int maxAttempts = 6; int
		 * attempt = 1;
		 * 
		 * while (!isPageLoaded && attempt <= maxAttempts) { try { // Wait for the page
		 * to load completely isPageLoaded = wait.until(ExpectedConditions.urlContains(
		 * "https://www.flyadeal.com/en/select-flight")); } catch (Exception e) { //
		 * Timeout occurred, handle the situation
		 * System.out.println("Page didn't load within 60 seconds on attempt " + attempt
		 * + ". Clearing cookies...");
		 * 
		 * // Clear cookies driver.get("chrome://settings/clearBrowserData");
		 * Thread.sleep(4000); driver.switchTo().activeElement().sendKeys("co");
		 * Thread.sleep(4000); driver.switchTo().activeElement().sendKeys("\n");
		 * Thread.sleep(4000); System.out.println("Cookies cleared.");
		 * 
		 * // Refresh the page driver.get(
		 * "https://www.flyadeal.com/en/booking/select?origin1=AHB&destination1=JED&departure1=2024-01-05&adt1=1&chd1=0&inf1=0&currency=SAR&source=airtrfx"
		 * ); Thread.sleep(4000);
		 * System.out.println("Cookies deleted. Page refreshed."); }
		 * 
		 * attempt++; }
		 * 
		 * if (isPageLoaded) { System.out.println("Page loaded successfully."); } else {
		 * System.out.println("Page didn't load after " + maxAttempts + " attempts."); }
		 */
		
		driver.findElement(By.id("close_banner")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SAR'])[2]/following::div[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='fly+'])[1]/preceding::div[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Are you sure?'])[1]/following::button[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::button[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Login To Member'])[1]/preceding::button[1]")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::button[1]")).click();
		Thread.sleep(5000);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "C:/Users/Gopi/Desktop/Projects/screenshot.png"));
	  		
	
		
		
		
	}

}