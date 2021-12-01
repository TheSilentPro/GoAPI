package tsp.goapi.response;

import com.google.gson.JsonObject;

public class AccountDetailsResponse implements GoResponse {

    private final String status;
    private final String token;
    private final String email;
    private final String tier;
    private final String rootFolder;
    private final String filesCount;
    private final String filesCountLimit;
    private final String totalSize;
    private final String totalSizeLimit;
    private final String total30DDLTraffic;
    private final String total30DDLTrafficLimit;

    public AccountDetailsResponse(JsonObject response) {
        this.status = response.get("status").toString();

        JsonObject data = response.get("data").getAsJsonObject();
        this.token = data.get("token").toString();
        this.email = data.get("email").toString();
        this.tier = data.get("tier").toString();
        this.rootFolder = data.get("rootFolder").toString();
        this.filesCount = data.get("filesCount").toString();
        this.filesCountLimit = data.get("filesCountLimit").toString();
        this.totalSize = data.get("totalSize").toString();
        this.totalSizeLimit = data.get("totalSizeLimit").toString();
        this.total30DDLTraffic = data.get("total30DDLTraffic").toString();
        this.total30DDLTrafficLimit = data.get("total30DDLTrafficLimit").toString();
    }

    @Override
    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public String getTier() {
        return tier;
    }

    public String getRootFolder() {
        return rootFolder;
    }

    public String getFilesCount() {
        return filesCount;
    }

    public String getFilesCountLimit() {
        return filesCountLimit;
    }

    public String getTotalSize() {
        return totalSize;
    }

    public String getTotalSizeLimit() {
        return totalSizeLimit;
    }

    public String getTotal30DDLTraffic() {
        return total30DDLTraffic;
    }

    public String getTotal30DDLTrafficLimit() {
        return total30DDLTrafficLimit;
    }

}
