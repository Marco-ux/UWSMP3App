package marco.uws.projects.UWSMP3App.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name = "PlayList")
public class PlayList {

	@Id
	@Column(nullable = false)
	private long id;
	private String title;
	
	
	@ManyToMany(mappedBy = "playListsInvolved", fetch = FetchType.EAGER)
	private Set<Mp3> tracks = new HashSet<Mp3>();
	
	public PlayList(){
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Mp3> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Mp3> tracks) {
		this.tracks = tracks;
	}

	

	

	
	
}
