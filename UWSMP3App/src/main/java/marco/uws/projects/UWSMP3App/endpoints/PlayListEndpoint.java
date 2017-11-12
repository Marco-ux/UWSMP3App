package marco.uws.projects.UWSMP3App.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import marco.uws.projects.UWSMP3App.controller.PlayListSessionController;
import marco.uws.projects.UWSMP3App.model.PlayList;

@Path ("/playList")
public class PlayListEndpoint {
	
	PlayListSessionController playListSessionController = new PlayListSessionController();
	
	@Path("/something")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String something (){
		return "1234blabla";
	}
	
	@Path("/{UserId}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addPlayList (@PathParam("UserId") long userId, PlayList playList){
		playListSessionController.create(userId, playList);
	}
	
	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PlayList udatePlayList (PlayList playList){
		return playListSessionController.update(playList);
		
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PlayList getPlayList (@PathParam("id") long id){
		PlayList playList= playListSessionController.read(id);
		return playList;
	}
	
	@Path("/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletePlayList (@PathParam("id") long id){
		playListSessionController.delete(id);
	}
	

}
