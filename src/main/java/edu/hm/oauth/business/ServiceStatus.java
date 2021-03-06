package edu.hm.oauth.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.Response;

/**
 * A class for describing the results/errors of the RestAPI calls.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ServiceStatus {
    OK(Response.Status.OK, "Tutto bene."), TOKEN_NOT_FOUND(Response.Status.NOT_FOUND, "Token was not found."), 
    TOKEN_TIMEOUT(Response.Status.GONE, "Token is no longer valid."), 
    USER_NOT_FOUND(Response.Status.NOT_FOUND, "User with this name was not found."), 
    USER_INVALID_CREDENTIALS(Response.Status.UNAUTHORIZED, "Supplied user credentials incorrect."),
    ERROR_PARSING_JSON(Response.Status.BAD_REQUEST, "Das JSON-Objekt konnte nicht gelesen werden."), 
    USER_ALREADY_EXISTS(Response.Status.CONFLICT, "User mit diesem Namen existiert schon."),
    USER_INVALID_EMAIL(Response.Status.BAD_REQUEST, "Die angegebene E-Mail Adresse ist nicht korrekt strukturiert.");

    /**
     * Returns the status of an operation.
     * 
     * @param status
     *            the status of an operation.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Returns more meta data to the status of an operation.
     * 
     * @param detail
     *            - More meta data to the status of an operation.
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    private int status;
    private String detail;

    /**
     * Creates an object containing the results of a ServiceResult operation.
     *
     * @param status
     *            contains the http status code of the operation.
     * @param detail
     *            contains more details about the operation.
     */
    ServiceStatus(@JsonProperty("status") Response.Status status, @JsonProperty("detail") String detail) {
        this.status = status.getStatusCode();
        this.detail = detail;
    }

    /**
     * The HTTP-status code of the operation.
     *
     * @return HTTP-status code of the operation
     */
    @JsonProperty("status")
    public int getStatus() {
        return status;
    }

    /**
     * More details about the result/errors occurred during execution.
     *
     * @return A string containing more information about the operations
     *         results.
     */
    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

}
