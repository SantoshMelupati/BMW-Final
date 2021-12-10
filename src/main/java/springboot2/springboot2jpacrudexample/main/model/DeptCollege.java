package springboot2.springboot2jpacrudexample.main.model;

public class DeptCollege {
	
	private String   deptId;
	private String   collegeId;
	
	public DeptCollege(String deptId, String collegeId) {
		super();
		this.deptId = deptId;
		this.collegeId = collegeId;
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

	@Override
	public String toString() {
		return "DeptCollege [deptId=" + deptId + ", collegeId=" + collegeId + "]";
	}
	
	

}
