package marco.uws.projects.UWSMP3App.controller;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

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
    
    /**
     * This track that is contained in the most plallists get position 0. The tracks with the fewest
     * playlist get .size-1
	 */
    public TreeSet<Mp3> getCharts(){
    	List<Object> list = MP3Controller.getAllInstances(classObjectMp3);
    	TreeSet<Mp3> sortedSet = new TreeSet(list);
    	return sortedSet; 	
    }
	public int getIndividualRank(long id) {
		Mp3	o = read(id);
		TreeSet<Mp3> sortedSet = getCharts();
		int rank = sortedSet.headSet(o).size();
		//+1 because of first position is 0
		return rank +1;
	}
}
