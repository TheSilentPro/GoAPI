package tsp.goapi;

import tsp.goapi.api.Requester;
import tsp.goapi.api.UploadBody;
import tsp.goapi.response.AccountDetailsResponse;
import tsp.goapi.response.CreateFolderResponse;
import tsp.goapi.response.DeleteContentResponse;
import tsp.goapi.response.FolderOptionResponse;
import tsp.goapi.response.GetServerResponse;
import tsp.goapi.response.UploadFileResponse;

import java.io.IOException;

/**
 * Easy access to gofile.io API
 *
 * @author TheSilentPro
 */
public class GoAPI {

    private final String token;
    private final Requester requester = new Requester();

    public GoAPI() {
        this.token = null;
    }

    public GoAPI(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public Requester getRequester() {
        return requester;
    }

    /**
     * Returns the best server available to receive files.
     *
     * @return Response
     * @throws IOException Error
     */
    public GetServerResponse getServer() throws IOException {
        return new GetServerResponse(requester.getServer());
    }

    /**
     * Upload one file on a specific server.
     * @see #getServer()
     *
     * @param uploadBody Body to upload
     * @return Response
     * @throws IOException Error
     */
    public UploadFileResponse uploadFile(UploadBody uploadBody) throws IOException {
        if (token != null) {
            uploadBody.token(token);
        }

        return new UploadFileResponse(requester.uploadFile(uploadBody));
    }

    /**
     * Create a new folder
     *
     * @param folderName The name of the new folder
     * @param parentFolderId The id of the parent folder
     * @return Response
     * @throws IOException Error
     */
    public CreateFolderResponse createFolder(String folderName, String parentFolderId) throws IOException {
        if (token == null) {
            throw new IllegalArgumentException("Folder creation requires a token.");
        }

        return new CreateFolderResponse(requester.createFolder(token, folderName, parentFolderId));
    }

    /**
     * Set an option on a folder
     *
     * @param folderId The folder id
     * @param option Can be "public", "password", "description", "expire" or "tags".
     * @param value The value of the option to be defined.
     * For "public", can be "true" or "false".
     * For "password", must be the password.
     * For "description", must be the description.
     * For "expire", must be the expiration date in the form of unix timestamp.
     * For "tags", must be a comma seperated list of tags.
     * @return Response
     */
    public FolderOptionResponse setFolderOption(String folderId, String option, String value) throws IOException {
        if (token == null) {
            throw new IllegalArgumentException("Folder option requires a token.");
        }

        return new FolderOptionResponse(requester.setFolderOption(token, folderId, option, value));
    }

    /**
     * Delete one or multiple files/folders
     *
     * @param contentsId Comma separated contentId to delete (files or folders)
     * @return Response
     * @throws IOException Error
     */
    public DeleteContentResponse deleteContent(String contentsId) throws IOException {
        if (token == null) {
            throw new IllegalArgumentException("Content deletion requires a token.");
        }

        return new DeleteContentResponse(requester.deleteContent(token, contentsId));
    }

    /**
     * Retrieve specific account information
     *
     * @return Response
     * @throws IOException Error
     */
    public AccountDetailsResponse getAccountDetails(boolean allDetails) throws IOException {
        if (token == null) {
            throw new IllegalArgumentException("Account details require a token.");
        }

        return new AccountDetailsResponse(requester.getAccountDetails(token, allDetails));
    }

}
