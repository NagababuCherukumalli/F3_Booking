package FlyModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageObjects.CardDetails;
import pageObjects.Database;
import pageObjects.PageUtils;
import pageObjects.Pax;
import pageObjects.flyadealPage;




public class passengersDetails {
	
	static String email_Random;
	static String Nationality_I;
	
	
	static String phoneNumber;
	static String emailId;
	static String CountryCode;
	static String mobileCode;
	static String CityName;
	static int OneWayBag;
	static int RoundBag;
	static String AddAdditionalBag;
	static String Cvv;
	static WebDriver driver;
	
	static String CustomeremailId;
	static String ProcessIdValue="003";
	static String emailWithCustomerName;
	static String Customer_Email;
	
	static String cardNumber;
	static String CVV;
	static String expiryMonth;
	static String expiryYear;
	static String transactionID;
	static String currencyCode;
	static String VCNType;
	
	
	
	public static void ENTER() throws AWTException, InterruptedException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public static void adult_D1(Database Pnrdetails,String T,String FN,String LN,String date,String NA,String DT,String IC,String DN,String expdate) throws Exception {
		
		if (DT.equals("National ID number")) {
		    DT = "National ID";
		} else {
		   
		}
		System.out.println("p.TitleF3:-"+FN);
		System.out.println("Document number is:"+DN);
		try {
		flyadealPage.select_country().click();
		flyadealPage.select_country_saudi().click();
		}
		catch(Exception e) {
			
		}
		flyadealPage.drp_title_1().click();
		flyadealPage.select_Title(T);
		flyadealPage.firstname_1().sendKeys(FN);
		flyadealPage.lastname_1().sendKeys(LN);
		flyadealPage.date_click1().click();
		String[] Dh=date.split("-");
		String d=Dh[0];
		String m=Dh[1];
		String y=Dh[2];
		flyadealPage.selectYear(y);
		Thread.sleep(500);
		flyadealPage.selectMonth(m);
		Thread.sleep(500);
		flyadealPage.selectDate(d);
		Thread.sleep(500);
		flyadealPage.drp_nationality1().sendKeys(NA);
		flyadealPage.select_Title(NA);
		Thread.sleep(500);
		try {
		System.out.println("Document number is:"+DN);
		System.out.println("Document Type:"+DT);
		flyadealPage.drp_docType1().sendKeys(DT);
		Thread.sleep(500);
		flyadealPage.select_Title(DT);
		Thread.sleep(500);
		flyadealPage.drp_issuing_cou1().sendKeys(IC);
		Thread.sleep(500);
		flyadealPage.select_Title(IC);
		flyadealPage.enter_doc_number1().sendKeys(DN);
		System.out.println("Document Type:"+DT);
		if(!DT.equals("National ID"))
		{
			flyadealPage.drp_expDate_click1().click();
			String[] ep=expdate.split("-");
			String ed=ep[0];
			String em=ep[1];
			String ey=ep[2];
			flyadealPage.selectYear(ey);
			Thread.sleep(500);
			flyadealPage.selectMonth(em);
			Thread.sleep(500);
			flyadealPage.selectDate(ed);
			Thread.sleep(500);
		}
	}
	catch(Exception e)
	{
		
	}
	}
public static void adult_D2(Database Pnrdetails,String T,String FN,String LN,String date,String NA,String DT,String IC,String DN,String expdate) throws Exception {
	if (T.equals("MASTER.")) {
	    T = "Master";
	} else if (T.equals("MISS.")) {
	    T = "Miss";
	} else {
	    // No action needed for other cases
	}
	if (DT.equals("National ID number")) {
	    DT = "National ID";
	} else {
	   
	}
	try {
		flyadealPage.select_country2().click();
		flyadealPage.select_country_saudi().click();
		}
		catch(Exception e) {
			
		}
	flyadealPage.drp_title_Reuse2().click();
	flyadealPage.select_Title(T);
	flyadealPage.firstname_2().sendKeys(FN);
	flyadealPage.lastname_2().sendKeys(LN);
	flyadealPage.date_click2().click();
	String[] Dh=date.split("-");
	 String d=Dh[0];
	 String m=Dh[1];
	 String y=Dh[2];
	flyadealPage.selectYear(y);
	Thread.sleep(1000);
	flyadealPage.selectMonth(m);
	Thread.sleep(1000);
	flyadealPage.selectDate(d);
	Thread.sleep(1000);
	
	flyadealPage.drp_nationality2().sendKeys(NA);
	flyadealPage.select_Title(NA);
	Thread.sleep(1000);
	try {
	flyadealPage.drp_docType2().sendKeys(DT);
	Thread.sleep(1000);
	flyadealPage.select_Title(DT);
	Thread.sleep(1000);
	flyadealPage.drp_issuing_cou2().sendKeys(IC);
	flyadealPage.select_Title(IC);
	Thread.sleep(1000); 
	flyadealPage.enter_doc_number2().sendKeys(DN);
	
	if(!DT.equals("National ID"))
	{
		flyadealPage.drp_expDate_click2().click();
		String[] ep=expdate.split("-");
		 String ed=ep[0];
		 String em=ep[1];
		 String ey=ep[2];
		flyadealPage.selectYear(ey);
		Thread.sleep(1000);
		flyadealPage.selectMonth(em);
		Thread.sleep(1000);
		flyadealPage.selectDate(ed);
		Thread.sleep(1000);
	}
}
catch(Exception e)
{
	
}
	}
public static void adult_D3(Database Pnrdetails,String T,String FN,String LN,String date,String NA,String DT,String IC,String DN,String expdate) throws Exception {
	if (T.equals("MASTER.")) {
	    T = "Master";
	} else if (T.equals("MISS.")) {
	    T = "Miss";
	} else {
	    // No action needed for other cases
	}
	if (DT.equals("National ID number")) {
	    DT = "National ID";
	} else {
	   
	}
	try {
		flyadealPage.select_country3().click();
		flyadealPage.select_country_saudi().click();
		}
		catch(Exception e) {
			
		}
	flyadealPage.drp_title_Reuse3().click();
	flyadealPage.select_Title(T);
	flyadealPage.firstname_3().sendKeys(FN);
	flyadealPage.lastname_3().sendKeys(LN);
	flyadealPage.date_click3().click();
	String[] Dh=date.split("-");
	 String d=Dh[0];
	 String m=Dh[1];
	 String y=Dh[2];
	flyadealPage.selectYear(y);
	Thread.sleep(1000);
	flyadealPage.selectMonth(m);
	Thread.sleep(1000);
	flyadealPage.selectDate(d);
	Thread.sleep(1000);
	flyadealPage.drp_nationality3().sendKeys(NA);
	flyadealPage.select_Title(NA);
	try {
	flyadealPage.drp_docType3().sendKeys(DT);
	flyadealPage.select_Title(DT);
	flyadealPage.drp_issuing_cou3().sendKeys(IC);
	flyadealPage.select_Title(IC);
	flyadealPage.enter_doc_number3().sendKeys(DN);
	
	if(!DT.equals("National ID"))
	{
		flyadealPage.drp_expDate_click3().click();
		String[] ep=expdate.split("-");
		 String ed=ep[0];
		 String em=ep[1];
		 String ey=ep[2];
		flyadealPage.selectYear(ey);
		Thread.sleep(1000);
		flyadealPage.selectMonth(em);
		Thread.sleep(1000);
		flyadealPage.selectDate(ed);
		Thread.sleep(1000);
	}
	}
	catch(Exception e)
	{
		
	}
}
public static void adult_D4(Database Pnrdetails,String T,String FN,String LN,String date,String NA,String DT,String IC,String DN,String expdate) throws Exception {
	if (T.equals("MASTER.")) {
	    T = "Master";
	} else if (T.equals("MISS.")) {
	    T = "Miss";
	} else {
	    // No action needed for other cases
	}
	if (DT.equals("National ID number")) {
	    DT = "National ID";
	} else {
	   
	}
	try {
		flyadealPage.select_country4().click();
		flyadealPage.select_country_saudi().click();
		}
		catch(Exception e) {
			
		}
	flyadealPage.drp_title_Reuse4().click();
	flyadealPage.select_Title(T);
	flyadealPage.firstname_4().sendKeys(FN);
	flyadealPage.lastname_4().sendKeys(LN);
	flyadealPage.date_click4().click();
	String[] Dh=date.split("-");
	 String d=Dh[0];
	 String m=Dh[1];
	 String y=Dh[2];
	flyadealPage.selectYear(y);
	Thread.sleep(1000);
	flyadealPage.selectMonth(m);
	Thread.sleep(1000);
	flyadealPage.selectDate(d);
	Thread.sleep(1000);
	flyadealPage.drp_nationality4().sendKeys(NA);
	flyadealPage.select_Title(NA);
	try {
	flyadealPage.drp_docType4().sendKeys(DT);
	flyadealPage.select_Title(DT);
	flyadealPage.drp_issuing_cou4().sendKeys(IC);
	flyadealPage.select_Title(IC);
	flyadealPage.enter_doc_number4().sendKeys(DN);
	if(!DT.equals("National ID"))
	{
		flyadealPage.drp_expDate_click4().click();
		String[] ep=expdate.split("-");
		 String ed=ep[0];
		 String em=ep[1];
		 String ey=ep[2];
		flyadealPage.selectYear(ey);
		Thread.sleep(1000);
		flyadealPage.selectMonth(em);
		Thread.sleep(1000);
		flyadealPage.selectDate(ed);
		Thread.sleep(1000);
	}
	}
	catch(Exception e)
	{
		
	}
}
public static void adult_D5(Database Pnrdetails,String T,String FN,String LN,String date,String NA,String DT,String IC,String DN,String expdate) throws Exception {
	if (T.equals("MASTER.")) {
	    T = "Master";
	} else if (T.equals("MISS.")) {
	    T = "Miss";
	} else {
	    // No action needed for other cases
	}
	if (DT.equals("National ID number")) {
	    DT = "National ID";
	} else {
	   
	}
	try {
		flyadealPage.select_country5().click();
		flyadealPage.select_country_saudi().click();
		}
		catch(Exception e) {
			
		}
	flyadealPage.drp_title_Reuse5().click();
	flyadealPage.select_Title(T);
	flyadealPage.firstname_5().sendKeys(FN);
	flyadealPage.lastname_5().sendKeys(LN);
	flyadealPage.date_click5().click();
	String[] Dh=date.split("-");
	 String d=Dh[0];
	 String m=Dh[1];
	 String y=Dh[2];
	flyadealPage.selectYear(y);
	Thread.sleep(1000);
	flyadealPage.selectMonth(m);
	Thread.sleep(1000);
	flyadealPage.selectDate(d);
	Thread.sleep(1000);
	flyadealPage.drp_nationality5().sendKeys(NA);
	flyadealPage.select_Title(NA);
	try {
		flyadealPage.drp_docType5().sendKeys(DT);
	flyadealPage.select_Title(DT);
	flyadealPage.drp_issuing_cou5().sendKeys(IC);
	flyadealPage.select_Title(IC);
	flyadealPage.enter_doc_number5().sendKeys(DN);
	if(!DT.equals("National ID"))
	{
		flyadealPage.drp_expDate_click5().click();
		String[] ep=expdate.split("-");
		 String ed=ep[0];
		 String em=ep[1];
		 String ey=ep[2];
		flyadealPage.selectYear(ey);
		Thread.sleep(1000);
		flyadealPage.selectMonth(em);
		Thread.sleep(1000);
		flyadealPage.selectDate(ed);
		Thread.sleep(1000);
	}
	}
	catch(Exception e)
	{
		
	}
}
public static void adult_D6(Database Pnrdetails,String T,String FN,String LN,String date,String NA,String DT,String IC,String DN,String expdate) throws Exception {
	if (T.equals("MASTER.")) {
	    T = "Master";
	} else if (T.equals("MISS.")) {
	    T = "Miss";
	} else {
	    // No action needed for other cases
	}
	if (DT.equals("National ID number")) {
	    DT = "National ID";
	} else {
	   
	}
	try {
		flyadealPage.select_country6().click();
		flyadealPage.select_country_saudi().click();
		}
		catch(Exception e) {
			
		}
	flyadealPage.drp_title_Reuse6().click();
	flyadealPage.select_Title(T);
	flyadealPage.firstname_6().sendKeys(FN);
	flyadealPage.lastname_6().sendKeys(LN);
	flyadealPage.date_click6().click();
	String[] Dh=date.split("-");
	 String d=Dh[0];
	 String m=Dh[1];
	 String y=Dh[2];
	flyadealPage.selectYear(y);
	Thread.sleep(1000);
	flyadealPage.selectMonth(m);
	Thread.sleep(1000);
	flyadealPage.selectDate(d);
	Thread.sleep(1000);
	flyadealPage.drp_nationality6().sendKeys(NA);
	flyadealPage.select_Title(NA);
	try {
		flyadealPage.drp_docType6().sendKeys(DT);
		flyadealPage.select_Title(DT);
		flyadealPage.drp_issuing_cou6().sendKeys(IC);
		flyadealPage.select_Title(IC);
		flyadealPage.enter_doc_number6().sendKeys(DN);
		if(!DT.equals("National ID"))
		{
			flyadealPage.drp_expDate_click6().click();
			String[] ep=expdate.split("-");
			 String ed=ep[0];
			 String em=ep[1];
			 String ey=ep[2];
			flyadealPage.selectYear(ey);
			Thread.sleep(1000);
			flyadealPage.selectMonth(em);
			Thread.sleep(1000);
			flyadealPage.selectDate(ed);
			Thread.sleep(1000);
		}
		}
		catch(Exception e)
		{
			
		}
}
public static void adult_D7(Database Pnrdetails,String T,String FN,String LN,String date,String NA,String DT,String IC,String DN,String expdate) throws Exception {
	if (T.equals("MASTER.")) {
	    T = "Master";
	} else if (T.equals("MISS.")) {
	    T = "Miss";
	} else {
	    // No action needed for other cases
	}
	if (DT.equals("National ID number")) {
	    DT = "National ID";
	} else {
	   
	}
	try {
		flyadealPage.select_country7().click();
		flyadealPage.select_country_saudi().click();
		}
		catch(Exception e) {
			
		}
	flyadealPage.drp_title_Reuse7().click();
	flyadealPage.select_Title(T);
	flyadealPage.firstname_7().sendKeys(FN);
	flyadealPage.lastname_7().sendKeys(LN);
	flyadealPage.date_click7().click();
	String[] Dh=date.split("-");
	 String d=Dh[0];
	 String m=Dh[1];
	 String y=Dh[2];
	flyadealPage.selectYear(y);
	Thread.sleep(1000);
	flyadealPage.selectMonth(m);
	Thread.sleep(1000);
	flyadealPage.selectDate(d);
	Thread.sleep(1000);
	flyadealPage.drp_nationality7().sendKeys(NA);
	flyadealPage.select_Title(NA);
	try {
		flyadealPage.drp_docType7().sendKeys(DT);
		flyadealPage.select_Title(DT);
		flyadealPage.drp_issuing_cou7().sendKeys(IC);
		flyadealPage.select_Title(IC);
		flyadealPage.enter_doc_number7().sendKeys(DN);
		if(!DT.equals("National ID"))
		{
			flyadealPage.drp_expDate_click7().click();
			String[] ep=expdate.split("-");
			 String ed=ep[0];
			 String em=ep[1];
			 String ey=ep[2];
			flyadealPage.selectYear(ey);
			Thread.sleep(1000);
			flyadealPage.selectMonth(em);
			Thread.sleep(1000);
			flyadealPage.selectDate(ed);
			Thread.sleep(1000);
		}
		}
		catch(Exception e)
		{
			
		}
}
public static void adult_D8(Database Pnrdetails,String T,String FN,String LN,String date,String NA,String DT,String IC,String DN,String expdate) throws Exception {
	if (T.equals("MASTER.")) {
	    T = "Master";
	} else if (T.equals("MISS.")) {
	    T = "Miss";
	} else {
	    // No action needed for other cases
	}
	if (DT.equals("National ID number")) {
	    DT = "National ID";
	} else {
	   
	}
	try {
		flyadealPage.select_country8().click();
		flyadealPage.select_country_saudi().click();
		}
		catch(Exception e) {
			
		}
	flyadealPage.drp_title_Reuse8().click();
	flyadealPage.select_Title(T);
	flyadealPage.firstname_8().sendKeys(FN);
	flyadealPage.lastname_8().sendKeys(LN);
	flyadealPage.date_click8().click();
	String[] Dh=date.split("-");
	 String d=Dh[0];
	 String m=Dh[1];
	 String y=Dh[2];
	flyadealPage.selectYear(y);
	Thread.sleep(1000);
	flyadealPage.selectMonth(m);
	Thread.sleep(1000);
	flyadealPage.selectDate(d);
	Thread.sleep(1000);
	flyadealPage.drp_nationality8().sendKeys(NA);
	flyadealPage.select_Title(NA);
	try {
		flyadealPage.drp_docType8().sendKeys(DT);
		flyadealPage.select_Title(DT);
		flyadealPage.drp_issuing_cou8().sendKeys(IC);
		flyadealPage.select_Title(IC);
		flyadealPage.enter_doc_number8().sendKeys(DN);
		if(!DT.equals("National ID"))
		{
			flyadealPage.drp_expDate_click8().click();
			String[] ep=expdate.split("-");
			 String ed=ep[0];
			 String em=ep[1];
			 String ey=ep[2];
			flyadealPage.selectYear(ey);
			Thread.sleep(1000);
			flyadealPage.selectMonth(em);
			Thread.sleep(1000);
			flyadealPage.selectDate(ed);
			Thread.sleep(1000);
		}
		}
		catch(Exception e)
		{
			
		}
}
public static void adult_D9(Database Pnrdetails,String T,String FN,String LN,String date,String NA,String DT,String IC,String DN,String expdate) throws Exception {
	if (T.equals("MASTER.")) {
	    T = "Master";
	} else if (T.equals("MISS.")) {
	    T = "Miss";
	} else {
	    // No action needed for other cases
	}
	if (DT.equals("National ID number")) {
	    DT = "National ID";
	} else {
	   
	}
	try {
		flyadealPage.select_country9().click();
		flyadealPage.select_country_saudi().click();
		}
		catch(Exception e) {
			
		}
	flyadealPage.drp_title_Reuse9().click();
	flyadealPage.select_Title(T);
	flyadealPage.firstname_9().sendKeys(FN);
	flyadealPage.lastname_9().sendKeys(LN);
	flyadealPage.date_click9().click();
	String[] Dh=date.split("-");
	 String d=Dh[0];
	 String m=Dh[1];
	 String y=Dh[2];
	flyadealPage.selectYear(y);
	Thread.sleep(1000);
	flyadealPage.selectMonth(m);
	Thread.sleep(1000);
	flyadealPage.selectDate(d);
	Thread.sleep(1000);
	flyadealPage.drp_nationality9().sendKeys(NA);
	flyadealPage.select_Title(NA);
	try {
		flyadealPage.drp_docType9().sendKeys(DT);
		flyadealPage.select_Title(DT);
		flyadealPage.drp_issuing_cou9().sendKeys(IC);
		flyadealPage.select_Title(IC);
		flyadealPage.enter_doc_number9().sendKeys(DN);
		if(!DT.equals("National ID"))
		{
			flyadealPage.drp_expDate_click9().click();
			String[] ep=expdate.split("-");
			 String ed=ep[0];
			 String em=ep[1];
			 String ey=ep[2];
			flyadealPage.selectYear(ey);
			Thread.sleep(1000);
			flyadealPage.selectMonth(em);
			Thread.sleep(1000);
			flyadealPage.selectDate(ed);
			Thread.sleep(1000);
		}
		}
		catch(Exception e)
		{
			
		}
}

public static void enetCardApi(Database pnrDetails) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain",  pnrDetails.Domain);
	requestParams.put("PnrId",  pnrDetails.PnrId);
	requestParams.put("ProcessId",  ProcessIdValue);
	requestParams.put("Amount",  flyaDealModule.WEBAMOUNT);
	request.body(requestParams.toJSONString());
	Response response = request.post("/GetEnettCard");
	//System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	//System.out.println("Out Side Loop:"+s);
	
