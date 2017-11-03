package marco.uws.projects.UWSMP3App.controller;

import marco.uws.projects.UWSMP3App.model.Mp3;

public class MP3SessionController {
	
	Mp3 classObjectMp3 = new Mp3();

	
	public void createMP3(Mp3 o) {
    MP3Controller.saveObject(o);
    }
	
	public Mp3 read(long id) {	
	return (Mp3) MP3Controller.getObject(classObjectMp3, id);
        
    }
	
	public Mp3 update(Mp3 o) {
	MP3Controller.saveObject(o);
	return read(o.getId());
    }
    
    public void delete(long id) {
    Mp3	o = read(id);
    MP3Controller.deleteObject(o);
    
    }
}
