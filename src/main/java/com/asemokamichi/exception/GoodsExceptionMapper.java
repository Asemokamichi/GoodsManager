package com.asemokamichi.exception;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GoodsExceptionMapper implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("An error occurred: " + exception.getMessage())
                .build();
    }
}