	if("Invalid".equals(s.replace("\"", "")))
	{
		//System.out.println("In Side Loop:"+s);
		if(BrowserContants.ENV.equals("PRD"))
		{
			RestAssured.baseURI =BrowserContants.PRD_API_URL;
		}
		else if(BrowserContants.ENV.equals("STG"))
		{
			RestAssured.baseURI =BrowserContants.STG_API_URL;
		}
		//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
		RequestSpecification request1 = RestAssured.given();
		request1.header("Content-Type", "text/json");
		JSONObject requestParams1 = new JSONObject();
		requestParams1.put("Domain",  pnrDetails.Domain);
		requestParams1.put("PnrId",  pnrDetails.PnrId);
		requestParams1.put("ProcessId",  ProcessIdValue);
		requestParams1.put("Amount",  flyaDealModule.WebSiteAmount);
		request1.body(requestParams1.toJSONString());
		Response response1 = request1.post("/GetEnettCard");
		System.out.println("Response body: " + response1.body().asString());
		String s1=response1.body().asString();
	}
	
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
	Gson g = new Gson();
	
	 CardDetails card = g.fromJson(s, CardDetails.class);
	
	//System.out.println(card.VirtualAccountNumber); 
			
	 cardNumber=card.VirtualAccountNumber;
	 expiryMonth=card.ExpiryMonthF3;
	 expiryYear=card.ExpiryYear;
	 CVV=card.CardSecurityCode;
	 transactionID=card.VNettTransactionID;
	 currencyCode= card.CurrencyCode;
	 VCNType= card.IntegratorReference;
	 Cvv=card.Cardsecuritycode;

	}

