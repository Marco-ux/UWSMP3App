package marco.uws.projects.UWSMP3App.controller;

import marco.uws.projects.UWSMP3App.model.User;

import java.util.Set;

import marco.uws.projects.UWSMP3App.model.PlayList;;

public class UserSessionController {
	
User classObjectUser = new User();

	
	public User create(String firstName, String secondName, String password) {
		classObjectUser.setFistName(firstName);
		classObjectUser.setLastName(secondName);
		classObjectUser.setPassword(password);
		long id = MP3Controller.saveObjectReturnsID(classObjectUser);
		return read(id);
    }
	
	public User read(long id) {	
	return (User) MP3Controller.getObject(classObjectUser, id);  
    }
	
	public User update(User o) {
	MP3Controller.saveObject(o);
	return read(o.getId());
    }
    
    public void delete(long id) {
    	User	o = read(id);
    MP3Controller.deleteObject(o);
    }
    
    public Set<PlayList> getPlayLists(long id){
    	User o = read(id);
    	return o.getPlayListsFollowed();
    }

}
