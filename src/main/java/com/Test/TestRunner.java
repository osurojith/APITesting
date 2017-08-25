package com.Test;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestRunner {
	@DataProvider(name="seasonsAndNumberOfRaces")
	public Object[][] createTestDataRecords() {
	    return new Object[][] {
	        {"2017",20},
	        {"2016",21},
	        {"1966",9}
	    };
	}
	@Test(dataProvider="seasonsAndNumberOfRaces")
	public void test_NumberOfCircuits_ShouldBe_DataDriven(String season, int numberOfRaces) {
	                
	    given().
	        pathParam("raceSeason",season).
	    when().
	        get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
	}
	
	/*@Test
	public void checkIP1() {
	        
	    String IP = "albert_park";
	   
	    given().
	       // pathParam("raceSeason",season).
	    when().
	        get("http://ergast.com/api/f1/2017/circuits.json").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId[0]",equalTo(IP));
	}
	 @Test
		public void postExample()
		{
		String myJson = "{\"name\":\"Jimi Hendrix\"}";
	    	RestAssured.baseURI  = "http://ec2-52-212-72-231.eu-west-1.compute.amazonaws.com:9091/Kraydel-server/rest/login";	

	    	Response r = given()
	    	.contentType("application/json").
	    	body("{\"username\":\"nikom@gmail.com\",\"password\":\"test@12\" }").
	        when().
	        post("");

	    	String body = r.getBody().asString();
	    	System.out.println(body);
	    	JsonPath jsonPath = new JsonPath(body);
	    	String zzz = jsonPath.getString("status");
	    	System.out.println("xxxxxx"+zzz);
	    	Assert.assertEquals(zzz,"successfull");
		}
	 
	 @Test
		public void checkIP() {
		        
		    String IP = "albert_park";
		   
		    given().
		       // pathParam("raceSeason",season).
		    when().
		        get("http://ergast.com/api/f1/2017/circuits.json").
		    then().
		        assertThat().
		        body("MRData.CircuitTable.Circuits.circuitId[0]",equalTo(IP));
		   
		    }
	*/
}
