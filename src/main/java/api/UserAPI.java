package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserAPI {

    public final static String REGISTER_USER_ENDPOINT = "api/auth/register";
    public final static String AUTH_USER_ENDPOINT = "api/auth/login";
    public final static String DATA_USER_ENDPOINT = "api/auth/user";
    public final static String LOGOUT_USER_ENDPOINT = "/api/auth/logout";

    public Response registerUser(RegisterUserPOJO registerUserPOJO){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(registerUserPOJO)
                .when()
                .post(REGISTER_USER_ENDPOINT);
    }

    public Response loginUser(LoginUserPOJO loginUserPOJO){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(loginUserPOJO)
                .when()
                .post(AUTH_USER_ENDPOINT);
    }

    public void deleteUser(String accessToken){
        given()
                .header("Authorization", accessToken)
                .header("Content-type", "application/json")
                .delete(DATA_USER_ENDPOINT);
    }

    public Response logout(String accessToken){
       return given()
                .header("Authorization", accessToken)
                .header("Content-type", "application/json")
                .post(LOGOUT_USER_ENDPOINT);
    }
}
