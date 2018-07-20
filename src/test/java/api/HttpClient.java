package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by user on 7/20/18.
 */
public class HttpClient {
    private static String ACCESS_TOKEN = "473a8763f23b3730aa99b5d75d83d87d6d44f443";
    private static final String BASE_URL = "https://todoist.com/api/v7/sync";
    private static final String EMAIL = "testappricodetodoist@gmail.com";

    private static final String USERNAME = "testAppricode";
    private static final String PASSWORD = "test123!@#";


    public static String createProjct() {
        Response response;
        String responseJson;
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "token=" + ACCESS_TOKEN  +
                "&sync_token=aLGJg_2qwBE_kE3j9_Gn6uoKQtvQeyjm7UEz_aVwF8KdriDxw7e_InFZK61h"  + "&resource_types=[\"projects\"]" +"&commands=[\n" +
                "        { \"type\": \"project_add\",\n" +
                "          \"temp_id\": \"24a193a7-46f7-4314-b984-27b707bd2331\",\n" +
                "          \"uuid\": \"e23db5ec-2f73-478a-a008-1cb4178d2fd1\",\n" +
                "          \"args\": { \"name\": \"Project1\" } }\n" +
                "      ]");
        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        try {
            response = client.newCall(request).execute();
            responseJson = response.body().string();
        } catch (IOException e) {
            throw new ApiException(e.getMessage());
        }
        return responseJson;
    }
}
