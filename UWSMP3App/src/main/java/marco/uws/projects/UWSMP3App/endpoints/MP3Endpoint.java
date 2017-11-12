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
import marco.uws.projects.UWSMP3App.model.Medicine;
import marco.uws.projects.UWSMP3App.model.Mp3;
import marco.uws.projects.UWSMP3App.model.PatientCase;
import marco.uws.projects.UWSMP3App.model.PlayList;
import marco.uws.projects.UWSMP3App.model.User;
import marco.uws.projects.UWSMP3App.model.Vote;


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
	
	/**
	 * This main method put a fist mp3 object into your MYSQL Database
	 * Run this main method as Righ click on it in the Project Explorer >Run As
	 * >Run as Java Application
	 */
	public static void main(String[] args) {
		
		/*
		PatientCase p = new PatientCase();
		p.setCaseDescription("neuer Fall");
		MP3Controller.saveObject(p);
		
		Medicine m = new Medicine();
		m.setPatientCase(p);
		m.setName("Medizin 1");
		MP3Controller.saveObject(m);
		*/
		
		
		Mp3 mp32 = new Mp3();
    	mp32.setTitle("grausagf");
    	MP3Controller.saveObject(mp32);
		
		Mp3 mp3 = new Mp3();
    	mp3.setTitle("hallo");
    	//mp3.setId(0);
    	MP3Controller.saveObject(mp3);
    	
    	User udo = new User();
    	udo.setFistName("Udo");
    	MP3Controller.saveObject(udo);
    	
    	PlayList play = new PlayList();
    	play.setTitle("frech");
    	play.setCreator(udo);
    	MP3Controller.saveObject(play);
    	
    	Vote vote1 = new Vote();
    	vote1.setVoter(udo);
      	MP3Controller.saveObject(vote1);
    	
    	mp3 = (Mp3) MP3Controller.getObject(new Mp3(), 2);
    	udo = (User) MP3Controller.getObject(new User(), 0);
    	vote1 = (Vote) MP3Controller.getObject(new Vote(), 0);
    	
    	play= (PlayList) MP3Controller.getObject(new PlayList(), 0);
    	
    	play.getTracks().add(mp3);
    	
    	play.getPlayListFollowers().add(udo);
    	
    	play.getVotes().add(vote1);
    	
    	MP3Controller.saveObject(play);
    	
        
    }
	

}
