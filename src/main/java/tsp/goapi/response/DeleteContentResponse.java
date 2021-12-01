package tsp.goapi.response;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class DeleteContentResponse implements GoResponse {

    private final String status;
    private final Map<String, String> dataSet = new HashMap<>();

    public DeleteContentResponse(JsonObject response) {
        this.status = response.get("status").toString();

        JsonObject data = response.get("data").getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : data.entrySet()) {
            dataSet.put(entry.getKey(), entry.getValue().toString());
        }
    }

    @Override
    public String getStatus() {
        return status;
    }

    /**
     * Returns the data set of the response.
     * Example response: "05f0c1ad-83ff-4ec4-a96c-4a0b044e6272":"ok"
     *
     * @return Response data set
     */
    public Map<String, String> getDataSet() {
        return dataSet;
    }

}
