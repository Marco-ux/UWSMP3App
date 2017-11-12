package marco.uws.projects.UWSMP3App.controller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import marco.uws.projects.UWSMP3App.model.Mp3;
import marco.uws.projects.UWSMP3App.model.PlayList;
import marco.uws.projects.UWSMP3App.model.User;
import marco.uws.projects.UWSMP3App.model.Vote;

public class PlayListSessionController {
	
	PlayList PlayListObject = new PlayList();
	
	UserSessionController userSessionController = new UserSessionController();
	
	public void create(long userId, PlayList o) {
		User creator = userSessionController.read(userId);
		o.setCreator(creator);
	    MP3Controller.saveObject(o);
	    }
		
		public PlayList read(long id) {	
		return (PlayList) MP3Controller.getObject(PlayListObject, id);
	    }
		
		public PlayList update(PlayList o) {
		MP3Controller.saveObject(o);
		return read(o.getId());
	    }
	    
	    public void delete(long id) {
	    PlayList o = read(id);
	    MP3Controller.deleteObject(o);
	    }

		public Set<Mp3> getTracks(long id) {
			PlayList o = read(id);
			Set<Mp3> list = new HashSet<Mp3>();
			list.addAll(o.getTracks());
			return list;
		}

		public User getCreator(long id) {
			PlayList o = read(id);
			return o.getCreator();
		}

		public double getVoteResult(long id) {
			double count = 0;
			PlayList o = read(id);
			double size = o.getVotes().size();
			
			for(Vote v : o.getVotes()){
			count+=v.getRating();
			}
			return count/size;
		}


}
