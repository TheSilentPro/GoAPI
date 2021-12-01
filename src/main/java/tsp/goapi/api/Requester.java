package tsp.goapi.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

/**
 * Main requesting class
 *
 * @author TheSilentPro
 */
public class Requester {

    public static final String BASE_URL = "https://api.gofile.io";
    private final OkHttpClient client = new OkHttpClient();

    /**
     * Returns the best server available to receive files.
     *
     * @return JSON response
     * @throws IOException Error
     */
    public JsonObject getServer() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/getServer")
                .build();

        return JsonParser.parseString(client.newCall(request).execute().body().string()).getAsJsonObject();
    }

    /**
     * Upload one file on a specific server.
     * @see #getServer()
     *
     * @param uploadBody Body to upload
     * @return JSON response
     * @throws IOException Error
     */
    public JsonObject uploadFile(UploadBody uploadBody) throws IOException {
        JsonObject jsonServer = getServer();
        String server = jsonServer.get("data").getAsJsonObject().get("server").toString();

        RequestBody requestBody = uploadBody.build();

        Request request = new Request.Builder()
                .url("https://" + server.replace("\"", "") + ".gofile.io/uploadFile")
                .post(requestBody)
                .build();

        return JsonParser.parseString(client.newCall(request).execute().body().string()).getAsJsonObject();
    }

    /**
     * Create a new folder
     *
     * @param token The account token
     * @param folderName The name of the new folder
     * @param parentFolderId The id of the parent folder
     * @return JSON response
     * @throws IOException Error
     */
    public JsonObject createFolder(String token, String folderName, String parentFolderId) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("token", token)
                .add("folderName", folderName)
                .add("parentFolderId", parentFolderId)
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/createFolder")
                .put(requestBody)
                .build();

        return JsonParser.parseString(client.newCall(request).execute().body().string()).getAsJsonObject();
    }

    /**
     * Set an option on a folder
     *
     * @param token The account token
     * @param folderId The folder id
     * @param option Can be "public", "password", "description", "expire" or "tags".
     * @param value The value of the option to be defined.
     * For "public", can be "true" or "false".
     * For "password", must be the password.
     * For "description", must be the description.
     * For "expire", must be the expiration date in the form of unix timestamp.
     * For "tags", must be a comma seperated list of tags.
     * @return JSON response
     */
    public JsonObject setFolderOption(String token, String folderId, String option, String value) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("token", token)
                .add("folderId", folderId)
                .add("option", option)
                .add("value", value)
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/setFolderOption")
                .put(requestBody)
                .build();

        return JsonParser.parseString(client.newCall(request).execute().body().string()).getAsJsonObject();
    }

    /**
     * Delete one or multiple files/folders
     *
     * @param token The account token
     * @param contentsId Comma separated contentId to delete (files or folders)
     * @return JSON response
     * @throws IOException Error
     */
    public JsonObject deleteContent(String token, String contentsId) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("token", token)
                .add("contentsId", contentsId)
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/deleteContent")
                .delete(requestBody)
                .build();

        return JsonParser.parseString(client.newCall(request).execute().body().string()).getAsJsonObject();
    }

    /**
     * Retrieve specific account information
     *
     * @param token The account token
     * @param detailed If the result should be detailed
     * @return JSON response
     * @throws IOException Error
     */
    public JsonObject getAccountDetails(String token, boolean detailed) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/getAccountDetails?token=" + token + "&allDetails=" + detailed)
                .build();

        return JsonParser.parseString(client.newCall(request).execute().body().string()).getAsJsonObject();
    }

}
