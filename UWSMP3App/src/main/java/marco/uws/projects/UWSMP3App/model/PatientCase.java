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
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
@Entity
public class PatientCase {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private long caseID;
	
	@OneToMany(mappedBy = "patientCase", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Set<Medicine> medicines = new HashSet<Medicine>();
	
	private String caseDescription;
	
	public PatientCase(){
		
	}

	public long getCaseID() {
		return caseID;
	}

	public void setCaseID(long caseID) {
		this.caseID = caseID;
	}
	
	@XmlTransient
	public Set<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(Set<Medicine> medicine) {
		this.medicines = medicine;
	}

	public String getCaseDescription() {
		return caseDescription;
	}

	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}
	
}