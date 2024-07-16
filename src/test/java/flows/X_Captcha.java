package flows;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import FlyModules.BrowserContants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageObjects.Pax;

import org.json.simple.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List; 

public class X_Captcha {

    public static void main(String[] args) throws InterruptedException {
    	RestAssured.baseURI =BrowserContants.PRD_API_URL;
        RequestSpecification request1 = RestAssured.given();
        JSONObject requestParams1 = new JSONObject();
        request1.header("Content-Type", "application/json");

        requestParams1.put("Domain", "SA");
        requestParams1.put("PnrId", "4901933 ");
        requestParams1.put("ProcessId", "-1");

        request1.body(requestParams1.toJSONString());
        System.out.println("Before Response:" + requestParams1.toJSONString());
        Thread.sleep(2000);
        Response response1 = request1.post("/GetPaxDetailsForScraping");
        System.out.println("Response body: " + response1.body().asString());
       // String response_pax = response1.body().asString();
        String response_pax = "[ { \"PaxType\": \"ADULT\", \"Title\": \"Mr.\", \"TitleF3\": \"MR.\", \"FirstName\": \"ABDULWAHAB HUSSAIN\", \"FirstNameF3\": \"ABDULWAHABHUSSAIN\", \"LastName\": \"ALAWAJI\", \"LastNameF3\": \"ALAWAJI\", \"Gender\": \"M\", \"PhoneNumber\": \"543143040\", \"Email\": \"thedoctor2016@hotmail.com\", \"CountryCode_Nationality\": \"SA\", \"Nationality\": \"Saudi Arabia\", \"CountryCode_Issuing\": \"SA\", \"IssuingCountryName\": \"Saudi Arabia\", \"CountryName\": \"Saudi Arabia\", \"MobileCode\": \"+966\", \"MobileCountry\": \"Saudi Arabia (+966)\", \"DocumentNumber\": \"1069003760\", \"DocumentType\": \"National ID\", \"DocumentTypeF3\": \"National ID number\", \"DocumentTypeFlyadeal\": \"National ID Number\", \"DOB\": \"1990-12-29T00:00:00\", \"DobStr\": \"29-December-1990\", \"DobStrF3\": \"29-12-1990\", \"DobStrFlyadeal\": \"29-Dec-1990\", \"PassportExpiryDate\": \"2029-09-15T00:00:00\", \"PassportExpiryDateStr\": \"15-September-2029\", \"PassportExpiryDateStrF3\": \"15-9-2029\", \"PassportExpiryDateStrFlyadeal\": \"15-Sep-2029\", \"FromCity\": \"Jeddah\", \"PassportIssueDate\": \"0001-01-01T00:00:00\", \"PassportIssueDateStr\": \"01-January-0001\", \"Ob_ABaggage\": null, \"Ob_ABaggageAmt\": \"0.000\", \"Ib_ABaggage\": null, \"Ib_ABaggageAmt\": \"0.000\", \"DOBH\": \"11-Jumadal Thani-1411\", \"DOBEXPH\": \"6-Jumadal Awwal-1451\", \"IsHijriDate\": \"YES\", \"FareType\": \"fly\", \"ObAdBagCount\": \"0\", \"IbAdBagCount\": \"0\", \"Flyplusbag\": \"NO\" }, { \"PaxType\": \"ADULT\", \"Title\": \"Mr.\", \"TitleF3\": \"MR.\", \"FirstName\": \"HAMEED HUSSAIN\", \"FirstNameF3\": \"HAMEEDHUSSAIN\", \"LastName\": \"ALAWAJI\", \"LastNameF3\": \"ALAWAJI\", \"Gender\": \"M\", \"PhoneNumber\": \"543143040\", \"Email\": \"thedoctor2016@hotmail.com\", \"CountryCode_Nationality\": \"SA\", \"Nationality\": \"Saudi Arabia\", \"CountryCode_Issuing\": \"SA\", \"IssuingCountryName\": \"Saudi Arabia\", \"CountryName\": \"Saudi Arabia\", \"MobileCode\": \"+966\", \"MobileCountry\": \"Saudi Arabia (+966)\", \"DocumentNumber\": \"1069003760\", \"DocumentType\": \"National ID\", \"DocumentTypeF3\": \"National ID number\", \"DocumentTypeFlyadeal\": \"National ID Number\", \"DOB\": \"1990-12-29T00:00:00\", \"DobStr\": \"29-December-1990\", \"DobStrF3\": \"29-12-1990\", \"DobStrFlyadeal\": \"29-Dec-1990\", \"PassportExpiryDate\": \"2029-09-15T00:00:00\", \"PassportExpiryDateStr\": \"15-September-2029\", \"PassportExpiryDateStrF3\": \"15-9-2029\", \"PassportExpiryDateStrFlyadeal\": \"15-Sep-2029\", \"FromCity\": \"Jeddah\", \"PassportIssueDate\": \"0001-01-01T00:00:00\", \"PassportIssueDateStr\": \"01-January-0001\", \"Ob_ABaggage\": null, \"Ob_ABaggageAmt\": \"0.000\", \"Ib_ABaggage\": null, \"Ib_ABaggageAmt\": \"0.000\", \"DOBH\": \"11-Jumadal Thani-1411\", \"DOBEXPH\": \"6-Jumadal Awwal-1451\", \"IsHijriDate\": \"YES\", \"FareType\": \"fly\", \"ObAdBagCount\": \"0\", \"IbAdBagCount\": \"0\", \"Flyplusbag\": \"NO\" }, { \"PaxType\": \"CHILD\", \"Title\": \"Mr.\", \"TitleF3\": \"MR.\", \"FirstName\": \"SULTAN JAMEEL\", \"FirstNameF3\": \"SULTANJAMEEL\", \"LastName\": \"MAHROUS\", \"LastNameF3\": \"MAHROUS\", \"Gender\": \"M\", \"PhoneNumber\": null, \"Email\": null, \"CountryCode_Nationality\": \"SA\", \"Nationality\": \"Saudi Arabia\", \"CountryCode_Issuing\": \"SA\", \"IssuingCountryName\": \"Saudi Arabia\", \"CountryName\": null, \"MobileCode\": \"\", \"MobileCountry\": null, \"DocumentNumber\": \"1079875785\", \"DocumentType\": \"National ID\", \"DocumentTypeF3\": \"National ID number\", \"DocumentTypeFlyadeal\": \"National ID Number\", \"DOB\": \"2015-05-05T00:00:00\", \"DobStr\": \"05-May-1992\", \"DobStrF3\": \"5-5-2015\", \"DobStrFlyadeal\": \"5-May-2015\", \"PassportExpiryDate\": \"2030-06-08T00:00:00\", \"PassportExpiryDateStr\": \"08-June-2030\", \"PassportExpiryDateStrF3\": \"8-6-2030\", \"PassportExpiryDateStrFlyadeal\": \"8-Jun-2030\", \"FromCity\": \"Jeddah\", \"PassportIssueDate\": \"0001-01-01T00:00:00\", \"PassportIssueDateStr\": \"01-January-0001\", \"Ob_ABaggage\": null, \"Ob_ABaggageAmt\": \"0.000\", \"Ib_ABaggage\": null, \"Ib_ABaggageAmt\": \"0.000\", \"DOBH\": null, \"DOBEXPH\": null, \"IsHijriDate\": \"NO\", \"FareType\": \"fly\", \"ObAdBagCount\": \"0\", \"IbAdBagCount\": \"0\", \"Flyplusbag\": \"NO\" }, { \"PaxType\": \"INFANT\", \"Title\": \"Master\", \"TitleF3\": \"MASTER.\", \"FirstName\": \"ABDULWAHAN HUSSAIN\", \"FirstNameF3\": \"ABDULWAHANHUSSAIN\", \"LastName\": \"ALAWAJI\", \"LastNameF3\": \"ALAWAJI\", \"Gender\": \"M\", \"PhoneNumber\": null, \"Email\": null, \"CountryCode_Nationality\": \"SA\", \"Nationality\": \"Saudi Arabia\", \"CountryCode_Issuing\": \"SA\", \"IssuingCountryName\": \"Saudi Arabia\", \"CountryName\": null, \"MobileCode\": null, \"MobileCountry\": null, \"DocumentNumber\": \"1069003760\", \"DocumentType\": \"National ID\", \"DocumentTypeF3\": \"National ID number\", \"DocumentTypeFlyadeal\": \"National ID Number\", \"DOB\": \"2021-12-11T00:00:00\", \"DobStr\": \"11-December-2021\", \"DobStrF3\": \"11-12-2021\", \"DobStrFlyadeal\": \"11-Dec-2021\", \"PassportExpiryDate\": \"2030-04-01T00:00:00\", \"PassportExpiryDateStr\": \"01-April-2030\", \"PassportExpiryDateStrF3\": \"1-4-2030\", \"PassportExpiryDateStrFlyadeal\": \"1-Apr-2030\", \"FromCity\": \"Jeddah\", \"PassportIssueDate\": \"0001-01-01T00:00:00\", \"PassportIssueDateStr\": \"01-January-0001\", \"Ob_ABaggage\": null, \"Ob_ABaggageAmt\": \"0.000\", \"Ib_ABaggage\": null, \"Ib_ABaggageAmt\": \"0.000\", \"DOBH\": null, \"DOBEXPH\": null, \"IsHijriDate\": \"NO\", \"FareType\": \"fly\", \"ObAdBagCount\": \"0\", \"IbAdBagCount\": \"0\", \"Flyplusbag\": \"NO\" }, { \"PaxType\": \"INFANT\", \"Title\": \"Master\", \"TitleF3\": \"MASTER.\", \"FirstName\": \"ABDULWAHAN HAMEDD\", \"FirstNameF3\": \"ABDULWAHANHAMEDD\", \"LastName\": \"ALAWAJI\", \"LastNameF3\": \"ALAWAJI\", \"Gender\": \"M\", \"PhoneNumber\": null, \"Email\": null, \"CountryCode_Nationality\": \"SA\", \"Nationality\": \"Saudi Arabia\", \"CountryCode_Issuing\": \"SA\", \"IssuingCountryName\": \"Saudi Arabia\", \"CountryName\": null, \"MobileCode\": null, \"MobileCountry\": null, \"DocumentNumber\": \"1069003760\", \"DocumentType\": \"National ID\", \"DocumentTypeF3\": \"National ID number\", \"DocumentTypeFlyadeal\": \"National ID Number\", \"DOB\": \"2021-12-11T00:00:00\", \"DobStr\": \"11-December-2021\", \"DobStrF3\": \"11-12-2021\", \"DobStrFlyadeal\": \"11-Dec-2021\", \"PassportExpiryDate\": \"2030-04-01T00:00:00\", \"PassportExpiryDateStr\": \"01-April-2030\", \"PassportExpiryDateStrF3\": \"1-4-2030\", \"PassportExpiryDateStrFlyadeal\": \"1-Apr-2030\", \"FromCity\": \"Jeddah\", \"PassportIssueDate\": \"0001-01-01T00:00:00\", \"PassportIssueDateStr\": \"01-January-0001\", \"Ob_ABaggage\": null, \"Ob_ABaggageAmt\": \"0.000\", \"Ib_ABaggage\": null, \"Ib_ABaggageAmt\": \"0.000\", \"DOBH\": null, \"DOBEXPH\": null, \"IsHijriDate\": \"NO\", \"FareType\": \"fly\", \"ObAdBagCount\": \"0\", \"IbAdBagCount\": \"0\", \"Flyplusbag\": \"NO\"}]";

        int statusCode = response1.getStatusCode();
        System.out.println("The status code received: " + statusCode);

        Gson gson = new Gson();
        Type type = new TypeToken<List<Pax>>() {}.getType();
        List<Pax> paxList = gson.fromJson(response_pax, type);

        // Separate adults, infants, and children
        List<Pax> adults = new ArrayList<>();
        List<Pax> infants = new ArrayList<>();
        List<Pax> children = new ArrayList<>();

        for (Pax pax : paxList) {
            if ("ADULT".equals(pax.PaxType)) {
                adults.add(pax);
            } else if ("INFANT".equals(pax.PaxType)) {
                infants.add(pax);
            } else if ("CHILD".equals(pax.PaxType)) {
                children.add(pax);
            }
        }
       
        // Arrange adults, infants, and children based on counts
        List<Pax> arrangedPassengers = arrangePassengers(adults, infants, children);

        // Print or use the arranged passenger list as needed
        for (Pax passenger : arrangedPassengers) {
            System.out.println(passenger.FirstName);
            
        }
    }

    private static List<Pax> arrangePassengers(List<Pax> adults, List<Pax> infants, List<Pax> children) {
        List<Pax> arrangedPassengers = new ArrayList<>();
        
        
        int minCount = Math.min(2, 2);
        System.out.println("adults:-"+adults);
        for (int i = 0; i < minCount; i++) {
            arrangedPassengers.add(adults.get(i));
            arrangedPassengers.add(infants.get(i));
        }

       
        arrangedPassengers.addAll(adults.subList(minCount, adults.size()));
        arrangedPassengers.addAll(infants.subList(minCount, infants.size()));

        // Add children at the end
        arrangedPassengers.addAll(children);

        return arrangedPassengers;
    }

   
}
