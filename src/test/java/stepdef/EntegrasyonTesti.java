package stepdef;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class EntegrasyonTesti {

    String endpoint = "http://generator.swagger.io/api/swagger.json";
    Response response;

    @Given("kullanıcı end-pointe GET sorgusu gönderir")
    public void kullanıcı_end_pointe_get_sorgusu_gönderir() {
        response = given().when().get(endpoint);
    }

    @Then("sorgu cevabı status kodu {int} olmalıdır")
    public void sorgu_cevabı_status_kodu_olmalıdır(Integer code) {
        response.then().statusCode(code);
    }
}
