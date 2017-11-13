package marco.uws.projects.UWSMP3App.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import marco.uws.projects.UWSMP3App.controller.UserSessionController;
import marco.uws.projects.UWSMP3App.model.User;

@Path("/registration")
public class RegistrationEndpoint {
	
	UserSessionController userSessionController = new UserSessionController();
	
	@Path ("/user/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") long userId){
		User u = userSessionController.read(userId);
		return u;
	}
	
	@Path ("/user")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User insertUser(@HeaderParam("authorization") String registrationparams){
		String[] creds = registrationparams.split("&");
		String firstName = creds[0];
		String secondName = creds[1];
		String password = creds[2];
		User u = userSessionController.create(firstName, secondName, password);
		return u;
	}
	
	@Path ("/user/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(@PathParam("id") long userId ,User user){
		User u = userSessionController.update(user);
		return u;
	}
	
	@Path ("/user/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id") long userId){
		userSessionController.delete(userId);
	}

}
