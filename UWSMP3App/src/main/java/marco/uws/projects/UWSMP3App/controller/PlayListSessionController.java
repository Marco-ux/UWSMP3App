package marco.uws.projects.UWSMP3App.controller;

import marco.uws.projects.UWSMP3App.model.Medicine;
import marco.uws.projects.UWSMP3App.model.PatientCase;
import marco.uws.projects.UWSMP3App.model.PlayList;
import marco.uws.projects.UWSMP3App.model.User;

public class PlayListSessionController {
	
	PlayList PlayListObject = new PlayList();
	PatientCase patientCaseObject = new PatientCase();
	Medicine medicineObject = new Medicine();
	
	UserSessionController userSessionController = new UserSessionController();
	
	public void create(long userId, PlayList o) {
		User creator = userSessionController.read(userId);
		o.setCreator(creator);
	    MP3Controller.saveObject(o);
	    }
		
		public PlayList read(long id) {	
		return (PlayList) MP3Controller.getObject(PlayListObject, id);
	    }
	    
		
				public PatientCase readPatientcase(long id) {	
				return (PatientCase) MP3Controller.getObject(patientCaseObject, id);
				}
				
				public Medicine readMedicine(long id) {	
				return (Medicine) MP3Controller.getObject(medicineObject, id);
				}
		
		public PlayList update(PlayList o) {
		MP3Controller.saveObject(o);
		return read(o.getId());
	    }
	    
	    public void delete(long id) {
	    PlayList o = read(id);
	    MP3Controller.deleteObject(o);
	    }


}
