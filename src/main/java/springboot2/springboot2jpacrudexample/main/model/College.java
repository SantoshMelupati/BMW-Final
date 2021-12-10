package springboot2.springboot2jpacrudexample.main.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "colleges")
public class College {
	
	@Id
	private String   coolegeCode;
	private String name;
	private String affiliatedTo;
	private String approvedBy;
	private String establishedYear;
	private String type;
	private String category;
	private String minorityInstitution;
	
	
	@Transient
	@OneToMany(mappedBy = "college", fetch = FetchType.LAZY,
		    cascade = CascadeType.ALL)
		    private Set<Student> student;
	

	

	public College(String coolegeCode, String name, String affiliatedTo, String approvedBy, String establishedYear,
			String type, String category, String minorityInstitution) {
		super();
		this.coolegeCode = coolegeCode;
		this.name = name;
		this.affiliatedTo = affiliatedTo;
		this.approvedBy = approvedBy;
		this.establishedYear = establishedYear;
		this.type = type;
		this.category = category;
		this.minorityInstitution = minorityInstitution;
	}

	public College() {
		super();
	}

	public String getCoolegeCode() {
		return coolegeCode;
	}

	public void setCoolegeCode(String coolegeCode) {
		this.coolegeCode = coolegeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAffiliatedTo() {
		return affiliatedTo;
	}

	public void setAffiliatedTo(String affiliatedTo) {
		this.affiliatedTo = affiliatedTo;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getEstablishedYear() {
		return establishedYear;
	}

	public void setEstablishedYear(String establishedYear) {
		this.establishedYear = establishedYear;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMinorityInstitution() {
		return minorityInstitution;
	}

	public void setMinorityInstitution(String minorityInstitution) {
		this.minorityInstitution = minorityInstitution;
	}

	@Override
	public String toString() {
		return "College [coolegeCode=" + coolegeCode + ", name=" + name + ", affiliatedTo=" + affiliatedTo
				+ ", approvedBy=" + approvedBy + ", establishedYear=" + establishedYear + ", type=" + type
				+ ", category=" + category + ", minorityInstitution=" + minorityInstitution  
				+ ", student=" + student + "]";
	}
	
	
	

}
