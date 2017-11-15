package marco.uws.projects.UWSMP3App.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import marco.uws.projects.UWSMP3App.model.ErrorMessage;

@Provider
public class NotAuthorizedExceptionMapper implements ExceptionMapper<NotAuthorizedException> {

	@Override
	public Response toResponse(NotAuthorizedException exception) {
		ErrorMessage error = new ErrorMessage();
		error.setDocumentation("Here could be a link to the documentation");
		error.setErrorCode(401);
		error.setErrorMessage(exception.getMessage());
		
		return Response.status(Status.UNAUTHORIZED).entity(error).type(MediaType.APPLICATION_JSON).build();
	}
	
	

}
