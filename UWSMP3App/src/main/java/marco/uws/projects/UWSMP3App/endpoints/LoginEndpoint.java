package marco.uws.projects.UWSMP3App.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import marco.uws.projects.UWSMP3App.controller.LoginController;


@Path("/login")
public class LoginEndpoint {
	
	LoginController loginController = new LoginController();
	
	@Path("/something")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String something (){
		return "1234blabla";
	}
	
	@GET
	public Response getLogin(@HeaderParam("authorization") String credentials) {	
		//vorausgesetzt die Credentials kommen als username&password
		String[] creds = credentials.split("&");
		String username = creds[0];
		long usernameAsLong =Long.parseLong(username);
		String password = creds[1];
		String token = loginController.getLogin(usernameAsLong, password);
		Response r = Response.status(Status.OK).header("token", token).build();
		return r;
	}

}
