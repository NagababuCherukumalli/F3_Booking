package FlyModules;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import flows.FLYADEAL;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageObjects.Database;
import pageObjects.PageUtils;
import pageObjects.Pax;
import pageObjects.flyadealPage;

public class flyaDealModule extends passengersDetails {
	public static String status;
	static String WebSiteAmount;
	static float WEBAMOUNT;
	static float F3WEBAMOUNT;
	static String PnrId;
	static String F_phoneNumber;
	static String F_FirstName;
	static String F_LastName;
	static String F_emailId;
	static String F_CustomeremailId;
	static String F_emailWithCustomerName;
	static String F_Customer_Email;
	static String F_email_Random;
	static String F_mobileCode;
	
	public static void selectFlightAndFare_Fly(WebDriver driver, Database PnrDetails, double Amount,double UserPaidAmount) throws Exception {

		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25)); // Set the maximum wait time to 60 seconds
		 // Set the maximum wait time to 60 seconds
		boolean isPageLoaded = false;
		int maxAttempts = 4;
		int attempt = 1;

		while (!isPageLoaded && attempt <= maxAttempts) {
		    try {
		        // Wait for the page to load completely
		        isPageLoaded = wait.until(ExpectedConditions.urlContains("https://www.flyadeal.com/en/select-flight"));
		        PageUtils.isElementLocated(driver,	By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::button[1]"));
				
		    } catch (Exception e) {
		   

		        // Refresh the page
		        driver.get(FLYADEAL.flyAdealApiUrl);
		        Thread.sleep(5000);
		        
		    }

		    attempt++;
		}
		
		PageUtils.isElementLocated(driver,	By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::button[1]"));
		//PageUtils.isElementLocated(driver,	By.xpath("//button[(@class='btn btn-primary btn-next') ]"));
		//PageUtils.waitForElementToLoad(driver, driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::button[1]")));
		
		try {
			flyadealPage.close_banner().click();
			Thread.sleep(2000);
		}
		catch (Exception e) {
			
		}
		//flyadealPage.btn_Pay_screenShot(PnrDetails);
		try {
			String NoFlights = driver.findElement(By.xpath("//p[contains(text(),'No flights available')]")).getText();
			System.out.println(NoFlights);
			flyadealPage.FlightSoldout_Mail(driver, PnrDetails);
			passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId, "FLIGHT NOT FOUND/SOLD OUT");
			driver.quit();
		} catch (Exception ee) {

			if ("OneWay".equals(PnrDetails.TripType)) {
				System.out.println("TRIP:ONEWAY");
				try {
					flyadealPage.close_banner().click();
					Thread.sleep(2000);
				}
				catch (Exception e) {
					
				}
				String FlightNum = PnrDetails.DepartureFlightNumber.replace("F3", "F3 ");
				System.out.println("FlightNum:"+FlightNum);
				try {
				driver.findElement(By.xpath("//span[contains(text(),'" + FlightNum + "')]")).click();
				}
			    catch (Exception e) {
	            // Print the exception message if an error occurs
			    	driver.findElement(By.xpath("//span[contains(text(),'Passengers')]"));
				    System.out.println("ONEWAY::FLIGHT NOT FOUND/SOLD OUT");
				    //passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId, "FLIGHT NOT FOUND/SOLD OUT");
				driver.quit();
	             }
				int Bag = Integer.parseInt(PnrDetails.Baggage);
				
			
				
				try {
					driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CAI'])[2]/preceding::span[1]"));
					TimeUnit.SECONDS.sleep(1);
					if ("15".equals(PnrDetails.Baggage)) {
						PnrDetails.Baggage = "0";
					}
					else if ("30".equals(PnrDetails.Baggage)) {
						PnrDetails.Baggage = "0";
					}
					else if ("45".equals(PnrDetails.Baggage)) {
						PnrDetails.Baggage = "15";
					}

				} catch (Exception E1) {

				}
				if ("0".equals(PnrDetails.Baggage)) {
					try {
					Thread.sleep(5000);
					driver.findElement(By.xpath("//strong[@class='fare-fly' and text()='fly']")).click();
					}
					catch (Exception e) {
						System.out.println("ONEWAY::FLIGHT NOT FOUND/SOLD OUT");
						flyadealPage.FlightSoldout_Mail(driver, PnrDetails);
						passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"FLIGHT NOT FOUND/SOLD OUT");
					}
					
				} else if(Bag > 1 && Bag <= 20) {
					if ("CAI".equals(PnrDetails.From)) {
						driver.findElement(By.xpath("//strong[@class='fare-fly' and text()='fly+']")).click();
					} else if ("CAI".equals(PnrDetails.To)) {
						driver.findElement(By.xpath("//strong[@class='fare-fly' and text()='fly+']")).click();
					} else {
						try {
						driver.findElement(By.xpath("//strong[@class='fare-fly' and text()='fly+']")).click();
						}
						catch (Exception e) {
							System.out.println("ONEWAY::FLIGHT NOT FOUND/SOLD OUT");
							flyadealPage.FlightSoldout_Mail(driver, PnrDetails);
							passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"FLIGHT NOT FOUND/SOLD OUT");
						}
					}
				
				}
				
				PageUtils.waitForFixedTime(BrowserContants.WAIT_2_SEC);
				Fly_Alert(driver);

			}

			else if ("RoundTrip".equals(PnrDetails.TripType)) {
				System.out.println("TRIP:ROUNDTRIP");
				try {
					flyadealPage.close_banner().click();
					Thread.sleep(2000);
				}
				catch (Exception e) {
					
				}
				String FlightNum = PnrDetails.DepartureFlightNumber.replace("F3", "F3 ");
				System.out.println("FlightNum:"+FlightNum);
				driver.findElement(By.xpath("//span[contains(text(),'" + FlightNum + "')]")).click();
				int Bag = Integer.parseInt(PnrDetails.Baggage);
				try {
					driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CAI'])[2]/preceding::span[1]"));
					TimeUnit.SECONDS.sleep(1);
					if ("15".equals(PnrDetails.Baggage)) {
						PnrDetails.Baggage = "0";
					}
					else if ("30".equals(PnrDetails.Baggage)) {
						PnrDetails.Baggage = "0";
					}
					else if ("45".equals(PnrDetails.Baggage)) {
						PnrDetails.Baggage = "15";
					}

				} catch (Exception E1) {

				}
				if ("0".equals(PnrDetails.Baggage)) {
					try {
					driver.findElement(By.xpath("//strong[@class='fare-fly' and text()='fly']")).click();
					}
					catch (Exception e) {
						System.out.println("ONEWAY::FLIGHT NOT FOUND/SOLD OUT");
						flyadealPage.FlightSoldout_Mail(driver, PnrDetails);
						passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"FLIGHT NOT FOUND/SOLD OUT");
					}
				} else if (Bag >= 1) {
					if ("CAI".equals(PnrDetails.From)) {
						driver.findElement(By.xpath("//strong[@class='fare-fly' and text()='fly+']"))
								.click();
					} else if ("CAI".equals(PnrDetails.To)) {
						driver.findElement(By.xpath("//strong[@class='fare-fly' and text()='fly+']"))
								.click();
					} else {
						try {
						driver.findElement(By.xpath("//p[contains(text(),'Pack & save')]")).click();
					    }
					   catch (Exception e) {
						System.out.println("ONEWAY::FLIGHT NOT FOUND/SOLD OUT");
						flyadealPage.FlightSoldout_Mail(driver, PnrDetails);
						passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"FLIGHT NOT FOUND/SOLD OUT");
					}
					}
				
				}
				
				PageUtils.waitForFixedTime(BrowserContants.WAIT_2_SEC);
				Fly_Alert(driver);
				
				String ReturnFlightNum = PnrDetails.ReturnFlightNumber.replace("F3", "F3 ");
				System.out.println("ReturnFlightNum:"+ReturnFlightNum);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[contains(text(),'" + ReturnFlightNum + "')]")).click();
				int R_Bag = Integer.parseInt(PnrDetails.InBaggage);
				try {
					driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CAI'])[2]/preceding::span[1]"));
					TimeUnit.SECONDS.sleep(1);
					if ("15".equals(PnrDetails.InBaggage)) {
						PnrDetails.InBaggage = "0";
					}
					else if ("30".equals(PnrDetails.InBaggage)) {
						PnrDetails.InBaggage = "0";
					}
					else if ("45".equals(PnrDetails.InBaggage)) {
						PnrDetails.InBaggage = "15";
					}

				} catch (Exception E1) {

				}
				if ("0".equals(PnrDetails.InBaggage)) {
					driver.findElement(By.xpath("//strong[@class='fare-fly' and text()='fly']")).click();
				} else if (R_Bag >= 1) {
					if ("CAI".equals(PnrDetails.From)) {
						driver.findElement(By.xpath("//strong[@class='fare-fly' and text()='fly+']")).click();
					} else if ("CAI".equals(PnrDetails.To)) {
						driver.findElement(By.xpath("//strong[@class='fare-fly' and text()='fly+']")).click();
					} else {
						driver.findElement(By.xpath("//strong[@class='fare-fly' and text()='fly+']")).click();
					}
				
				}
				
				PageUtils.waitForFixedTime(BrowserContants.WAIT_2_SEC);
				Fly_Alert(driver);
				
				
				

			}
			
			try {

				WebElement Dep = driver.findElement(By.xpath("//span[contains(text(),'Departure')]"));
				String Depart = Dep.getText();
				System.out.println("Click on Continue");
				flyadealPage.btn_Continue_Srp().click();
				PageUtils.waitForFixedTime(BrowserContants.WAIT_3_SEC);
			} catch (Exception e) {

			}
			PageUtils.isElementLocated(driver,	By.xpath("//button[contains(text(),'Login To Member')]"));
			PageUtils.waitForFixedTime(BrowserContants.WAIT_2_SEC);
			WebSiteAmount = flyadealPage.total_Amount().getText();
			WebSiteAmount = WebSiteAmount.split(" ")[0];
			String WEB = WebSiteAmount.replaceAll(",", "");
			WEBAMOUNT = Float.parseFloat(WEB);
			System.out.println("WEBAMOUNT Is:"+WEBAMOUNT);
			//flyadealPage.btn_Pay_screenShot(PnrDetails);
			try {

				//WebElement Dep = driver.findElement(By.xpath("//span[contains(text(),'Departure')]"));

				if (Amount >= WEBAMOUNT) {

					System.out.println("API Amount:" + PnrDetails.Amount);
					System.out.println("WebSite Amount:" + WebSiteAmount);
				} else {
					if (UserPaidAmount >= WEBAMOUNT) {
						System.out.println("UserPaid Amount:" + PnrDetails.UserPaidAmount);
						System.out.println("WebSite Amount:" + WebSiteAmount);
					} else {
						passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId, " " + WebSiteAmount+ " Website amount is greater than " + PnrDetails.UserPaidAmount + " UserPaid amount");
						System.out.println(WebSiteAmount + " Website amount is greater than "+ PnrDetails.UserPaidAmount + " User Paid amount");
						fareHikeMail_FlyadealTeam(driver, PnrDetails);
						driver.quit();
					}
				}
			} catch (Exception e) {
				System.out.println("--------------------");
			}
		}
	}
	
	public static void enterPaxDetails(WebDriver driver, Database PnrDetails) throws Exception {
	
		
		
		//Thread.sleep(5000);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Login To Member')]")).click();
		PageUtils.scrollUp(driver);
		driver.findElement(By.xpath("//span[contains(text(),'SIGN IN')]")).click();
		//try {
			
			//passengersDetails.paxAPI(PnrDetails);
		if(BrowserContants.ENV.equals("PRD"))
		{
			RestAssured.baseURI =BrowserContants.PRD_API_URL;
		}
		else if(BrowserContants.ENV.equals("STG"))
		{
			RestAssured.baseURI =BrowserContants.STG_API_URL;
		}
		//RestAssured.baseURI ="http://stageapi.rehlat.com/v1/Rehlat/flights";
		
		RequestSpecification request = RestAssured.given();
		//request.accept("text/xml");
		JSONObject requestParams = new JSONObject();
		request.header("Content-Type", "text/json");
		requestParams.put("Domain", PnrDetails.Domain);
		requestParams.put("PnrId", PnrDetails.PnrId);
		requestParams.put("ProcessId",  ProcessIdValue);
		request.body(requestParams.toJSONString());
		System.out.println("Before Response:"+requestParams.toJSONString());
		Thread.sleep(2000);
		Response response = request.post("/GetPaxDetailsForScraping");
		Thread.sleep(5000);
		System.out.println("Response body: " + response.body().asString());
		String s=response.body().asString();
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		
		
		
		Gson g = new Gson();
		Pax[] mcArray = g.fromJson(s, Pax[].class);
		List<Pax> p1 = Arrays.asList(mcArray);
		int adultPaxCount = 1;
		int childPaxCount = 1;
		int infantPaxCount = 1;
		String totalPassengersString = null;
		 for(Pax pax:p1){
				// pax.DobStrFlyadeal = pax.DobStrFlyadeal.toUpperCase();
				 pax.PassportExpiryDateStrFlyadeal = pax.PassportExpiryDateStrFlyadeal.toUpperCase();
				String numofAdults = PnrDetails.Adults;
				String numofChilds = PnrDetails.Childs;
				String numofInfants = PnrDetails.Infants;
				
				int adults = Integer.parseInt(numofAdults);
				int children = Integer.parseInt(numofChilds);
				int infants = Integer.parseInt(numofInfants);

				// Calculate the total
				int totalPassengers = adults + children + infants;
				 totalPassengersString = String.valueOf(totalPassengers);
		 }
		
		
		Gson gson = new Gson();
        Type type = new TypeToken<List<Pax>>(){}.getType();
        List<Pax> paxList = gson.fromJson(s, type);
        Pax FirstName1 = null;
        Pax FirstName2 = null;
        Pax FirstName3 = null;
        Pax FirstName4 = null;
        Pax FirstName5 = null;
        Pax FirstName6 = null;
        Pax FirstName7 = null;
        Pax FirstName8 = null;
        Pax FirstName9 = null;
        
        
      
        // Check if the list has at least two elements
        if (paxList.size() >= 2) {
            // Retrieve the second element's first name
        	 if (totalPassengersString.equals("1")) {
               FirstName1 = paxList.get(0); 
               F_FirstName=FirstName1.FirstName;
               F_LastName=FirstName1.LastName;
               F_phoneNumber=FirstName1.PhoneNumber;
  		        F_phoneNumber = F_phoneNumber.replaceAll("\\s", "").replaceFirst("^0+", ""); 
  			    randomMail();
  			  F_CustomeremailId=FirstName1.Email;
  			  String [] Customeremail=F_CustomeremailId.split("@");
  			 F_emailWithCustomerName=Customeremail[0]+"@"+F_email_Random;
  			 F_Customer_Email=Customeremail[0]+".@"+F_email_Random; 
  			F_mobileCode=FirstName1.MobileCode;
        	 }
        	 if (totalPassengersString.equals("2")) {
                  FirstName1 = paxList.get(0); 
                  FirstName2 = paxList.get(1);
                  F_FirstName=FirstName1.FirstName;
                  F_LastName=FirstName1.LastName;
                  F_phoneNumber=FirstName1.PhoneNumber;
     		     F_phoneNumber = F_phoneNumber.replaceAll("\\s", ""); 
     			 randomMail();
     			  F_CustomeremailId=FirstName1.Email;
     			  String [] Customeremail=F_CustomeremailId.split("@");
     			 F_emailWithCustomerName=Customeremail[0]+"@"+F_email_Random;
     			 F_Customer_Email=Customeremail[0]+".@"+F_email_Random; 
     			F_mobileCode=FirstName1.MobileCode;
             	 }
        	 if (totalPassengersString.equals("3")) {
        		  FirstName1 = paxList.get(0); 
                  FirstName2 = paxList.get(1);
                  FirstName3 = paxList.get(2);
                  F_FirstName=FirstName1.FirstName;
                  F_LastName=FirstName1.LastName;
                  F_phoneNumber=FirstName1.PhoneNumber;
     		     F_phoneNumber = F_phoneNumber.replaceAll("\\s", ""); 
     			 randomMail();
     			  F_CustomeremailId=FirstName1.Email;
     			  String [] Customeremail=F_CustomeremailId.split("@");
     			 F_emailWithCustomerName=Customeremail[0]+"@"+F_email_Random;
     			 F_Customer_Email=Customeremail[0]+".@"+F_email_Random; 
     			F_mobileCode=FirstName1.MobileCode;
             	 }
        	 if (totalPassengersString.equals("4")) {
        		  FirstName1 = paxList.get(0); 
                  FirstName2 = paxList.get(1);
                  FirstName3 = paxList.get(2);
                  FirstName4 = paxList.get(3);
                  F_FirstName=FirstName1.FirstName;
                  F_LastName=FirstName1.LastName;
                  F_phoneNumber=FirstName1.PhoneNumber;
     		     F_phoneNumber = F_phoneNumber.replaceAll("\\s", ""); 
     			 randomMail();
     			  F_CustomeremailId=FirstName1.Email;
     			  String [] Customeremail=F_CustomeremailId.split("@");
     			 F_emailWithCustomerName=Customeremail[0]+"@"+F_email_Random;
     			 F_Customer_Email=Customeremail[0]+".@"+F_email_Random; 
     			F_mobileCode=FirstName1.MobileCode;
             	 }
        	 if (totalPassengersString.equals("5")) {
        		  FirstName1 = paxList.get(0); 
                  FirstName2 = paxList.get(1);
                  FirstName3 = paxList.get(2);
                  FirstName4 = paxList.get(3);
                  FirstName5 = paxList.get(4);
                  F_phoneNumber=FirstName1.PhoneNumber;
                  F_FirstName=FirstName1.FirstName;
                  F_LastName=FirstName1.LastName;
     		     F_phoneNumber = F_phoneNumber.replaceAll("\\s", ""); 
     			 randomMail();
     			  F_CustomeremailId=FirstName1.Email;
     			  String [] Customeremail=F_CustomeremailId.split("@");
     			 F_emailWithCustomerName=Customeremail[0]+"@"+F_email_Random;
     			 F_Customer_Email=Customeremail[0]+".@"+F_email_Random; 
     			F_mobileCode=FirstName1.MobileCode;
             	 }
        	
        	 if (totalPassengersString.equals("6")) {
       		  FirstName1 = paxList.get(0); 
                 FirstName2 = paxList.get(1);
                 FirstName3 = paxList.get(2);
                 FirstName4 = paxList.get(3);
                 FirstName5 = paxList.get(4);
                 FirstName6 = paxList.get(5);
                 F_phoneNumber=FirstName1.PhoneNumber;
                 F_FirstName=FirstName1.FirstName;
                 F_LastName=FirstName1.LastName;
    		     F_phoneNumber = F_phoneNumber.replaceAll("\\s", ""); 
    			 randomMail();
    			  F_CustomeremailId=FirstName1.Email;
    			  String [] Customeremail=F_CustomeremailId.split("@");
    			 F_emailWithCustomerName=Customeremail[0]+"@"+F_email_Random;
    			 F_Customer_Email=Customeremail[0]+".@"+F_email_Random; 
    			 F_mobileCode=FirstName1.MobileCode;
            	 }
       	
        	 if (totalPassengersString.equals("7")) {
       		  FirstName1 = paxList.get(0); 
                 FirstName2 = paxList.get(1);
                 FirstName3 = paxList.get(2);
                 FirstName4 = paxList.get(3);
                 FirstName5 = paxList.get(4);
                 FirstName6 = paxList.get(5);
                 FirstName7 = paxList.get(6);
                 F_phoneNumber=FirstName1.PhoneNumber;
                 F_FirstName=FirstName1.FirstName;
                 F_LastName=FirstName1.LastName;
    		     F_phoneNumber = F_phoneNumber.replaceAll("\\s", ""); 
    			 randomMail();
    			  F_CustomeremailId=FirstName1.Email;
    			  String [] Customeremail=F_CustomeremailId.split("@");
    			 F_emailWithCustomerName=Customeremail[0]+"@"+F_email_Random;
    			 F_Customer_Email=Customeremail[0]+".@"+F_email_Random; 
    			 F_mobileCode=FirstName1.MobileCode;
            	 }
       	
        	 if (totalPassengersString.equals("8")) {
       		  FirstName1 = paxList.get(0); 
                 FirstName2 = paxList.get(1);
                 FirstName3 = paxList.get(2);
                 FirstName4 = paxList.get(3);
                 FirstName5 = paxList.get(4);
                 FirstName6 = paxList.get(5);
                 FirstName7 = paxList.get(6);
                 FirstName8 = paxList.get(7);
                 F_phoneNumber=FirstName1.PhoneNumber;
                 F_FirstName=FirstName1.FirstName;
                 F_LastName=FirstName1.LastName;
    		     F_phoneNumber = F_phoneNumber.replaceAll("\\s", ""); 
    			 randomMail();
    			  F_CustomeremailId=FirstName1.Email;
    			  String [] Customeremail=F_CustomeremailId.split("@");
    			 F_emailWithCustomerName=Customeremail[0]+"@"+F_email_Random;
    			 F_Customer_Email=Customeremail[0]+".@"+F_email_Random; 
    			 F_mobileCode=FirstName1.MobileCode;
            	 }
       	
        	 if (totalPassengersString.equals("9")) {
       		  FirstName1 = paxList.get(0); 
                 FirstName2 = paxList.get(1);
                 FirstName3 = paxList.get(2);
                 FirstName4 = paxList.get(3);
                 FirstName5 = paxList.get(4);
                 FirstName6 = paxList.get(5);
                 FirstName7 = paxList.get(6);
                 FirstName8 = paxList.get(7);
                 FirstName9 = paxList.get(8);
                 F_phoneNumber=FirstName1.PhoneNumber;
                 F_FirstName=FirstName1.FirstName;
                 F_LastName=FirstName1.LastName;
    		     F_phoneNumber = F_phoneNumber.replaceAll("\\s", ""); 
    			 randomMail();
    			  F_CustomeremailId=FirstName1.Email;
    			  String [] Customeremail=F_CustomeremailId.split("@");
    			 F_emailWithCustomerName=Customeremail[0]+"@"+F_email_Random;
    			 F_Customer_Email=Customeremail[0]+".@"+F_email_Random; 
    			 F_mobileCode=FirstName1.MobileCode;
            	 }
       	
            
           // Index 1 corresponds to the second element
            if (totalPassengersString.equals("1")) {
            	
				System.out.println("totalPassengers1:"+totalPassengersString);
				passengersDetails.adult_D1(PnrDetails,FirstName1.TitleF3,FirstName1.FirstName,FirstName1.LastName,FirstName1.DobStrFlyadeal,FirstName1.Nationality,FirstName1.DocumentTypeF3,FirstName1.IssuingCountryName,FirstName1.DocumentNumber,FirstName1.PassportExpiryDateStrFlyadeal);
				}
			else if (totalPassengersString.equals("2")) {
				System.out.println("totalPassengers2:"+totalPassengersString);
				passengersDetails.adult_D1(PnrDetails,FirstName1.TitleF3,FirstName1.FirstName,FirstName1.LastName,FirstName1.DobStrFlyadeal,FirstName1.Nationality,FirstName1.DocumentTypeF3,FirstName1.IssuingCountryName,FirstName1.DocumentNumber,FirstName1.PassportExpiryDateStrFlyadeal);
				passengersDetails.adult_D2(PnrDetails,FirstName2.TitleF3,FirstName2.FirstName,FirstName2.LastName,FirstName2.DobStrFlyadeal,FirstName2.Nationality,FirstName2.DocumentTypeF3,FirstName2.IssuingCountryName,FirstName2.DocumentNumber,FirstName2.PassportExpiryDateStrFlyadeal);
			}
			else if (totalPassengersString.equals("3")) {
				System.out.println("totalPassengers3:"+totalPassengersString);
				passengersDetails.adult_D1(PnrDetails,FirstName1.TitleF3,FirstName1.FirstName,FirstName1.LastName,FirstName1.DobStrFlyadeal,FirstName1.Nationality,FirstName1.DocumentTypeF3,FirstName1.IssuingCountryName,FirstName1.DocumentNumber,FirstName1.PassportExpiryDateStrFlyadeal);
				passengersDetails.adult_D2(PnrDetails,FirstName2.TitleF3,FirstName2.FirstName,FirstName2.LastName,FirstName2.DobStrFlyadeal,FirstName2.Nationality,FirstName2.DocumentTypeF3,FirstName2.IssuingCountryName,FirstName2.DocumentNumber,FirstName2.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D3(PnrDetails,FirstName3.TitleF3,FirstName3.FirstName,FirstName3.LastName,FirstName3.DobStrFlyadeal,FirstName3.Nationality,FirstName3.DocumentTypeF3,FirstName3.IssuingCountryName,FirstName3.DocumentNumber,FirstName3.PassportExpiryDateStrFlyadeal);
			}
			else if (totalPassengersString.equals("4")) {
				System.out.println("totalPassengers:"+totalPassengersString);
				passengersDetails.adult_D1(PnrDetails,FirstName1.TitleF3,FirstName1.FirstName,FirstName1.LastName,FirstName1.DobStrFlyadeal,FirstName1.Nationality,FirstName1.DocumentTypeF3,FirstName1.IssuingCountryName,FirstName1.DocumentNumber,FirstName1.PassportExpiryDateStrFlyadeal);
				passengersDetails.adult_D2(PnrDetails,FirstName2.TitleF3,FirstName2.FirstName,FirstName2.LastName,FirstName2.DobStrFlyadeal,FirstName2.Nationality,FirstName2.DocumentTypeF3,FirstName2.IssuingCountryName,FirstName2.DocumentNumber,FirstName2.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D3(PnrDetails,FirstName3.TitleF3,FirstName3.FirstName,FirstName3.LastName,FirstName3.DobStrFlyadeal,FirstName3.Nationality,FirstName3.DocumentTypeF3,FirstName3.IssuingCountryName,FirstName3.DocumentNumber,FirstName3.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D4(PnrDetails,FirstName4.TitleF3,FirstName4.FirstName,FirstName4.LastName,FirstName4.DobStrFlyadeal,FirstName4.Nationality,FirstName4.DocumentTypeF3,FirstName4.IssuingCountryName,FirstName4.DocumentNumber,FirstName4.PassportExpiryDateStrFlyadeal);
			}
			
			else if (totalPassengersString.equals("5")) {
				System.out.println("totalPassengers5:"+totalPassengersString);
				passengersDetails.adult_D1(PnrDetails,FirstName1.TitleF3,FirstName1.FirstName,FirstName1.LastName,FirstName1.DobStrFlyadeal,FirstName1.Nationality,FirstName1.DocumentTypeF3,FirstName1.IssuingCountryName,FirstName1.DocumentNumber,FirstName1.PassportExpiryDateStrFlyadeal);
				passengersDetails.adult_D2(PnrDetails,FirstName2.TitleF3,FirstName2.FirstName,FirstName2.LastName,FirstName2.DobStrFlyadeal,FirstName2.Nationality,FirstName2.DocumentTypeF3,FirstName2.IssuingCountryName,FirstName2.DocumentNumber,FirstName2.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D3(PnrDetails,FirstName3.TitleF3,FirstName3.FirstName,FirstName3.LastName,FirstName3.DobStrFlyadeal,FirstName3.Nationality,FirstName3.DocumentTypeF3,FirstName3.IssuingCountryName,FirstName3.DocumentNumber,FirstName3.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D4(PnrDetails,FirstName4.TitleF3,FirstName4.FirstName,FirstName4.LastName,FirstName4.DobStrFlyadeal,FirstName4.Nationality,FirstName4.DocumentTypeF3,FirstName4.IssuingCountryName,FirstName4.DocumentNumber,FirstName4.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D5(PnrDetails,FirstName5.TitleF3,FirstName5.FirstName,FirstName5.LastName,FirstName5.DobStrFlyadeal,FirstName5.Nationality,FirstName5.DocumentTypeF3,FirstName5.IssuingCountryName,FirstName5.DocumentNumber,FirstName5.PassportExpiryDateStrFlyadeal);
			}
			
			else if (totalPassengersString.equals("6")) {
				System.out.println("totalPassengers5:"+totalPassengersString);
				passengersDetails.adult_D1(PnrDetails,FirstName1.TitleF3,FirstName1.FirstName,FirstName1.LastName,FirstName1.DobStrFlyadeal,FirstName1.Nationality,FirstName1.DocumentTypeF3,FirstName1.IssuingCountryName,FirstName1.DocumentNumber,FirstName1.PassportExpiryDateStrFlyadeal);
				passengersDetails.adult_D2(PnrDetails,FirstName2.TitleF3,FirstName2.FirstName,FirstName2.LastName,FirstName2.DobStrFlyadeal,FirstName2.Nationality,FirstName2.DocumentTypeF3,FirstName2.IssuingCountryName,FirstName2.DocumentNumber,FirstName2.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D3(PnrDetails,FirstName3.TitleF3,FirstName3.FirstName,FirstName3.LastName,FirstName3.DobStrFlyadeal,FirstName3.Nationality,FirstName3.DocumentTypeF3,FirstName3.IssuingCountryName,FirstName3.DocumentNumber,FirstName3.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D4(PnrDetails,FirstName4.TitleF3,FirstName4.FirstName,FirstName4.LastName,FirstName4.DobStrFlyadeal,FirstName4.Nationality,FirstName4.DocumentTypeF3,FirstName4.IssuingCountryName,FirstName4.DocumentNumber,FirstName4.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D5(PnrDetails,FirstName5.TitleF3,FirstName5.FirstName,FirstName5.LastName,FirstName5.DobStrFlyadeal,FirstName5.Nationality,FirstName5.DocumentTypeF3,FirstName5.IssuingCountryName,FirstName5.DocumentNumber,FirstName5.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D6(PnrDetails,FirstName6.TitleF3,FirstName6.FirstName,FirstName6.LastName,FirstName6.DobStrFlyadeal,FirstName6.Nationality,FirstName6.DocumentTypeF3,FirstName6.IssuingCountryName,FirstName6.DocumentNumber,FirstName6.PassportExpiryDateStrFlyadeal);
			   	
			}
			
			else if (totalPassengersString.equals("7")) {
				System.out.println("totalPassengers5:"+totalPassengersString);
				passengersDetails.adult_D1(PnrDetails,FirstName1.TitleF3,FirstName1.FirstName,FirstName1.LastName,FirstName1.DobStrFlyadeal,FirstName1.Nationality,FirstName1.DocumentTypeF3,FirstName1.IssuingCountryName,FirstName1.DocumentNumber,FirstName1.PassportExpiryDateStrFlyadeal);
				passengersDetails.adult_D2(PnrDetails,FirstName2.TitleF3,FirstName2.FirstName,FirstName2.LastName,FirstName2.DobStrFlyadeal,FirstName2.Nationality,FirstName2.DocumentTypeF3,FirstName2.IssuingCountryName,FirstName2.DocumentNumber,FirstName2.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D3(PnrDetails,FirstName3.TitleF3,FirstName3.FirstName,FirstName3.LastName,FirstName3.DobStrFlyadeal,FirstName3.Nationality,FirstName3.DocumentTypeF3,FirstName3.IssuingCountryName,FirstName3.DocumentNumber,FirstName3.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D4(PnrDetails,FirstName4.TitleF3,FirstName4.FirstName,FirstName4.LastName,FirstName4.DobStrFlyadeal,FirstName4.Nationality,FirstName4.DocumentTypeF3,FirstName4.IssuingCountryName,FirstName4.DocumentNumber,FirstName4.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D5(PnrDetails,FirstName5.TitleF3,FirstName5.FirstName,FirstName5.LastName,FirstName5.DobStrFlyadeal,FirstName5.Nationality,FirstName5.DocumentTypeF3,FirstName5.IssuingCountryName,FirstName5.DocumentNumber,FirstName5.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D6(PnrDetails,FirstName6.TitleF3,FirstName6.FirstName,FirstName6.LastName,FirstName6.DobStrFlyadeal,FirstName6.Nationality,FirstName6.DocumentTypeF3,FirstName6.IssuingCountryName,FirstName6.DocumentNumber,FirstName6.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D7(PnrDetails,FirstName7.TitleF3,FirstName7.FirstName,FirstName7.LastName,FirstName7.DobStrFlyadeal,FirstName7.Nationality,FirstName7.DocumentTypeF3,FirstName7.IssuingCountryName,FirstName7.DocumentNumber,FirstName7.PassportExpiryDateStrFlyadeal);
			   	
			}
			
			else if (totalPassengersString.equals("8")) {
				System.out.println("totalPassengers5:"+totalPassengersString);
				passengersDetails.adult_D1(PnrDetails,FirstName1.TitleF3,FirstName1.FirstName,FirstName1.LastName,FirstName1.DobStrFlyadeal,FirstName1.Nationality,FirstName1.DocumentTypeF3,FirstName1.IssuingCountryName,FirstName1.DocumentNumber,FirstName1.PassportExpiryDateStrFlyadeal);
				passengersDetails.adult_D2(PnrDetails,FirstName2.TitleF3,FirstName2.FirstName,FirstName2.LastName,FirstName2.DobStrFlyadeal,FirstName2.Nationality,FirstName2.DocumentTypeF3,FirstName2.IssuingCountryName,FirstName2.DocumentNumber,FirstName2.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D3(PnrDetails,FirstName3.TitleF3,FirstName3.FirstName,FirstName3.LastName,FirstName3.DobStrFlyadeal,FirstName3.Nationality,FirstName3.DocumentTypeF3,FirstName3.IssuingCountryName,FirstName3.DocumentNumber,FirstName3.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D4(PnrDetails,FirstName4.TitleF3,FirstName4.FirstName,FirstName4.LastName,FirstName4.DobStrFlyadeal,FirstName4.Nationality,FirstName4.DocumentTypeF3,FirstName4.IssuingCountryName,FirstName4.DocumentNumber,FirstName4.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D5(PnrDetails,FirstName5.TitleF3,FirstName5.FirstName,FirstName5.LastName,FirstName5.DobStrFlyadeal,FirstName5.Nationality,FirstName5.DocumentTypeF3,FirstName5.IssuingCountryName,FirstName5.DocumentNumber,FirstName5.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D6(PnrDetails,FirstName6.TitleF3,FirstName6.FirstName,FirstName6.LastName,FirstName6.DobStrFlyadeal,FirstName6.Nationality,FirstName6.DocumentTypeF3,FirstName6.IssuingCountryName,FirstName6.DocumentNumber,FirstName6.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D7(PnrDetails,FirstName7.TitleF3,FirstName7.FirstName,FirstName7.LastName,FirstName7.DobStrFlyadeal,FirstName7.Nationality,FirstName7.DocumentTypeF3,FirstName7.IssuingCountryName,FirstName7.DocumentNumber,FirstName7.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D8(PnrDetails,FirstName8.TitleF3,FirstName8.FirstName,FirstName8.LastName,FirstName8.DobStrFlyadeal,FirstName8.Nationality,FirstName8.DocumentTypeF3,FirstName8.IssuingCountryName,FirstName8.DocumentNumber,FirstName8.PassportExpiryDateStrFlyadeal);
			    	
			}
			
			else if (totalPassengersString.equals("9")) {
				System.out.println("totalPassengers5:"+totalPassengersString);
				passengersDetails.adult_D1(PnrDetails,FirstName1.TitleF3,FirstName1.FirstName,FirstName1.LastName,FirstName1.DobStrFlyadeal,FirstName1.Nationality,FirstName1.DocumentTypeF3,FirstName1.IssuingCountryName,FirstName1.DocumentNumber,FirstName1.PassportExpiryDateStrFlyadeal);
				passengersDetails.adult_D2(PnrDetails,FirstName2.TitleF3,FirstName2.FirstName,FirstName2.LastName,FirstName2.DobStrFlyadeal,FirstName2.Nationality,FirstName2.DocumentTypeF3,FirstName2.IssuingCountryName,FirstName2.DocumentNumber,FirstName2.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D3(PnrDetails,FirstName3.TitleF3,FirstName3.FirstName,FirstName3.LastName,FirstName3.DobStrFlyadeal,FirstName3.Nationality,FirstName3.DocumentTypeF3,FirstName3.IssuingCountryName,FirstName3.DocumentNumber,FirstName3.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D4(PnrDetails,FirstName4.TitleF3,FirstName4.FirstName,FirstName4.LastName,FirstName4.DobStrFlyadeal,FirstName4.Nationality,FirstName4.DocumentTypeF3,FirstName4.IssuingCountryName,FirstName4.DocumentNumber,FirstName4.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D5(PnrDetails,FirstName5.TitleF3,FirstName5.FirstName,FirstName5.LastName,FirstName5.DobStrFlyadeal,FirstName5.Nationality,FirstName5.DocumentTypeF3,FirstName5.IssuingCountryName,FirstName5.DocumentNumber,FirstName5.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D6(PnrDetails,FirstName6.TitleF3,FirstName6.FirstName,FirstName6.LastName,FirstName6.DobStrFlyadeal,FirstName6.Nationality,FirstName6.DocumentTypeF3,FirstName6.IssuingCountryName,FirstName6.DocumentNumber,FirstName6.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D7(PnrDetails,FirstName7.TitleF3,FirstName7.FirstName,FirstName7.LastName,FirstName7.DobStrFlyadeal,FirstName7.Nationality,FirstName7.DocumentTypeF3,FirstName7.IssuingCountryName,FirstName7.DocumentNumber,FirstName7.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D8(PnrDetails,FirstName8.TitleF3,FirstName8.FirstName,FirstName8.LastName,FirstName8.DobStrFlyadeal,FirstName8.Nationality,FirstName8.DocumentTypeF3,FirstName8.IssuingCountryName,FirstName8.DocumentNumber,FirstName8.PassportExpiryDateStrFlyadeal);
			    passengersDetails.adult_D9(PnrDetails,FirstName9.TitleF3,FirstName9.FirstName,FirstName9.LastName,FirstName9.DobStrFlyadeal,FirstName9.Nationality,FirstName9.DocumentTypeF3,FirstName9.IssuingCountryName,FirstName9.DocumentNumber,FirstName9.PassportExpiryDateStrFlyadeal);
					
			}
			
           
        } 
        else if (paxList.size() == 1) {
        	 if (totalPassengersString.equals("1")) {
                 FirstName1 = paxList.get(0); 
                 F_phoneNumber=FirstName1.PhoneNumber;
                 F_FirstName=FirstName1.FirstName;
                 F_LastName=FirstName1.LastName;
    		     F_phoneNumber = F_phoneNumber.replaceAll("\\s", ""); 
    			 randomMail();
    			  F_CustomeremailId=FirstName1.Email;
    			  String [] Customeremail=F_CustomeremailId.split("@");
    			 F_emailWithCustomerName=Customeremail[0]+"@"+F_email_Random;
    			 F_Customer_Email=Customeremail[0]+".@"+F_email_Random; 
    			 F_mobileCode=FirstName1.MobileCode;
          	 }
        	 
        	 if (totalPassengersString.equals("1")) {
        		
 				System.out.println("totalPassengers1:"+totalPassengersString);
 				passengersDetails.adult_D1(PnrDetails,FirstName1.TitleF3,FirstName1.FirstName,FirstName1.LastName,FirstName1.DobStrFlyadeal,FirstName1.Nationality,FirstName1.DocumentTypeF3,FirstName1.IssuingCountryName,FirstName1.DocumentNumber,FirstName1.PassportExpiryDateStrFlyadeal);
				}
          
        } 
        else {
            System.out.println("There are not enough elements in the list.");
        }
		

		 
	}
	
	
	public static void randomMail() {
		F_email_Random = PageUtils.MailRandom();
		
	}

	public static void enterContactDetails(WebDriver driver, Database PnrDetails, double Amount, double UserPaidAmount)
			throws Exception {

		int Bag = Integer.parseInt(PnrDetails.Baggage);
		int InBag = Integer.parseInt(PnrDetails.InBaggage);
		//flyadealPage.btn_Pay_screenShot(PnrDetails);
		/*
		 * flyadealPage.chk_contact_pass1().click();
		 * PageUtils.waitForFixedTime(BrowserContants.WAIT_1_SEC);
		 * flyadealPage.country_Residence().click();
		 * flyadealPage.select_IssueingCountry(adult_1_nation); Thread.sleep(1000);
		 * flyadealPage.txt_Cityname().sendKeys(adult_1_nation);
		 */
		String CountryCode=driver.findElement(By.xpath("//span[@class='code']")).getText();
		System.out.println(CountryCode);
		flyadealPage.country_code().sendKeys(F_mobileCode);
		//flyadealPage.select_countrycode(F_mobileCode.replaceAll("+", ""));
		Thread.sleep(1000);
		flyadealPage.country_code_select().click();
		PageUtils.scrollDown4(driver);
		flyadealPage.txt_Mobile_Number().sendKeys(F_phoneNumber);
		//flyadealPage.txt_email().clear();
		flyadealPage.txt_email().sendKeys(F_emailWithCustomerName);
		System.out.println(F_emailWithCustomerName);
		Thread.sleep(1000);
		
		/*String F3Amount = flyadealPage.total_Amount().getText();
		String F3WebSiteAmount = F3Amount.split(" ")[0];
		String F3WEB = F3WebSiteAmount.replaceAll(",", "");
		F3WEBAMOUNT = Float.parseFloat(F3WEB);
		if (WEBAMOUNT >= F3WEBAMOUNT) {
			System.out.println("No Addons");
			} 
		else {
			try {
				flyadealPage.checkboxes_enable().click();
				Thread.sleep(1000);
				}
				catch(Exception e)
				{
					
				}
			
			try {
			flyadealPage.checkbox1().click();
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				
			}
			try {
			flyadealPage.checkbox2().click();
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				
			}
			try {
			flyadealPage.checkbox3().click();
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				
			}
			}*/
		
		uncheck_Checkboxes(driver, PnrDetails);
		//flyadealPage.btn_Pay_screenShot(PnrDetails);
		Thread.sleep(1000);
		
		
		ContinuePassengerPage(driver, PnrDetails, Amount, UserPaidAmount);

	}
	
	public static void uncheck_Checkboxes(WebDriver driver, Database PnrDetails) throws Exception {
	
		try {
			flyadealPage.checkboxes_enable().click();
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				
			}
		try {
			flyadealPage.checkbox1().click();
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				
			}
			try {
			flyadealPage.checkbox2().click();
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				
			}
			try {
			flyadealPage.checkbox3().click();
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				
			}
	}

	public static void ContinuePassengerPage(WebDriver driver, Database PnrDetails, double Amount,double UserPaidAmount) throws Exception {

		//flyadealPage.btn_Continue_Passengers().click();
		
		WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(continueButton).perform();
		
		System.out.println("ENTER PASSENGER DETAILS AND CLICK ON CONTINUE BUTTON");
		PageUtils.waitForFixedTime(BrowserContants.WAIT_10_SEC);

		try {
			//flyadealPage.txt_skip_bag_Page();
			PageUtils.isElementLocated(driver,	By.xpath("//h2[contains(text(),'Baggage Selection')]"));
			Thread.sleep(2000);
			System.out.println("Addons Page Displayed");
			
			String F3Amount = flyadealPage.total_Amount().getText();
			String F3WebSiteAmount = F3Amount.split(" ")[0];
			String F3WEB = F3WebSiteAmount.replaceAll(",", "");
			F3WEBAMOUNT = Float.parseFloat(F3WEB);
			if (WEBAMOUNT >= F3WEBAMOUNT) {
				CabinBaggage_Option(driver);
				} 
			else {
				CabinBaggage_Option(driver);
			}
			
			//url_PaymentPage(driver, PnrDetails, Amount, UserPaidAmount);
			newPayment(driver, PnrDetails, Amount, UserPaidAmount);
		} catch (Exception e7) {
	

			/*try {
				if ("Some fields are missing or incorrect, please review before continuing."
						.equals(flyadealPage.fields_Missing_alert(PnrDetails).getText())) {
					passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
							"Unable to validate travel documents(Retry Date updation 2nd attempt Failed)");
					System.out.println("Some fields are missing or incorrect, please review.");
					sendMail_FlyadealTeam(driver, PnrDetails);
					driver.quit();
				}
			} catch (Exception e8) {

			}*/

			try {
				flyadealPage.invalid_Request_alert(PnrDetails).isDisplayed();
				String text = flyadealPage.invalid_Request_Text().getText();
				flyadealPage.invalid_Request_Ok().click();
				PageUtils.waitForFixedTime(BrowserContants.WAIT_1_SEC);
				flyadealPage.btn_Continue_Passengers().click();
				PageUtils.waitForFixedTime(BrowserContants.WAIT_10_SEC);
				String Invalid_Request = text;
				if (Invalid_Request.equals(flyadealPage.invalid_Request_alert(PnrDetails).getText())) {

					flyadealPage.invalid_Request_Ok().click();
					PageUtils.waitForFixedTime(BrowserContants.WAIT_1_SEC);
					flyadealPage.btn_Continue_Passengers().click();
					PageUtils.waitForFixedTime(BrowserContants.WAIT_10_SEC);
					
					try {
						if (Invalid_Request.equals(flyadealPage.invalid_Request_alert(PnrDetails).getText())) {
							passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
									"Unable to validate travel documents(Retry Date updation 2nd attempt failed)");
							System.out.println("Invalid DOB : Unable to validate travel documents 2nd Time");
							sendMail_FlyadealTeam(driver, PnrDetails);
							driver.quit();
						}
					} catch (Exception e9) {

					}

					if ("Invalid Request".equals(flyadealPage.alert_Title().getText())) {
						passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
								"Unable to validate travel documents(Retry Date updation 2nd atttempt failed with original DOB)");
						System.out.println("Unable to validate travel documents 2nd Time");
						sendMail_FlyadealTeam(driver, PnrDetails);
						driver.quit();
					}

				}

				else {
					System.out.println("Invalid Request :Click On Second Time It's Working");
					PageUtils.waitForFixedTime(BrowserContants.WAIT_1_SEC);
				}
			} catch (Exception e) {
				System.out.println("Passport Alert Not Found");
				PageUtils.waitForFixedTime(BrowserContants.WAIT_1_SEC);
			}
			try {

				flyadealPage.skip_bag_Page();
				System.out.println("Addons Page Displayed");
			} catch (Exception e) {

			}

			String F3Amount = flyadealPage.total_Amount().getText();
			String F3WebSiteAmount = F3Amount.split(" ")[0];
			String F3WEB = F3WebSiteAmount.replaceAll(",", "");
			F3WEBAMOUNT = Float.parseFloat(F3WEB);
			if (WEBAMOUNT >= F3WEBAMOUNT) {
				CabinBaggage_Option(driver);
				} 
			else {
				CabinBaggage_Option(driver);
			}
			newPayment(driver, PnrDetails, Amount, UserPaidAmount);

		}
	}


public static void newPayment(WebDriver driver, Database PnrDetails, double Amount, double UserPaidAmount) throws Exception
{
	driver.get("https://www.flyadeal.com/en/payment-details");
	PageUtils.isElementLocated(driver,	By.xpath("//*/text()[normalize-space(.)='Booking Summary']/parent::*"));
	
	
	checkFlightDepartureDate(driver, PnrDetails);
	checkFlightTimings(driver, PnrDetails);
	checkFlightNumber(driver, PnrDetails);
	
	WebSiteAmount = flyadealPage.paymentPage_total_Amount().getText().replaceAll("[\r\n]+", "").replaceAll(" ", "");
	// WebSiteAmount=WebSiteAmount.split(" ")[1];
	String WEB = WebSiteAmount.replaceAll(",", "");
	//System.out.println("WebSite Amount is:" + WEB);
	//WEBAMOUNT = Float.parseFloat(WEB);
	String CurrencyType=driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Total price'])[1]/following::span[1]")).getText().replaceAll(" ", "");
	if(CurrencyType.equals("AED")) {
		// Conversion rate for AED to SAR
	    double aedToSARRate = 1.03; // Replace with your actual rate
	    WEBAMOUNT = Float.parseFloat(WEB) * (float) aedToSARRate;
	    System.out.println("WebSite Amount is AED :" + WEBAMOUNT);
		
	}
   else if(CurrencyType.equals("USD")) {
	   // Conversion rate for USD to SAR
	    double usdToSARRate = 3.76; // Replace with your actual rate
	    WEBAMOUNT = Float.parseFloat(WEB) * (float) usdToSARRate;
	    System.out.println("WebSite Amount is USD :" + WEBAMOUNT);
	}
   else if(CurrencyType.equals("JOD")) {
	   // Conversion rate for JOD to SAR
	    double jodToSARRate = 5.30; // Replace with your actual rate
	    WEBAMOUNT = Float.parseFloat(WEB) * (float) jodToSARRate;
	    System.out.println("WebSite Amount is JOD :" + WEBAMOUNT);
	}
   else if(CurrencyType.equals("SAR")) {
	   // Conversion rate for SAR 
	    double ToSARRate = 1.00; // Replace with your actual rate
	    WEBAMOUNT = Float.parseFloat(WEB) * (float) ToSARRate;
	    System.out.println("WebSite Amount is SAR :" + WEBAMOUNT);
	}
   else {
	   WEBAMOUNT = Float.parseFloat(WEB);
	   System.out.println("WebSite Amount is SAR :" + WEBAMOUNT);
   }
	if (Amount >= WEBAMOUNT) {

		System.out.println("API Amount:" + PnrDetails.Amount);
		System.out.println("WebSite Amount:" + WebSiteAmount);
	} else {
		if (UserPaidAmount >= WEBAMOUNT) {
			System.out.println("UserPaid Amount:" + PnrDetails.UserPaidAmount);
			System.out.println("WebSite Amount:" + WebSiteAmount);
		} else {
			passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId, " " + WebSiteAmount+ " Website amount is greater than " + PnrDetails.UserPaidAmount + " UserPaidAmount");
			System.out.println(WebSiteAmount + " Website amount is greater than "+ PnrDetails.UserPaidAmount + " UserPaidAmount");
			driver.quit();
		}
	}
}

	public static void checkFlightNumber(WebDriver driver, Database PnrDetails)
			throws InterruptedException, IOException {
		if ("OneWay".equals(PnrDetails.TripType)) {
			WebElement F1 = driver.findElement(By.xpath("(//div[@class='flight_number'])"));
			String FlightDetails = F1.getText().replaceAll(" ", "");
			String FlightNumberDep = FlightDetails;

			if (PnrDetails.DepartureFlightNumber.equals(FlightNumberDep)) {
				System.out.println("REHLAT FLIGHT NUMBER:" + PnrDetails.DepartureFlightNumber+ " FLYADEAL FLIGHT NUMBER:" + FlightNumberDep);
			} else {
				passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"REHLAT FLIGHT NO & FLYADEAL FLIGHT DOES NOT MATCH");
				System.out.println("REHLAT FLIGHT NO & FLYADEAL FLIGHT NO DOES NOT MATCH");
				driver.quit();
			}
		}

		else if ("RoundTrip".equals(PnrDetails.TripType)) {
			WebElement F1 = driver.findElement(By.xpath("(//div[@class='flight_number'])[1]"));
			String FlightDetails = F1.getText().replaceAll(" ", "");
			String FlightNumberDep = FlightDetails;

			if (PnrDetails.DepartureFlightNumber.equals(FlightNumberDep)) {
				System.out.println("REHLAT FLIGHT1 NUMBER:" + PnrDetails.DepartureFlightNumber+ " FLYADEAL FLIGHT1 NUMBER:" + FlightNumberDep);
			} else {
				passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"REHLAT FLIGHT1 NO & FLYADEAL FLIGHT1 DOES NOT MATCH");
				System.out.println("REHLAT FLIGHT1 NO & FLYADEAL FLIGHT1 NO DOES NOT MATCH");
				driver.quit();
			}

			WebElement F2 = driver.findElement(By.xpath("(//div[@class='flight_number'])[2]"));
			String FlightDetailsR = F2.getText().replaceAll(" ", "");
			String FlightNumberRet = FlightDetailsR;

			if (PnrDetails.ReturnFlightNumber.equals(FlightNumberRet)) {
				System.out.println("REHLAT FLIGHT2 NUMBER:" + PnrDetails.ReturnFlightNumber+ " FLYADEAL FLIGHT2 NUMBER:" + FlightNumberRet);
			} else {
				passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"REHLAT FLIGHT2 NO & FLYADEAL FLIGHT2 DOES NOT MATCH");
				System.out.println("REHLAT FLIGHT2 NO & FLYADEAL FLIGHT2 NO DOES NOT MATCH");
				driver.quit();
			}
		}

	}

	public static void checkFlightTimings(WebDriver driver, Database PnrDetails)
			throws InterruptedException, IOException {
		if ("OneWay".equals(PnrDetails.TripType)) {
			WebElement F1 = driver.findElement(By.xpath("(//h5[@class='journey-schedule_time'])[1]"));
			String FlightDepartureStartTime = F1.getText().replaceAll(" ", "");

			if (PnrDetails.DepartureStartTime.equals(FlightDepartureStartTime)) {
				System.out.println("REHLAT FLIGHT TIME:" + PnrDetails.DepartureStartTime + " FLYADEAL FLIGHT TIME:"
						+ FlightDepartureStartTime);
			} else {
				passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"REHLAT FLIGHT TIMING & FLYADEAL FLIGHT TIMING DOES NOT MATCH(document details element not found)");
				System.out.println("REHLAT FLIGHT TIMING & FLYADEAL FLIGHT TIMING DOES NOT MATCH");
				driver.quit();
			}
		}

		else if ("RoundTrip".equals(PnrDetails.TripType)) {
			WebElement F1 = driver.findElement(By.xpath("(//h5[@class='journey-schedule_time'])[1]"));
			String FlightDepartureStartTime = F1.getText().replaceAll(" ", "");

			if (PnrDetails.DepartureStartTime.equals(FlightDepartureStartTime)) {
				System.out.println("REHLAT FLIGHT2 TIME:" + PnrDetails.DepartureStartTime + " FLYADEAL FLIGHT2 TIME:"
						+ FlightDepartureStartTime);
			} else {
				passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"REHLAT FLIGHT TIMING & FLYADEAL FLIGHT TIMING DOES NOT MATCH(document details element not found)");
				System.out.println("REHLAT FLIGHT TIMING & FLYADEAL FLIGHT TIMING DOES NOT MATCH");
				driver.quit();
			}

			WebElement F2 = driver.findElement(By.xpath("(//h5[@class='journey-schedule_time'])[3]"));
			String FlightReturnStartTime = F2.getText().replaceAll(" ", "");

			if (PnrDetails.ReturnStartTime.equals(FlightReturnStartTime)) {
				System.out.println("REHLAT FLIGHT2 ReturnStartTime:" + PnrDetails.ReturnStartTime
						+ " FLYADEAL FLIGHT2 ReturnStartTime:" + FlightReturnStartTime);
			} else {
				passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
						"REHLAT FLIGHT2 TIMING & FLYADEAL FLIGHT2 TIMING DOES NOT MATCH(document details element not found)");
				System.out.println("REHLAT FLIGHT2 TIMING & FLYADEAL FLIGHT2 TIMING DOES NOT MATCH");
				driver.quit();
			}

		}

	}

	public static void checkFlightDepartureDate(WebDriver driver, Database PnrDetails)throws InterruptedException, IOException, ParseException {

		

		if ("OneWay".equals(PnrDetails.TripType)) {
			WebElement F1 = driver.findElement(By.xpath("//span[@class='journey-info-label city_code_label']"));
			String FlightDetails = F1.getText();
			String FlightDeptDate = FlightDetails.replaceAll(" ", "");
			// System.out.println(FlightDeptDate);
			SimpleDateFormat originalFormat = new SimpleDateFormat("dd-MMMM-yyyy");
            Date date = originalFormat.parse(PnrDetails.DepartureDate);

            // Format the Date object into the desired format
            SimpleDateFormat newFormat = new SimpleDateFormat("d-MMM-yyyy");
            String APIDate = newFormat.format(date);

			if (APIDate.replaceAll("-", "").equals(FlightDeptDate)) {
				System.out.println("REHLAT FLIGHT Dept Date: " + APIDate.replaceAll("-", "")+ " FLYADEAL FLIGHT Dept Date: " + FlightDeptDate);
			} else {
				passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"REHLAT FLIGHT DEPARTURE DATE & FLYADEAL FLIGHT DEPARTURE DATE DOES NOT MATCH");
				System.out.println("REHLAT FLIGHT DEPARTURE DATE & FLYADEAL FLIGHT DEPARTURE DATE DOES NOT MATCH");
				driver.quit();
			}
		}

		else if ("RoundTrip".equals(PnrDetails.TripType)) {
			WebElement F1 = driver.findElement(By.xpath("(//span[@class='journey-info-label city_code_label'])[1]"));
			String FlightF1Details = F1.getText();
			String FlightF1DeptDate = FlightF1Details.replaceAll(" ", "");
			SimpleDateFormat originalFormat = new SimpleDateFormat("dd-MMMM-yyyy");
            Date date = originalFormat.parse(PnrDetails.DepartureDate);

            // Format the Date object into the desired format
            SimpleDateFormat newFormat = new SimpleDateFormat("d-MMM-yyyy");
            String APIDate = newFormat.format(date);
            
			if (APIDate.replaceAll("-", "").equals(FlightF1DeptDate)) {
				System.out.println("REHLAT FLIGHT1 Dept Date: " +APIDate.replaceAll("-", "")
						+ " FLYADEAL FLIGHT1 Dept Date:" + FlightF1DeptDate);
			} else {
				passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"REHLAT FLIGHT DEPARTURE DATE & FLYADEAL FLIGHT DEPARTURE DATE DOES NOT MATCH");
				System.out.println("REHLAT FLIGHT DEPARTURE DATE & FLYADEAL FLIGHT DEPARTURE DATE DOES NOT MATCH");
				driver.quit();
			}

			WebElement F2 = driver.findElement(By.xpath("(//span[@class='journey-info-label city_code_label'])[2]"));
			String FlightF2DetailsR = F2.getText();
			String FlightRetDate = FlightF2DetailsR.replaceAll(" ", "");

			SimpleDateFormat originalFormat2 = new SimpleDateFormat("dd-MMMM-yyyy");
            Date date2 = originalFormat2.parse(PnrDetails.ReturnDate);

            // Format the Date object into the desired format
            SimpleDateFormat newFormat2 = new SimpleDateFormat("d-MMM-yyyy");
            String APIDateReturn = newFormat2.format(date2);

			
			if (APIDateReturn.replaceAll("-", "").equals(FlightRetDate)) {
				System.out.println("REHLAT FLIGHT2 Dept Date:" +APIDateReturn.replaceAll("-", "")+ " FLYADEAL FLIGHT2 Dept Date:" + FlightRetDate);
			} else {
				passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,"REHLAT FLIGHT RETURN DATE & FLYADEAL FLIGHT RETURN DATE DOES NOT MATCH");
				System.out.println("REHLAT FLIGHT2 DEPARTURE DATE & FLYADEAL FLIGHT2 DEPARTURE DATE DOES NOT MATCH");
				driver.quit();
			}
		}

	}

	public static void enterCardDetails_NEC(Database PnrDetails) throws Exception {

		flyadealPage.select_creditCard(PnrDetails).click();
		enetCardApi(PnrDetails);
		PageUtils.waitForFixedTime(BrowserContants.WAIT_1_SEC);
        try {
			flyadealPage.select_creditCard(PnrDetails).click();
			String CustomerName = F_FirstName + "" + F_LastName;
			CustomerName = CustomerName.substring(0, Math.min(CustomerName.length(), 9));
			System.out.println("CARD HOLDER NAME:" + CustomerName);
			// Card Details
			flyadealPage.txt_CardNumber().sendKeys(cardNumber);
			flyadealPage.txt_Cardholder_Name().sendKeys(CustomerName.replaceAll(" ", ""));
			Thread.sleep(1000);
			flyadealPage.drp_ExpMonth().click();
			Thread.sleep(1000);
			flyadealPage.card_select_Month(expiryMonth);
			Thread.sleep(1000);
			flyadealPage.drp_ExpYear().click();
			Thread.sleep(1000);
			flyadealPage.card_select_Year(expiryYear);
			Thread.sleep(1000);
			flyadealPage.txt_CVV_Number().sendKeys(CVV);
			
			//flyadealPage.btn_Pay_screenShot(PnrDetails);
			PageUtils.waitForFixedTime(BrowserContants.WAIT_2_SEC);
			try {
				flyadealPage.chk_Aggree().click();
				PageUtils.waitForFixedTime(BrowserContants.WAIT_1_SEC);
			} catch (Exception e) {
			}
			flyadealPage.btn_Pay(PnrDetails).click();
			System.out.println("CLICK ON PAY BUTTON");
			PageUtils.waitForFixedTime(BrowserContants.WAIT_5_SEC);
			//flyadealPage.btn_Pay_screenShot(PnrDetails);
			// TimeUnit.MINUTES.sleep(1);
		} catch (Exception e) {

			/*
			 * passengersDetails.returnStatus_fail(PnrDetails.Domain,PnrDetails.
			 * PnrId,"Payment Gateway Error(document details element not found)");
			 * PageUtils.getScreenShot(PnrDetails.PnrId,driver);
			 * System.out.println("PAYMENT GATWAY ERROR"); driver.quit();
			 */
		}
		String PnrNum = GetPnr(driver, PnrDetails);
		PnrId = PnrNum;
		try {

			returnStatus(PnrDetails, PnrNum, WebSiteAmount);
			System.out.println("PNR Updated Succeesfully");
		} catch (Exception e) {

		}

		generateMail(PnrDetails);

		try {
			TimeUnit.SECONDS.sleep(2);
			returnStatus(PnrDetails, PnrNum, WebSiteAmount);
			System.out.println("2nd Time PNR Updated Succeesfully");
		} catch (Exception e) {

		}
	}



	public static void enterCardDetails_AUBCC(Database PnrDetails) throws Exception {
		flyadealPage.select_creditCard(PnrDetails).click();
		//PageUtils.waitForFixedTime(BrowserContants.WAIT_1_SEC);
        try {
			flyadealPage.select_creditCard(PnrDetails).click();
			String CustomerName = F_FirstName + "" + F_LastName;
			CustomerName = CustomerName.substring(0, Math.min(CustomerName.length(), 9));
			System.out.println("CARD HOLDER NAME:" + CustomerName);
			// Card Details
			flyadealPage.txt_CardNumber().sendKeys("5215337136552185");
			flyadealPage.txt_Cardholder_Name().sendKeys(CustomerName.replaceAll(" ", ""));
			Thread.sleep(1000);
			flyadealPage.drp_ExpMonth().click();
			Thread.sleep(1000);
			flyadealPage.card_select_Month("10");
			Thread.sleep(1000);
			flyadealPage.drp_ExpYear().click();
			Thread.sleep(1000);
			flyadealPage.card_select_Month("2026");
			Thread.sleep(1000);
			flyadealPage.txt_CVV_Number().sendKeys("812");
			
			//flyadealPage.btn_Pay_screenShot(PnrDetails);
			PageUtils.waitForFixedTime(BrowserContants.WAIT_2_SEC);
			try {
				flyadealPage.chk_Aggree().click();
				PageUtils.waitForFixedTime(BrowserContants.WAIT_1_SEC);
			} catch (Exception e) {
			}
			flyadealPage.btn_Pay(PnrDetails).click();
			System.out.println("CLICK ON PAY BUTTON");
			PageUtils.waitForFixedTime(BrowserContants.WAIT_5_SEC);
			//flyadealPage.btn_Pay_screenShot(PnrDetails);
			// TimeUnit.SECONDS.sleep(80);
		} catch (Exception e) {

			
		}
		String PnrNum = GetPnr(driver, PnrDetails);
		PnrId = PnrNum;
		try {

			returnStatus(PnrDetails, PnrNum, WebSiteAmount);
			System.out.println("PNR Updated Succeesfully");
		} catch (Exception e) {

		}

		// generateMail(PnrDetails);
		generateMail_AUBCC(PnrDetails);

		try {
			TimeUnit.SECONDS.sleep(2);
			returnStatus(PnrDetails, PnrNum, WebSiteAmount);
			System.out.println("2nd Time PNR Updated Succeesfully");
		} catch (Exception e) {

		}
	}

	public static String GetPnr(WebDriver driver, Database PnrDetails) throws Exception {

		System.out.println("CurrencyCode:" + currencyCode);
		Thread.sleep(20000);
		//flyadealPage.btn_Pay_screenShot(PnrDetails);

		try {

			String BookingStatus = flyadealPage.PNR_Confirm_Text(PnrDetails).getText();
			String BookingReference = BookingStatus.split(" ")[0];
			if ("Your".equals(BookingReference)) {
				PnrId = flyadealPage.PNR_ID(PnrDetails).getText().replaceAll(" ", "");
				System.out.println("Booking Reference:" + PnrId);
				System.out.println(BookingStatus);
				PageUtils.waitForFixedTime(BrowserContants.WAIT_1_SEC);
			}

			else {
				
			}

		} catch (Exception e3) {
			
			try {
				PnrId = driver.findElement(By.xpath("//strong[@class='reference_id']")).getText().replaceAll(" ", "");
				System.out.println("Booking Reference:" + PnrId);
				PageUtils.waitForFixedTime(BrowserContants.WAIT_1_SEC);
			}
			catch (Exception e) {
				
			}
			//flyadealPage.btn_Pay_screenShot(PnrDetails);
			generateMail_PNR_NotUpdated(driver, PnrDetails);
			//flyadealPage.btn_Pay_screenShot(PnrDetails);
			browser_Quit(driver, PnrDetails);

		}

		return PnrId;
	}

	public static void browser_Quit(WebDriver driver, Database PnrDetails) throws Exception {
		driver.quit();
		System.out.println("Browser Closed");
	}

	public static void Fly_Alert(WebDriver driver) throws Exception {
		try {
			Actions act = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath("//*/text()[normalize-space(.)='No, Thank you']/parent::*"));
			//act.doubleClick(ele).perform();
			ele.click();
		} catch (Exception e3) {

		}
	}

	public static void CabinBaggage_Option(WebDriver driver) throws Exception {
		try {
			flyadealPage.txt_Included().isDisplayed();
			flyadealPage.btn_select_baggage().click();
			Thread.sleep(3000);
			flyadealPage.btn_select_baggage().click();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			try {
			flyadealPage.btn_select_baggage().click();
			Thread.sleep(2000);
			}
			catch (Exception ee) {
				
			}
		}
	}

	
    
	public static void fareHikeMail_FlyadealTeam(WebDriver driver, Database pnrDetails) throws Exception {

		StringBuilder htmlStringBuilder = new StringBuilder();
		System.out.println("Started");
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("gopi.cherukumalli@rehlat.com", "8886166175Gp"));
		email.setSSLOnConnect(true);
		email.setFrom("gopich3889@gmail.com");
		email.setSubject("REG: Fare Hike - " + pnrDetails.Domain + " Booking ID - " + pnrDetails.PnrId + "");
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>Dear Team,</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>The below booking resulted in a Fare hike.</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append(
				"<tr>Please collect the fare hike amount from the customer through an additional payment link.</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder
				.append("<tr><b>Customer Paid Amount : " + pnrDetails.UserPaidAmount + "</b> </tr>"));
		email.setHtmlMsg("" + htmlStringBuilder
				.append("<tr><b>Current Flight Available Price      : " + flyaDealModule.WebSiteAmount + "</b> </tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr></tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr></tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>--</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr> Thanks & Regards  </tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr><b> Gopi Cherukumalli  </b></tr>"));

		email.addTo("api.operations@rehlat.com");
		email.addCc("tariqraza@rehlat.com");
		email.addCc("sreenivas.bodige@rehlat.com");
		// email.addCc("gopi.cherukumalli@rehlat.com");
		email.send();

	}

	public static String TodayName() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		return new SimpleDateFormat("EEEE").format(cal.getTime());

	}



	public static void generateMail_PNR_NotUpdated(WebDriver driver, Database pnrDetails) throws Exception {
		generateMail_GmailPNR(driver, pnrDetails);
		StringBuilder htmlStringBuilder = new StringBuilder();
		System.out.println("Started");
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		System.out.println("PNR Not Updated :Sending Mail to OPS Team");
		email.setAuthenticator(new DefaultAuthenticator("gopi.cherukumalli@rehlat.com", "8886166175Gp"));
		email.setSSLOnConnect(true);
		email.setFrom("gopich3889@gmail.com");
		email.setSubject("FlyaDeal Booking PNR Issue " + pnrDetails.Domain + "_" + pnrDetails.PnrId);
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>Dear Team,</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>Please check PNR for " + pnrDetails.Domain + "_"
				+ pnrDetails.PnrId + " from flyadeal emails because NEC Card is generated for this booking. </tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>Please check with below Email ID in your Inbox.</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr></tr>"));
		email.setHtmlMsg("" + htmlStringBuilder
				.append("<tr>Customer Email ID: <b>" +F_emailWithCustomerName+"</b> </tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr></tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr></tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>--</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr> Thanks & Regards  </tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr><b> Gopi Cherukumalli  </b></tr>"));
		email.addTo("qainterns@rehlat.com");
		email.addCc("sreenivas.bodige@rehlat.com");
		email.addCc("gopi.cherukumalli@rehlat.com");
		email.send();

	}

	public static void generateMail_GmailPNR(WebDriver driver, Database pnrDetails) throws Exception {

		Date depDate = new SimpleDateFormat("dd-MMM-yyyy").parse(pnrDetails.DepartureDate);
		SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
		String strDate = formatter.format(depDate);
		System.out.println("strDate :" + strDate);

		StringBuilder htmlStringBuilder = new StringBuilder();
		System.out.println("Started");
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("gopi.cherukumalli@rehlat.com", "8886166175Gp"));
		email.setSSLOnConnect(true);
		email.setFrom("gopich3889@gmail.com");
		String s = F_FirstName.replaceAll(" ", "") + F_LastName.replaceAll(" ", "");
		email.setSubject("" + pnrDetails.Domain + " " + pnrDetails.PnrId + " " + passengersDetails.ProcessIdValue + " "
				+ s + " " + pnrDetails.DepartureFlightNumber + " " + pnrDetails.DepartureStartTime + " " + strDate + " "
				+ F_emailWithCustomerName + " " + transactionID + " " + currencyCode + "");
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>Dear Team,</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>Please check</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr></tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>--</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr> Thanks & Regards  </tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr><b> Gopi Cherukumalli  </b></tr>"));

		email.addTo("automation@rehlat.com");
		email.send();

	}

	public static void sendMail_FlyadealTeam(WebDriver driver, Database pnrDetails) throws Exception {

		StringBuilder htmlStringBuilder = new StringBuilder();
		System.out.println("Started");
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("gopi.cherukumalli@rehlat.com", "8886166175Gp"));
		email.setSSLOnConnect(true);
		email.setFrom("gopich3889@gmail.com");
		email.setSubject("REG: Travel Document Error- " + pnrDetails.Domain + " Booking ID - " + pnrDetails.PnrId + "");
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>Dear Team,</tr>"));
		email.setHtmlMsg(
				"" + htmlStringBuilder.append("<tr>The below booking resulted in a travel document error.</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append(
				"<tr>Please collect the document from the customer and correct the pax details to confirm this booking.</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append(
				"<tr>Kindly acknowledge back this email once the pax details are corrected and updated in the call center tool for this booking <b>"
						+ pnrDetails.PnrId + "</b>.</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr></tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr></tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>--</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr> Thanks & Regards  </tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr><b> Gopi Cherukumalli  </b></tr>"));

		email.addTo("api.operations@rehlat.com");
		email.addCc("team.operations@rehlat.com");
		email.addCc("tariqraza@rehlat.com");
		email.addCc("sreenivas.bodige@rehlat.com");
		// email.addCc("gopi.cherukumalli@rehlat.com");

		email.send();

	}


	public static void checkFlightType(WebDriver driver, Database PnrDetails) throws InterruptedException, IOException {

		if ("OneWay".equals(PnrDetails.TripType)) {
			String bag = PnrDetails.Baggage;
			if (bag.equals("0")) {
				WebElement F1 = driver
						.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/following::span[2]"));
				String FlightTpe = F1.getText();
				System.out.println(FlightTpe);

				if ("fly".equals(FlightTpe)) {
					System.out.println("Fly Flight Type Matched");
				} else {

					passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
							"Flight Type Does Not Match(document details element not found)");
					System.out.println("Flight Type Doesn't Match");
					driver.quit();
				}
			} else {
				WebElement F1 = driver
						.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/following::span[2]"));
				String FlightTpe = F1.getText();
				System.out.println(FlightTpe);

				if ("fly+".equals(FlightTpe)) {
					System.out.println("Fly+ Flight Type Matched");
				} else {

					passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
							"Flight Type Does Not Match(document details element not found)");
					System.out.println("Flight Type Doesn't Match");
					driver.quit();
				}
			}
		}

		else if ("RoundTrip".equals(PnrDetails.TripType)) {

			String bag = PnrDetails.Baggage;
			if (bag.equals("0")) {
				WebElement F1 = driver
						.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/following::span[2]"));
				String FlightTpe = F1.getText();
				System.out.println(FlightTpe);

				if ("fly".equals(FlightTpe)) {
					System.out.println("Fly Flight Type Matched");
				} else {

					passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
							"Flight Type Does Not Match(document details element not found)");
					System.out.println("Flight Type Doesn't Match");
					driver.quit();
				}
			}

			else {
				WebElement F1 = driver
						.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/following::span[2]"));
				String FlightTpe = F1.getText();
				System.out.println(FlightTpe);

				if ("fly+".equals(FlightTpe)) {
					System.out.println("Fly+ Flight Type Matched");
				} else {

					passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
							"Flight Type Does Not Match(document details element not found)");
					System.out.println("Flight Type Doesn't Match");
					driver.quit();
				}
			}

			String Inbag = PnrDetails.InBaggage;
			if (Inbag.equals("0")) {
				WebElement F2 = driver
						.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[2]/following::span[2]"));
				String FlightTpe2 = F2.getText();
				System.out.println(FlightTpe2);

				if ("fly".equals(FlightTpe2)) {
					System.out.println("Fly Flight Type Matched");
				} else {

					passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
							"Flight Type Does Not Match(document details element not found)");
					System.out.println("Flight Type Doesn't Match");
					driver.quit();
				}
			}

			else {
				WebElement F2 = driver
						.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[2]/following::span[2]"));
				String FlightTpe2 = F2.getText();
				System.out.println(FlightTpe2);

				if ("fly+".equals(FlightTpe2)) {
					System.out.println("Fly+ Flight Type Matched");
				} else {

					passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
							"Flight Type Does Not Match(document details element not found)");
					System.out.println("Flight Type Doesn't Match");
					driver.quit();
				}
			}
		}
	}
}
