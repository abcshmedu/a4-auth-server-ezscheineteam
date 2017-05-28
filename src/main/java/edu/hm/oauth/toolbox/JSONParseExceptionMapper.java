package edu.hm.oauth.toolbox;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonParseException;

import edu.hm.oauth.business.ServiceStatus;

/**
 * Maps all Exceptions occurring during json parsing to an appropriate server response.
 */
@Provider
@Singleton
public class JSONParseExceptionMapper implements ExceptionMapper<JsonParseException> {
    @Override
    public Response toResponse(JsonParseException e) {
        return Response.status(ServiceStatus.ERROR_PARSING_JSON.getStatus()).entity(ServiceStatus.ERROR_PARSING_JSON).build();
    }
}

