package tsp.goapi.response;

import com.google.gson.JsonObject;

public class GetServerResponse implements GoResponse {

    private final String status;
    private final String server;

    public GetServerResponse(JsonObject response) {
        this.status = response.get("status").toString();
        this.server = response.get("data").getAsJsonObject().get("server").toString();
    }

    @Override
    public String getStatus() {
        return status;
    }

    public String getServer() {
        return server;
    }
}
