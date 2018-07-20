package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.security.SecureRandom;
import java.util.HashMap;
import okhttp3.Response;

/**
 * Created by user on 7/20/18.
 */
public class ApiHelper {
    static SecureRandom rnd = new SecureRandom();
    public static JsonParser parser = new JsonParser();
    public static Gson gson = new GsonBuilder().create();

    public static JsonObject createProject() {
        HashMap projectMap = new HashMap();
        projectMap.put("is_private", false);
        projectMap.put("creation_template", 1);
        projectMap.put(	"name", "Test Project Name " + randomString(5));
        projectMap.put(	"description", "Test Project Description" + randomString(10));
        String jsonString = gson.toJson(projectMap);
        Response response = HttpClient.post("/projects", jsonString);
        return getJsonObject(response);
    }
}
