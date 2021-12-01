package tsp.goapi.api;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;

/**
 * Used for uploading files
 * 
 * @see Requester#uploadFile(UploadBody)
 */
public class UploadBody {

    private final File file;
    private String mediaType;
    private String token;
    private String folderId;

    private String description;
    private String password;
    private String tags;
    private String expire;

    public UploadBody(File file) {
        this.file = file;
        this.mediaType = "text/plain";
    }
    
    public UploadBody(File file, String mediaType) {
        this.file = file;
        this.mediaType = mediaType;
    }

    public UploadBody mediaType(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public UploadBody token(String token) {
        this.token = token;
        return this;
    }

    public UploadBody folderId(String folderId) {
        this.folderId = folderId;
        return this;
    }

    public UploadBody description(String description) {
        this.description = description;
        return this;
    }

    public UploadBody password(String password) {
        this.password = password;
        return this;
    }

    public UploadBody tags(String tags) {
        this.tags = tags;
        return this;
    }

    public UploadBody expire(String expire) {
        this.expire = expire;
        return this;
    }

    public RequestBody build() {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), RequestBody.create(file, MediaType.parse(mediaType)));

        if (token != null && !token.isEmpty()) {
            builder.addFormDataPart("token", token);
        }
        if (folderId != null && !folderId.isEmpty()) {
            builder.addFormDataPart("folderId", folderId);
        }
        if (description != null && !description.isEmpty()) {
            builder.addFormDataPart("description", description);
        }
        if (password != null && !password.isEmpty()) {
            builder.addFormDataPart("password", password);
        }
        if (tags != null && !tags.isEmpty()) {
            builder.addFormDataPart("tags", tags);
        }
        if (expire != null && !expire.isEmpty()) {
            builder.addFormDataPart("expire", expire);
        }

        return builder.build();
    }

}
