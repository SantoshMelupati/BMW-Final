package springboot2.springboot2jpacrudexample.main.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students", uniqueConstraints= {@UniqueConstraint(columnNames= {"mailid"})})
public class Student {

	
	private String name;
	@Id
	@SequenceGenerator(name="studentSequence", initialValue=4000, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="studentSequence")	
	private Long   id;
	@Column(unique = true)
	private String mailid;
	private String phoneno;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	
    @JoinColumn(name = "dept_id",referencedColumnName ="deptid")
	public Department department;
	
	public College getCollege() {
		return college;
	}



	public void setCollege(College college) {
		this.college = college;
	}



	public Student(String name, Long id, String mailid, String phoneno, Department department, College college,
			String dob, String gender, String areaofinterest1, String areaofinterest2, String areaofinterest3) {
		super();
		this.name = name;
		this.id = id;
		this.mailid = mailid;
		this.phoneno = phoneno;
		this.department = department;
		this.college = college;
		this.dob = dob;
		this.gender = gender;
		this.areaofinterest1 = areaofinterest1;
		this.areaofinterest2 = areaofinterest2;
		this.areaofinterest3 = areaofinterest3;
	}



	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "coolegeCode",referencedColumnName = "coolegeCode")
    private College college;
	
	//private String department;
	private String dob;
	private String gender;
	private String areaofinterest1;
	private String areaofinterest2;
	private String areaofinterest3;
	
	public Student() {
		
	}
	
	
	
	public Student(String name, Long id, String mailid, String phoneno
			) {
		super();
		this.name = name;
		this.id = id;
		this.mailid = mailid;
		this.phoneno = phoneno;
		
	}



	
	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}

	
	


	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAreaofinterest1() {
		return areaofinterest1;
	}



	public void setAreaofinterest1(String areaofinterest1) {
		this.areaofinterest1 = areaofinterest1;
	}



	public String getAreaofinterest2() {
		return areaofinterest2;
	}



	public void setAreaofinterest2(String areaofinterest2) {
		this.areaofinterest2 = areaofinterest2;
	}



	public String getAreaofinterest3() {
		return areaofinterest3;
	}



	public void setAreaofinterest3(String areaofinterest3) {
		this.areaofinterest3 = areaofinterest3;
	}



	public Student(String name, Long id, String mailid, String phoneno, Department department, String dob, String gender,
			String areaofinterest1, String areaofinterest2, String areaofinterest3) {
		super();
		this.name = name;
		this.id = id;
		this.mailid = mailid;
		this.phoneno = phoneno;
		this.department = department;
		this.dob = dob;
		this.gender = gender;
		this.areaofinterest1 = areaofinterest1;
		this.areaofinterest2 = areaofinterest2;
		this.areaofinterest3 = areaofinterest3;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getMailid() {
		return mailid;
	}



	public void setMailid(String mailid) {
		this.mailid = mailid;
	}



	public String getPhoneno() {
		return phoneno;
	}



	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}



	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", mailid=" + mailid + ", phoneno=" + phoneno + ", department="
				+ department + ", college=" + college + ", dob=" + dob + ", gender=" + gender + ", areaofinterest1="
				+ areaofinterest1 + ", areaofinterest2=" + areaofinterest2 + ", areaofinterest3=" + areaofinterest3
				+ "]";
	}



	



	
	

}




