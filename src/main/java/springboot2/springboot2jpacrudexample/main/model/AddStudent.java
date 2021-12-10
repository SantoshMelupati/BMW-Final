package springboot2.springboot2jpacrudexample.main.model;



public class AddStudent {
	
	private String name;
	private String mailid;
	private String phoneno;
	public String deptId;
	public String collegeId;
	private String dob;
	private String gender;
	private String areaofinterest1;
	private String areaofinterest2;
	private String areaofinterest3;
	public AddStudent(String name, String mailid, String phoneno, String deptId, String collegeId, String dob,
			String gender, String areaofinterest1, String areaofinterest2, String areaofinterest3) {
		super();
		this.name = name;
		this.mailid = mailid;
		this.phoneno = phoneno;
		this.deptId = deptId;
		this.collegeId = collegeId;
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
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
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
	
	
	
}
