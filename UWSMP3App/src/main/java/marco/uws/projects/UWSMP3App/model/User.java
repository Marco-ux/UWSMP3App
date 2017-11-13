package marco.uws.projects.UWSMP3App.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(nullable = false)
 	private long id;
    private String fistName;
    private String lastName;
    private String password;
    
    @ManyToMany(mappedBy = "playListFollowers", fetch = FetchType.EAGER)
    private Set <PlayList> playListsFollowed= new HashSet<PlayList>();
    
	public User() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Set<PlayList> getPlayListsFollowed() {
		return playListsFollowed;
	}

	public void setPlayListsFollowed(Set<PlayList> playListsFollowed) {
		this.playListsFollowed = playListsFollowed;
	}
    

}