public static void randomCountry() {
	Nationality_I = PageUtils.getCountry();
	
}

public static void randomMail() {
	email_Random = PageUtils.MailRandom();
	
}

public static void returnStatus(Database pnrDetails,String PnrID,String WebSiteAmount) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain",  pnrDetails.Domain);
	requestParams.put("PnrId",  pnrDetails.PnrId);
	requestParams.put("ProcessId",  ProcessIdValue);
	requestParams.put("Status",  "1");
	requestParams.put("Remarks",  PnrID);
	requestParams.put("WebSiteTotalBookingAmount",  WebSiteAmount);
	request.body(requestParams.toJSONString());
	System.out.println("Before Response body:"+requestParams.toJSONString());
	Thread.sleep(2000);
	Response response = request.post("/UpdatePnrStatus");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
}


public static void returnStatus_fail(String domain,String pnrId,String remarks) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain", domain);
	requestParams.put("PnrId",  pnrId);
	requestParams.put("ProcessId",  ProcessIdValue);
	requestParams.put("Status",  "0");
	requestParams.put("Remarks",  remarks);
	request.body(requestParams.toJSONString());
	Response response = request.post("/UpdatePnrStatus");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
}

public static void readPnrId(Database pnrDetails) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain",  pnrDetails.Domain);
	requestParams.put("PnrId",  pnrDetails.PnrId);
	requestParams.put("ProcessId",  ProcessIdValue);
	request.body(requestParams.toJSONString());
	Response response = request.post("/SetPnrReadStatus");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
	
}

