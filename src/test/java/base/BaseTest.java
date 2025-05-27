package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utilities.ConfigReader;
import utilities.TokenManager;

public class BaseTest {

    protected String token;

    @BeforeClass
    public void setUp() {
        // Set Base URI from config.properties
        RestAssured.baseURI = ConfigReader.get("base.uri");

        // Generate Bearer Token
        token = TokenManager.getAccessToken();

        System.out.println("Base URI: " + RestAssured.baseURI);
        System.out.println("Token: " + token);
    }
}
