package flows;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PNR {
	static String PnrId;
	static String StatusId="1";
	public static void main(String[] args) {
		
            RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "text/json");
			JSONObject requestParams = new JSONObject();
			requestParams.put("Domain",  "SA");
			requestParams.put("PnrId",  "5133168");
			requestParams.put("ProcessId",  "-1");
			requestParams.put("Status",  "1");
			requestParams.put("Remarks",  "T9MRQP");
			request.body(requestParams.toJSONString());
			Response response = request.post("/UpdatePnrStatus");
			System.out.println("Response body: " + response.body().asString());
			String s=response.body().asString();
			System.out.println(s);
			int statusCode = response.getStatusCode();
			System.out.println("The status code recieved: " + statusCode);
		
		}
	}


