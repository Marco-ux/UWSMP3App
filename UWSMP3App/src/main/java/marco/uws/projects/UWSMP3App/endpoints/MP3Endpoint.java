package marco.uws.projects.UWSMP3App.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import marco.uws.projects.UWSMP3App.controller.MP3SessionController;
import marco.uws.projects.UWSMP3App.model.Mp3;


@Path("/mp3")
public class MP3Endpoint {
	
	MP3SessionController mp3controller = new MP3SessionController();
	
	@Path("/something")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String something (){
		return "1234blabla";
	}
	
	@Path("/{title}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addMp3 ( @PathParam("title") String title){
		mp3controller.createMP3(title);
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Mp3 getMP3(@PathParam("id") long id){
		Mp3 b= mp3controller.read(id);
		return b ;
	}
	
	
	public static void main(String[] args) {
		MP3Endpoint be = new MP3Endpoint();
    	
       be.addMp3("Kid Rock");
        
        
    }
	

}
