package tsp.goapi.response;

import com.google.gson.JsonObject;

public class UploadFileResponse implements GoResponse {

    private final String status;
    private final String downloadPage;
    private final String code;
    private final String parentFolder;
    private final String fileId;
    private final String fileName;
    private final String md5;
    private final String directLink;
    private final String info;

    public UploadFileResponse(JsonObject response) {
        this.status = response.get("status").toString();

        JsonObject data = response.get("data").getAsJsonObject();
        this.downloadPage = data.get("downloadPage").toString();
        this.code = data.get("code").toString();
        this.parentFolder = data.get("parentFolder").toString();
        this.fileId = data.get("fileId").toString();
        this.fileName = data.get("fileName").toString();
        this.md5 = data.get("md5").toString();
        this.directLink = data.get("directLink").toString();
        this.info = data.get("info").toString();
    }

    @Override
    public String getStatus() {
        return status;
    }

    public String getDownloadPage() {
        return downloadPage;
    }

    public String getCode() {
        return code;
    }

    public String getParentFolder() {
        return parentFolder;
    }

    public String getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMd5() {
        return md5;
    }

    public String getDirectLink() {
        return directLink;
    }

    public String getInfo() {
        return info;
    }

}
