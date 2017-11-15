package marco.uws.projects.UWSMP3App.endpoints;

import java.util.List;
import java.util.Set;

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

import marco.uws.projects.UWSMP3App.controller.PlayListSessionController;
import marco.uws.projects.UWSMP3App.model.PlayList;
import marco.uws.projects.UWSMP3App.model.User;
import marco.uws.projects.UWSMP3App.model.Mp3;;

@Path ("/playList")
public class PlayListEndpoint {
	
	PlayListSessionController playListSessionController = new PlayListSessionController();
	
	@Path("/something")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String something (){
		return "1234blabla";
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PlayList getPlayList (@HeaderParam("authorization") String token, @PathParam("id") long id){
		PlayList playList= playListSessionController.read(id, token);
		return playList;
	}
	
	@Path("/{id}/creator")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getCreator (@HeaderParam("authorization") String token, @PathParam("id") long id){
		User creator = playListSessionController.getCreator(id, token);
		return creator;
	}
	
	@Path("/{id}/mp3s")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Mp3> getTracks (@HeaderParam("authorization") String token, @PathParam("id") long id){
		Set<Mp3> tracks = playListSessionController.getTracks(id, token);
		return tracks;
	}
	
	@Path("/{id}/vote_result")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getVoteResult (@HeaderParam("authorization") String token, @PathParam("id") long id){
		double voteResult = playListSessionController.getVoteResult(id, token);
		return Double.toString(voteResult);
	}
	
	@Path("/{UserId}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addPlayList (@HeaderParam("authorization") String token, @PathParam("UserId") long userId, PlayList playList){
		playListSessionController.create(userId, playList, token);
	}
	
	@Path("/{id}/follower/{userId}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PlayList addFollower (@HeaderParam("authorization") String token, @PathParam("userId") long userId, @PathParam("id") long playListId){
		return playListSessionController.addFollower(playListId, userId, token);
	}
	
	@Path("/{id}/mp3/{Mp3id}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PlayList addMp3 (@HeaderParam("authorization") String token, @PathParam("id") long playListid, @PathParam("Mp3id") long Mp3id){
		return playListSessionController.addMp3(playListid, Mp3id, token);
		
	}
	
	
	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PlayList udatePlayList (@HeaderParam("authorization") String token, PlayList playList){
		return playListSessionController.update(playList, token);
		
	}
	

	
	@Path("/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletePlayList (@HeaderParam("authorization") String token, @PathParam("id") long id){
		playListSessionController.delete(id, token);
	}
	

}
