package tsp.goapi.response;

import com.google.gson.JsonObject;

public class FolderOptionResponse implements GoResponse {

    private final String status;

    public FolderOptionResponse(JsonObject response) {
        this.status = response.get("status").toString();
        // Seems like this endpoint has no data returned except for status
    }

    @Override
    public String getStatus() {
        return status;
    }

}
