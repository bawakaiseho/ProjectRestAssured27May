package apiTestCases;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import utilities.ExcelDataProvider;
import utilities.ExtentListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import apiPayloads.PayloadProvider;
import base.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Listeners(ExtentListener.class)
public class CaseManagementApiTest extends BaseTest {

    @Test(priority = 1, dataProvider = "AllColumnDataProviderObject[]", dataProviderClass = ExcelDataProvider.class)
    public void createBillingCase(String title) {
        String jsonBody = PayloadProvider.getFormDataPayload(title);

        Response response = given()
            .header("accept", "application/json, text/plain, */*")
            .header("authorization", "Bearer " + token)
            .header("client-code", "8892df07-6d62-4ec4-9596-8f48574908ff")
            .header("content-type", "application/json")
            .body(jsonBody)
            .post("/apim/fb/1.0/rest/GeneralEntity/saveFormData");

        System.out.println("FIRST INPUT JSON=  " + jsonBody);
        System.out.println("Title Used: " + title);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        //ExtentListener.test.log(Status.INFO, "successfully created billing case");

        try {
            response.then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("statusCode", equalTo(200))
                .body("message", equalTo("Data saved successfully"));

            // Only logs if assertions above pass
            ExtentListener.test.log(Status.INFO, "Successfully created billing case");
        } catch (AssertionError e) {
            // Optional: Log failure info here if you want
            ExtentListener.test.log(Status.FAIL, "Assertion failed: " + e.getMessage());
            throw e; // Rethrow so the test still fails
        }
    }

    // @Test(priority = 2, dataProvider = "AllColumnDataProviderString[]", dataProviderClass = ExcelDataProvider.class)
    public void testSaveFormDataApi2(String title) {
        RestAssured.baseURI = "https://dev.visionwaves.com";

        String jsonBody = PayloadProvider.getFormDataPayload(title);

        Response response = given()
            .header("accept", "application/json, text/plain, */*")
            .header("authorization", "Bearer " + token)
            .header("client-code", "8892df07-6d62-4ec4-9596-8f48574908ff")
            .header("content-type", "application/json")
            .body(jsonBody)
            .post("/apim/fb/1.0/rest/GeneralEntity/saveFormData");

        System.out.println("FIRST INPUT JSON=  " + jsonBody);
        System.out.println("Title Used: " + title);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        response.then()
            .statusCode(200)
            .body("status", equalTo("success"))
            .body("statusCode", equalTo(200))
            .body("message", equalTo("Data saved successfully"));
    }

    // @Test(priority = 3, dataProvider = "AllRowDataProviderString[]", dataProviderClass = ExcelDataProvider.class)
    public void testCreateBillingCase1(String title) {
        RestAssured.baseURI = "https://dev.visionwaves.com";

        String jsonBody = PayloadProvider.getFormDataPayload(title);

        Response response = given()
            .header("accept", "application/json, text/plain, */*")
            .header("authorization", "Bearer " + token)
            .header("client-code", "8892df07-6d62-4ec4-9596-8f48574908ff")
            .header("content-type", "application/json")
            .body(jsonBody)
            .post("/apim/fb/1.0/rest/GeneralEntity/saveFormData");

        System.out.println("FIRST INPUT JSON=  " + jsonBody);
        System.out.println("Title Used: " + title);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        response.then()
            .statusCode(200)
            .body("status", equalTo("success"))
            .body("statusCode", equalTo(200))
            .body("message", equalTo("Data saved successfully"));
    }
}
