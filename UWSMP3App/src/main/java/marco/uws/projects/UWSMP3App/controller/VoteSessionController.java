package marco.uws.projects.UWSMP3App.controller;

import marco.uws.projects.UWSMP3App.model.Mp3;
import marco.uws.projects.UWSMP3App.model.User;
import marco.uws.projects.UWSMP3App.model.Vote;

public class VoteSessionController {
	
Vote classObjectVote = new Vote();
UserSessionController userSessionController = new UserSessionController();
	
/**
 * Adds a new Vote to the database
 * @param the userID of the voter
 * @param the number between 0 and 5 voted
 * @return the created Vote
 */
	public Vote create(long userID, int vote) {
		User u = userSessionController.read(userID);
		Vote v = new Vote();
		v.setRating(vote);
		v.setVoter(u);
		long id =MP3Controller.saveObjectReturnsID(v);
		return read(id);
    }
	
	/**
	 * Gets a Vote from the database
	 * @param the VoteID 
	 * @return the desired Vote
	 */
	public Vote read(long id) {	
	return (Vote) MP3Controller.getObject(classObjectVote, id);
        
    }
	
	/**
	 * Udates a Vote in the database
	 * @param the Vote object
	 * @return the updated Vote object
	 */
	public Vote update(Mp3 o) {
	MP3Controller.saveObject(o);
	return read(o.getId());
    }
    
	/**
	 * Deletes a Vote from the database
	 * @param the VoteID
	 */
    public void delete(long id) {
    Vote	o = read(id);
    MP3Controller.deleteObject(o);
    }

}