public static void generateMail(Database pnrDetails) throws Exception
{
	
	String BookingStatus = flyadealPage.PNR_Confirm_Text(pnrDetails).getText();
	String BookingReference = BookingStatus.split(" ")[0];
	if ("Your".equals(BookingReference)) {
	  System.out.println("Mail Sending:"+BookingStatus);
	  StringBuilder htmlStringBuilder=new StringBuilder();
	

	System.out.println("Started");
	HtmlEmail email = new HtmlEmail();
	
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
	System.out.println("1");
	email.setAuthenticator(new DefaultAuthenticator("gopi.cherukumalli@rehlat.com", "8886166175Gp"));
	email.setSSLOnConnect(true);
	email.setFrom("gopich3889@gmail.com");
	
	 Date mDate = new Date();
	 DateFormat date = new SimpleDateFormat("dd-MMMM-yyyy");
	 String Date=date.format(mDate);
	 System.out.println(Date);
		if (Date.equals(pnrDetails.DepartureDate)) {
			email.setSubject(
					"FlyaDeal Booking Using ENETT  " + pnrDetails.Domain + "_" + pnrDetails.PnrId);
		} else {
			email.setSubject("FlyaDeal Booking Using ENETT  " + pnrDetails.Domain + "_" + pnrDetails.PnrId);
		}
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>Dear Team,</tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>FlyaDeal transaction completed successful for BookingId <b> "+pnrDetails.PnrId+"</b>  with PNR <b> "+flyaDealModule.PnrId+"</b>  in <b> "+pnrDetails.Domain+"</b>  domain using enett card with transactionId <b>"+transactionID+"</b> </tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>API Amount     :<b> "+flyaDealModule.WebSiteAmount+"</b> </tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>UserPaidAmount :<b> "+pnrDetails.UserPaidAmount+"</b> </tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr></tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr></tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>--</tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr> Thanks & Regards  </tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr><b> Gopi Cherukumalli  </b></tr>"));
	//email.addTo("sreenivas.bodige@rehlat.com");
	email.addBcc("f3bookings@gmail.com");
	
	System.out.println("2");
	email.send();
	System.out.println("END");
}

else
{
	System.out.println("Mail not Sent Booking is not Confirmed");
}
}

