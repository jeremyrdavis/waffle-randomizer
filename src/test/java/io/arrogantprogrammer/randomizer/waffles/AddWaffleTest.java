package io.arrogantprogrammer.randomizer.waffles;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AddWaffleTest {

    @Test
    public void testAddingWaffle() {

        String waffleJson = """
                {
                    "type" : "Belgian",
                    "toppings" : ["Whipped Cream"]
                }
                """;

        given()
                .when()
                .body(waffleJson)
                .post("/waffle")
                .then()
                .statusCode(201)
                .body(is(waffleJson));
    }
}
