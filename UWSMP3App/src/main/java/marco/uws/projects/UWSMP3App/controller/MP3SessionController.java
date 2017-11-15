package marco.uws.projects.UWSMP3App.controller;

import java.util.List;
import java.util.TreeSet;

import marco.uws.projects.UWSMP3App.exceptions.NotAuthorizedException;
import marco.uws.projects.UWSMP3App.model.Mp3;

public class MP3SessionController {
	
	Mp3 classObjectMp3 = new Mp3();
	JwtController jwtController = new JwtController();

	/**
	 * Adds the given Mp3 to the database
	 * @param the MP3 that should be added to the database
	 * @param the session token of the logged user
	 */
	public void createMP3(Mp3 o, String token) {
		if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
    MP3Controller.saveObject(o);
    }
	
	/**
	 * Reads the desired Mp3 from the database
	 * @param the ID of the desired MP3
	 * @param the session token of the logged user
	 */
	public Mp3 read(long id, String token) {
		if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
	return (Mp3) MP3Controller.getObject(classObjectMp3, id);
        
    }
	
	/**
	 * Updates the desired Mp3in the database
	 * @param the MP3 object that should replace the old one in the database
	 * @param the session token of the logged user
	 * @return the new Mp3
	 */
	public Mp3 update(Mp3 o, String token) {
		if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
		MP3Controller.saveObject(o);
	return read(o.getId(), token);
    }
    
	/**
	 * Deletes an MP3 from the database
	 * @param the MP3 object that should removed from the database
	 * @param the session token of the logged user
	 */
    public void delete(long id, String token) {
    	if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
    Mp3	o = read(id, token);
    MP3Controller.deleteObject(o);
    }
    
    /**
     * The track that is contained in the most plallists get position 0. The tracks with the fewest
     * playlist get .size-1
     * @param the session token of the logged user
	 */
    public TreeSet<Mp3> getCharts(String token){
    	if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
    	List<Object> list = MP3Controller.getAllInstances(classObjectMp3);
    	TreeSet<Mp3> sortedSet = new TreeSet(list);
    	return sortedSet; 	
    }
    
    /**
	 * Return the individual Rank of an MP3 among all registered MP3s
	 * @param the ID of the desired MP3
	 * @param the session token of the logged user
	 */
	public int getIndividualRank(long id, String token) {
		if (!jwtController.verifyToken(token)) throw new NotAuthorizedException();
		Mp3	o = read(id, token);
		TreeSet<Mp3> sortedSet = getCharts(token);
		int rank = sortedSet.headSet(o).size();
		//+1 because of first position is 0
		return rank +1;
	}
}
