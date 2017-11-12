package marco.uws.projects.UWSMP3App.controller;

import marco.uws.projects.UWSMP3App.model.Mp3;
import marco.uws.projects.UWSMP3App.model.Vote;

public class VoteSessionController {
	
Vote classObjectVote = new Vote();

	
	public void create(Vote o) {
    MP3Controller.saveObject(o);
    }
	
	public Vote read(long id) {	
	return (Vote) MP3Controller.getObject(classObjectVote, id);
        
    }
	
	public Vote update(Mp3 o) {
	MP3Controller.saveObject(o);
	return read(o.getId());
    }
    
    public void delete(long id) {
    Vote	o = read(id);
    MP3Controller.deleteObject(o);
    }

}
