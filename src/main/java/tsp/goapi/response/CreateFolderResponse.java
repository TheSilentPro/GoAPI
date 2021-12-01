package tsp.goapi.response;

import com.google.gson.JsonObject;

public class CreateFolderResponse implements GoResponse {

    private final String status;
    private final String id;
    private final String type;
    private final String name;
    private final String parentFolder;
    private final String createTime;
    private final String code;
    private final String childs; // TODO: check email for response on what this is (possible json array?)

    public CreateFolderResponse(JsonObject response) {
        this.status = response.get("status").toString();

        JsonObject data = response.get("data").getAsJsonObject();
        this.id = data.get("id").toString();
        this.type = data.get("type").toString();
        this.name = data.get("name").toString();
        this.parentFolder = data.get("parentFolder").toString();
        this.createTime = data.get("createTime").toString();
        this.code = data.get("code").toString();
        this.childs = data.get("childs").toString();
    }

    @Override
    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getParentFolder() {
        return parentFolder;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getCode() {
        return code;
    }

    public String getChilds() {
        return childs;
    }

}
