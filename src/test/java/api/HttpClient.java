package api;

import okhttp3.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by user on 7/20/18.
 */
public class HttpClient {
    private static String ACCESS_TOKEN = "ce83c7853d73344ab6af0e6872fba1badfe2b6dd";
    private static final String BASE_URL = "https://todoist.com/api/v7/sync";

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

    public static boolean checkProject(String projectName){
        List<String> projects = null;
        Response response;
        String responseJson;
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "token=" + ACCESS_TOKEN  +
                "&sync_token=*"  + "&resource_types=[\"projects\"]");

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
       return responseJson.contains(projectName);
    }

    public static boolean checkTask(String taskName){
        List<String> projects = null;
        Response response;
        String responseJson;
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "token=" + ACCESS_TOKEN  +
                 "&resource_types=[\"items\"]");

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
        return responseJson.contains(taskName);
    }

    public static String uncompleteTask(){
        Response response;
        String responseJson;
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "token=" + ACCESS_TOKEN  +
                "&commands=[{\"type\": \"item_uncomplete\", \"uuid\": \"710a60e1-174a-4313-bb9f-4df01e0349fd\", \"args\": {\"ids\": [2738523160]}}]");

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
