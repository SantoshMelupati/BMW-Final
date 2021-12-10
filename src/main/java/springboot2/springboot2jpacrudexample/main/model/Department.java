package springboot2.springboot2jpacrudexample.main.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Department {
	
	
	
	@Id
	private String   deptid;
	private Long   duration_regular;
	private Long   duration_lateral;
	private String dept_name;
	private Long noofsemesters_regular;
	private Long noofsemesters_lateral;
	private Long noofseats;
	@Transient
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY,
		    cascade = CascadeType.ALL)
		    private Set<Student> student;
	
	public Department() {
		super();
	}
	
	public Department(String dept_id, Long duration_regular, Long duration_lateral, String dept_name,
			Long noofsemesters_regular, Long noofsemesters_lateral, Long noofseats) {
		super();
		this.deptid = dept_id;
		this.duration_regular = duration_regular;
		this.duration_lateral = duration_lateral;
		this.dept_name = dept_name;
		this.noofsemesters_regular = noofsemesters_regular;
		this.noofsemesters_lateral = noofsemesters_lateral;
		this.noofseats = noofseats;
	}

	public String getDept_id() {
		return deptid;
	}

	public void setDept_id(String dept_id) {
		this.deptid = dept_id;
	}

	public Long getDuration_regular() {
		return duration_regular;
	}

	public void setDuration_regular(Long duration_regular) {
		this.duration_regular = duration_regular;
	}

	public Long getDuration_lateral() {
		return duration_lateral;
	}

	public void setDuration_lateral(Long duration_lateral) {
		this.duration_lateral = duration_lateral;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Long getNoofsemesters_regular() {
		return noofsemesters_regular;
	}

	public void setNoofsemesters_regular(Long noofsemesters_regular) {
		this.noofsemesters_regular = noofsemesters_regular;
	}

	public Long getNoofsemesters_lateral() {
		return noofsemesters_lateral;
	}

	public void setNoofsemesters_lateral(Long noofsemesters_lateral) {
		this.noofsemesters_lateral = noofsemesters_lateral;
	}

	public Long getNoofseats() {
		return noofseats;
	}

	public void setNoofseats(Long noofseats) {
		this.noofseats = noofseats;
	}
	
	
	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", duration_regular=" + duration_regular + ", duration_lateral="
				+ duration_lateral + ", dept_name=" + dept_name + ", noofsemesters_regular=" + noofsemesters_regular
				+ ", noofsemesters_lateral=" + noofsemesters_lateral + ", noofseats=" + noofseats + ", student="
				+ student + "]";
	}
	
}