public static void generateMail_AUBCC(Database pnrDetails) throws Exception
{
	
	String BookingStatus = flyadealPage.PNR_Confirm_Text(pnrDetails).getText();
    String BookingReference=BookingStatus.split(" ")[0];
    if("Booking".equals(BookingReference))
	{
	  System.out.println("Mail Sending:"+BookingStatus);
	  StringBuilder htmlStringBuilder=new StringBuilder();
	

	System.out.println("Started");
	HtmlEmail email = new HtmlEmail();
	
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
	System.out.println("1");
	email.setAuthenticator(new DefaultAuthenticator("gopi.cherukumalli@rehlat.com", "8886166175Gp"));
	email.setSSLOnConnect(true);
	email.setFrom("gopich3889@gmail.com");
	
	 Date mDate = new Date();
	 DateFormat date = new SimpleDateFormat("dd-MMMM-yyyy");
	 String Date=date.format(mDate);
	 System.out.println(Date);
		if (Date.equals(pnrDetails.DepartureDate)) {
			email.setSubject(
					"FlyaDeal Booking Using AUB Card  " + pnrDetails.Domain + "_" + pnrDetails.PnrId);
		} else {
			email.setSubject("FlyaDeal Booking Using AUB Card  " + pnrDetails.Domain + "_" + pnrDetails.PnrId);
		}
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>Dear Team,</tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>FlyaDeal transaction completed successful for BookingId <b> "+pnrDetails.PnrId+"</b>  with PNR <b> "+flyaDealModule.PnrId+"</b>  in <b> "+pnrDetails.Domain+"</b>  domain using AUB Card</b> </tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>API Amount     :<b> "+flyaDealModule.WebSiteAmount+"</b> </tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>UserPaidAmount :<b> "+pnrDetails.UserPaidAmount+"</b> </tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr></tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr></tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>--</tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr> Thanks & Regards  </tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr><b> Gopi Cherukumalli  </b></tr>"));
	//email.addTo("refundreissue@rehlat.com");
	email.addBcc("f3bookings@gmail.com");
	System.out.println("2");
	email.send();
	System.out.println("END");
}

else
{
	System.out.println("Mail not Sent Booking is not Confirmed");
}
}

}


