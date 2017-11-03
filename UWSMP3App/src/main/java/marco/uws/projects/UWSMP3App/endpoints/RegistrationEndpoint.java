package marco.uws.projects.UWSMP3App.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import marco.uws.projects.UWSMP3App.model.User;

@Path("/registration")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistrationEndpoint {
	
	@Path ("/user")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertUser(@HeaderParam("authorization") String registrationparams){
		String[] creds = registrationparams.split("&");
		String username = creds[0];
		String usernameDoc = creds[1];
		String password = creds[2];
		//User u = //registrationservice.insertPatient(usernamePat, usernameDoc, password);
		
		return null;
	}

}
