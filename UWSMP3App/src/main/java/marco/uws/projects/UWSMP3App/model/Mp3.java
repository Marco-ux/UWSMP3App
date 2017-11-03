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
	@Table(name = "mp3")
	public class Mp3 {
		
			@Id
			@Column(nullable = false)
		 	private long id;
		    private String title;
		    private String artist;
		    private String genre;
		    private String albumTitle;
		    
		    @ManyToMany (fetch = FetchType.EAGER)
		    private Set <PlayList> playListsInvolved= new HashSet<PlayList>();
		    
			public Mp3() {
				
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

			public String getArtist() {
				return artist;
			}

			public void setArtist(String artist) {
				this.artist = artist;
			}

			public String getGenre() {
				return genre;
			}

			public void setGenre(String genre) {
				this.genre = genre;
			}

			public String getAlbumTitle() {
				return albumTitle;
			}

			public void setAlbumTitle(String albumTitle) {
				this.albumTitle = albumTitle;
			}

			public Set<PlayList> getPlayListsInvolved() {
				return playListsInvolved;
			}

			public void setPlayListsInvolved(Set<PlayList> playListsInvolved) {
				this.playListsInvolved = playListsInvolved;
			}

		
			
			
			
}
