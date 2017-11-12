package marco.uws.projects.UWSMP3App.controller;

import marco.uws.projects.UWSMP3App.model.User;

public class UserSessionController {
	
User classObjectUser = new User();

	
	public void create(User o) {
    MP3Controller.saveObject(o);
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

}
