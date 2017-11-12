package marco.uws.projects.UWSMP3App.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
@Entity
@Table(name = "PlayList")
public class PlayList {

	@Id
	//@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private long id;
	private String title;
	
	
	@ManyToOne
	private User creator;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Mp3> tracks = new HashSet<Mp3>();
	
	@ManyToMany (fetch = FetchType.EAGER)
	private Set<User> playListFollowers = new HashSet<User>();
	
	//Removes the votes from the DB if the playlist ist deleted
	@OneToMany (cascade={CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
	@org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Set<Vote> votes = new HashSet<Vote>();
	
	
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
	
	@XmlTransient
	public Set<Mp3> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Mp3> tracks) {
		this.tracks = tracks;
	}
	
	@XmlTransient
	public Set<User> getPlayListFollowers() {
		return playListFollowers;
	}

	public void setPlayListFollowers(Set<User> playListFollowers) {
		this.playListFollowers = playListFollowers;
		
	}
	@XmlTransient
	public Set<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}
	
	@XmlTransient
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	

	

	
	
}
