package marco.uws.projects.UWSMP3App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "mp3")
	public class Mp3 {
		
		 	private long id;
		    private String title;
		    private String author;
		    private float price;
		    
			public Mp3() {
				
			}
			
			@Id
			@Column(name = "mp3_id")
			@GeneratedValue(strategy = GenerationType.IDENTITY)
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

			public String getAuthor() {
				return author;
			}

			public void setAuthor(String author) {
				this.author = author;
			}

			public float getPrice() {
				return price;
			}

			public void setPrice(float price) {
				this.price = price;
			}
			
}
