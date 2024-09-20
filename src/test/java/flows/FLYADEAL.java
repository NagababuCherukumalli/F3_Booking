package flows;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import FlyModules.BrowserContants;
import FlyModules.flyaDealModule;
import FlyModules.passengersDetails;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageObjects.BaseClass;
import pageObjects.Database;

public class FLYADEAL {
	static WebDriver driver;
	boolean status;
	private Database PnrDetails;
	String R_monYear;
	
	public static String flyAdealApiUrl;

	@Test
	public void test() throws Exception {

		if (BrowserContants.ENV.equals("PRD")) {
			RestAssured.baseURI = BrowserContants.PRD_API_URL;
			System.out.println(BrowserContants.PRD_API_URL);
			System.out.println("F3 Booking");
		} else if (BrowserContants.ENV.equals("STG")) {
			RestAssured.baseURI = BrowserContants.STG_API_URL;
			System.out.println(BrowserContants.STG_API_URL);
		}
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "text/json");
		Response response = request.get("/GetBookingFromQueue?airline=f3&ordercolname=departuredate&orderby=asc");
		System.out.println("Response body: " + response.body().asString());
		String s = response.body().asString();
		System.out.println(s);
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);

		Gson g = new Gson();
		Database[] mcArray = g.fromJson(s, Database[].class);
		List<Database> p = Arrays.asList(mcArray);
		for (Database data : p) { 
			try {

				PnrDetails = data;
				passengersDetails.readPnrId(PnrDetails);

				Date depDate = new SimpleDateFormat("dd-MMM-yyyy").parse(data.DepartureDate);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String strDate = formatter.format(depDate);
				System.out.println("strDate :" + strDate);

				// String flyAdealApiUrl = null;
				if (data.TripType.equals("OneWay")) {

					// flyAdealApiUrl="https://www.flyadeal.com/en/booking/select/?origin1="+data.From+"&destination1="+data.To+"&departure1="+strDate
					// +"&adt1="+data.Adults+"&chd1="+data.Childs+"&inf1="+data.Infants+"&currency=SAR";
					flyAdealApiUrl="https://www.flyadeal.com/en/search-flight/?origin1="+data.From.toUpperCase()+"&destination1="+data.To.toUpperCase()+"&departure1="+strDate +"&adt1="+data.Adults+"&chd1="+data.Childs+"&inf1="+data.Infants+"&currency=SAR&source=airtrfx?utm_source=wego_meta&utm_medium=landingpage&utm_campaign=promomar&utm_content=herobanner";
					//flyAdealApiUrl = "https://www.flyadeal.com/en/booking/select?destination1=" + data.To + "&inf1="+ data.Infants + "&currency=SAR&source=airtrfx&chd1="+data.Childs+"&adt1="+data.Adults+"&origin1=" + data.From + "&promoCode1=OFF20&departure1=" + strDate + "";
				} else if (data.TripType.equals("RoundTrip")) {
					Date arrDate = new SimpleDateFormat("dd-MMM-yyyy").parse(data.ReturnDate);
					SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
					String arriveDate = formatter2.format(arrDate);
					System.out.println("arriveDate :" + arriveDate);
					// flyAdealApiUrl="https://www.flyadeal.com/en/booking/select/?origin1="+data.From+"&destination1="+data.To+"&departure1="+strDate+"&adt1="+data.Adults+"&chd1="+data.Childs+"&inf1="+data.Infants+"&origin2="+data.To+"&destination2="+data.From+"&departure2="+arriveDate+"&adt2="+data.Adults+"&chd2="+data.Childs+"&inf2="+data.Infants+"&currency=SAR";
					flyAdealApiUrl = "https://www.flyadeal.com/en/search-flight/?inf2=" + data.Infants+ "&destination1=" + data.To + "&inf1=" + data.Infants + "&destination2=" + data.From+ "&source=airtrfx&departure2=" + arriveDate + "&adt2=" + data.Adults + "&adt1="+ data.Adults + "&departure1=" + strDate + "&origin2=" + data.To + "&currency=SAR&chd1="+ data.Childs + "&chd2=" + data.Childs + "&promoCode1=OFF20&promoCode2=OFF20&origin1="+ data.From + "";

				}

				System.out.println("API URL: " + flyAdealApiUrl);
				System.out.println(PnrDetails.PnrId);

				
				
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				options.addArguments("start-maximized");
				options.setExperimentalOption("useAutomationExtension", false);
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-infobars");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-browser-side-navigation");
				options.addArguments("--disable-gpu");
				options.addArguments("--enable-javascript");
				//prefs.put("profile.managed_default_content_settings.images", 2);
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("force-device-scale-factor=0.25");
				options.addArguments("--clear-ssl-state");
				options.addArguments("--disable-cache");
				options.addArguments("--disk-cache-size=0");
				options.addArguments("--disable-network-throttling");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				// System.out.println(driver.manage().window().getSize());
				driver.manage().deleteAllCookies();
				
				
				driver.get(flyAdealApiUrl);
				new BaseClass(driver);
				flyaDealModule.selectFlightAndFare_Fly(driver, PnrDetails, Float.parseFloat(PnrDetails.Amount),Float.parseFloat(PnrDetails.UserPaidAmount));
				flyaDealModule.enterPaxDetails(driver, PnrDetails);
                flyaDealModule.enterContactDetails(driver, PnrDetails, Float.parseFloat(PnrDetails.Amount),Float.parseFloat(PnrDetails.UserPaidAmount));
                
                
                //----The below two lines are for switching AUB and NEC-------

				flyaDealModule.enterCardDetails_NEC(PnrDetails);

				// flyaDealModule.enterCardDetails_AUBCC(PnrDetails);
				
                System.out.println("PNR ID:" + PnrDetails.PnrId + "  " + PnrDetails.Domain + " PASS ");
				Thread.sleep(5000);
			    flyaDealModule.browser_Quit(driver, PnrDetails);

			}

			catch (Exception e) {
				passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId, flyaDealModule.status);
				System.out.println("PNR ID:" + PnrDetails.PnrId + " DOMAIN NAME " + PnrDetails.Domain + "  FAIL  " + ""+ e.getMessage());
				System.out.println(e);
				Thread.sleep(5000);

				continue;
			}
		}

	}

@AfterMethod
public void stop() throws Exception
 {
	 
	 if (driver != null) {
	        driver.quit();
	    }
}

}	
