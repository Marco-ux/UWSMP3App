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

import marco.uws.projects.UWSMP3App.controller.MP3Controller;
import marco.uws.projects.UWSMP3App.controller.MP3SessionController;
import marco.uws.projects.UWSMP3App.model.Mp3;
import marco.uws.projects.UWSMP3App.model.PlayList;


@Path("/mp3")
public class MP3Endpoint {
	
	MP3SessionController mp3controller = new MP3SessionController();
	
	@Path("/something")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String something (){
		return "1234blabla";
	}
	
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addMp3 (Mp3 mp3){
		mp3controller.createMP3(mp3);
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Mp3 getMP3(@PathParam("id") long id){
		Mp3 b= mp3controller.read(id);
		return b ;
	}
	
	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Mp3 udateMp3 (Mp3 mp3){
		return mp3controller.update(mp3);
		
	}
	
	@Path("/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMp3 (@PathParam("id") long id){
		mp3controller.delete(id);
	}
	
	public static void main(String[] args) {
    	
		Mp3 mp3 = new Mp3();
    	mp3.setTitle("hallo");
    	mp3.setId(0);
    	
    	PlayList play = new PlayList();
    	play.setTitle("frech");
    	
    	//MP3Controller.saveObject(play);
    	
    	
    	
    	play= (PlayList) MP3Controller.getObject(new PlayList(), 0);
    	mp3.getPlayListsInvolved().remove(play);
    	//play.setTitle("Faaaaaancy");
		
    	MP3Controller.saveObject(mp3);
    	
    	play= (PlayList) MP3Controller.getObject(new PlayList(), 0);
    	
    	MP3Controller.deleteObject(play);
        
        
    }
	

}
