package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenManager {

    private static String accessToken;

    public static String getAccessToken() {
        if (accessToken == null) {
            generateToken();
        }
        return accessToken;
    }

    private static void generateToken() {
        RestAssured.baseURI = "https://dev.visionwaves.com";

        Response response = RestAssured.given()
            .header("Accept", "application/json")
            .header("Content-Type", "application/x-www-form-urlencoded")
            .formParam("grant_type", "password")
            .formParam("username", "narayan.patel")
            .formParam("password", "Root@123")
            .formParam("client_id", "bootnext")
            .post("/auth/realms/BNTV/protocol/openid-connect/token");

        if (response.statusCode() == 200) {
            accessToken = response.jsonPath().getString("access_token");
        } else {
            throw new RuntimeException("Failed to fetch access token: " + response.asString());
        }
    }

    public static void refreshAccessToken() {
        accessToken = null;
        generateToken();
    }
}
