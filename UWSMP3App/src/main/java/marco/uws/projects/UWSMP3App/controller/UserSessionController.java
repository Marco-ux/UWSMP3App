package marco.uws.projects.UWSMP3App.controller;

import marco.uws.projects.UWSMP3App.model.User;

import java.util.Set;

import marco.uws.projects.UWSMP3App.model.PlayList;;

public class UserSessionController {
	
User classObjectUser = new User();

/**
 * Adds the given User to the database
 * @param the first name of the User
 * @param the last name of the User
 * @param the desired password of the User
 */
	public User create(String firstName, String secondName, String password) {
		classObjectUser.setFistName(firstName);
		classObjectUser.setLastName(secondName);
		classObjectUser.setPassword(password);
		long id = MP3Controller.saveObjectReturnsID(classObjectUser);
		return read(id);
    }
	
	/**
	 * Gets a Userobject from the database
	 * @param the userID 
	 * @return the desired User
	 */
	public User read(long id) {	
	return (User) MP3Controller.getObject(classObjectUser, id);  
    }
	
	/**
	 * Udates a User in the database
	 * @param the User object
	 * @return the updated User object
	 */
	public User update(User o) {
	MP3Controller.saveObject(o);
	return read(o.getId());
    }
    
	/**
	 * Deletes a User from the database
	 * @param the UserID
	 */
    public void delete(long id) {
    	User	o = read(id);
    MP3Controller.deleteObject(o);
    }
    
    /**
	 * Gets all the PlayLists that a User follows
	 * @param the UserID
	 * @return a set of the PlayLists that a User follows
	 */
    public Set<PlayList> getPlayLists(long id){
    	User o = read(id);
    	return o.getPlayListsFollowed();
    }

}
