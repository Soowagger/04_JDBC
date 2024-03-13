package edu.kh.jdbc1.model.vo;

public class EmpP { // 연습용
	private String empName;
	private String empNo;
	private String deptTitle;
	private String jobName;
	
	private String deptId;
	private String empId;
	private String hireDate;
	
	public EmpP() {}

	public EmpP(String empName, String empNo, String deptTitle, String jobName) {
		super();
		this.empName = empName;
		this.empNo = empNo;
		this.deptTitle = deptTitle;
		this.jobName = jobName;
	}

	
	
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "EmpP [empName=" + empName + ", empNo=" + empNo + ", deptTitle=" + deptTitle + ", jobName=" + jobName
				+ "]";
	}
	
		
	
}
