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
    private static final String USERNAME = "testappricodetodoist.com";
    private static final String PASSWORD = "test123!@#";


    public static String createProjct() {
        Response response;
        String responseJson;
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "token=" + ACCESS_TOKEN  +
                "&sync_token=aLGJg_2qwBE_kE3j9_Gn6uoKQtvQeyjm7UEz_aVwF8KdriDxw7e_InFZK61h"  + "&type=normal");
        Request request = new Request.Builder()
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
