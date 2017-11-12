package marco.uws.projects.UWSMP3App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
public class Medicine {
	@Id
	@Column(nullable = false)
	private long medicineNo;
	
	@ManyToOne
	private PatientCase patientCase;
	
	private String prescription;
	private String dosage;
	private String name;
	
	public Medicine(){
	}
	
	public Medicine(int id){
		this.medicineNo = id;
	}
	
	public long getMedicineNo() {
		return medicineNo;
	}
	public void setMedicineNo(long medicineNo) {
		this.medicineNo = medicineNo;
	}
	
	@XmlTransient
	public PatientCase getPatientCase() {
		return patientCase;
	}

	public void setPatientCase(PatientCase patientCase) {
		this.patientCase = patientCase;
	}

	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
}
