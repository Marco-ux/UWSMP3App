package marco.uws.projects.UWSMP3App.controller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import marco.uws.projects.UWSMP3App.exceptions.NotAuthorizedException;
import marco.uws.projects.UWSMP3App.model.Mp3;
import marco.uws.projects.UWSMP3App.model.PlayList;
import marco.uws.projects.UWSMP3App.model.User;
import marco.uws.projects.UWSMP3App.model.Vote;

public class PlayListSessionController {
	
	PlayList PlayListObject = new PlayList();
	
	UserSessionController userSessionController = new UserSessionController();
	MP3SessionController mp3sessioncntroller = new MP3SessionController();
	JwtController jwtController = new JwtController();
	VoteSessionController voteSessionController = new VoteSessionController();
	
	/**
	 * Adds the given PlayList to the database
	 * @param the userID of the user that creates the PlayList
	 * @param the PlayList that should be added to the database
	 * @param the session token of the logged user
	 */
	public void create(long userId, PlayList o, String token) {
		if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
		User creator = userSessionController.read(userId);
		o.setCreator(creator);
	    MP3Controller.saveObject(o);
	    }
	
	/**
	 * Reads the desired PlayList from the database
	 * @param the ID of the desired PlayList
	 * @param the session token of the logged user
	 */
		public PlayList read(long id, String token) {
		if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
		return (PlayList) MP3Controller.getObject(PlayListObject, id);
	    }
		
		/**
		 * Updates the desired PlayList the database
		 * @param the PlayList object that should replace the old one in the database
		 * @param the session token of the logged user
		 * @return the new PlayList
		 */
		public PlayList update(PlayList o, String token) {
		if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
		MP3Controller.saveObject(o);
		return read(o.getId(), token);
	    }
	    
		/**
		 * Deletes an PlayList from the database
		 * @param the PlayList object that should removed from the database
		 * @param the session token of the logged user
		 */
	    public void delete(long id, String token) {
	    if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
	    PlayList o = read(id, token);
	    MP3Controller.deleteObject(o);
	    }

	    /**
		 * Gets all the tracks that are currently a PlayList
		 * @param the PlayList object that should removed from the database
		 * @param the session token of the logged user
		 * @return The Set of tracks
		 */
		public Set<Mp3> getTracks(long id, String token) {
			if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
			PlayList o = read(id, token);
			Set<Mp3> list = new HashSet<Mp3>();
			list.addAll(o.getTracks());
			return list;
		}

		/**
		 * Gets the creator of a PlayList
		 * @param the PlayList object that should removed from the database
		 * @param the session token of the logged user
		 * @return the User that created the PlayList
		 */
		public User getCreator(long id, String token) {
			if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
			PlayList o = read(id, token);
			return o.getCreator();
		}

		/**
		 * Gets the average voting of a PlayList
		 * @param the PlayList object that should removed from the database
		 * @param the session token of the logged user
		 * @return the average voting
		 */
		public double getVoteResult(long id, String token) {
			if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
			double count = 0;
			PlayList o = read(id, token);
			double size = o.getVotes().size();
			
			for(Vote v : o.getVotes()){
			count+=v.getRating();
			}
			return count/size;
		}

		/**
		 * Adds a new track to the PlayList 
		 * @param the ID of the PlayList
		 * @param the Id of the Mp3 that should be added
		 * @param the session token of the logged user
		 * @return the updated PlayList
		 */
		public PlayList addMp3(long playListid, long mp3id, String token) {
			if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
			PlayList o = read(playListid, token);
			Mp3 m = mp3sessioncntroller.read(mp3id, token);
			o.getTracks().add(m);
			return update(o,token);
		}
		
		/**
		 * Adds a new track to the PlayList 
		 * @param the ID of the PlayList
		 * @param the Id of the Mp3 that should be added
		 * @param the session token of the logged user
		 * @return the updated PlayList
		 */
		public PlayList addVote(long playListid, long userID, int vote ,String token) {
			if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
			PlayList o = read(playListid, token);
			o.getVotes().add(voteSessionController.create(userID, vote));
			return read(playListid, token);
		}

		/**
		 * Adds a User as a new follower to the PlayList
		 * @param the ID of the PlayList
		 * @param the Id of the User that should be added
		 * @param the session token of the logged user
		 * @return the updated PlayList
		 */
		public PlayList addFollower(long playListId, long userId, String token) {
			if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
			PlayList o = read(playListId, token);
			User u = userSessionController.read(userId);
			o.getPlayListFollowers().add(u);
			return update(o, token);
			
		}


}
