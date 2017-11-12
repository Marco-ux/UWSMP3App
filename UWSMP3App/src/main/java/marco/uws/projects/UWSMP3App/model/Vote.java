package marco.uws.projects.UWSMP3App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Vote")
public class Vote {
	
	@Id
	//@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(nullable = false)
 	private long id;
	int rating;
	
	@ManyToOne
	User voter;
	
	public Vote() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public User getVoter() {
		return voter;
	}

	public void setVoter(User voter) {
		this.voter = voter;
	}
	
	
	

}
