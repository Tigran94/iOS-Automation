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

}
