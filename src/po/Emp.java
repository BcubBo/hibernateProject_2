package po;

import java.util.Date;

public class Emp implements java.io.Serializable {

	private static final long serialVersionUID = -8707746605996554961L;
	private Short empno;
	private String ename;
	private String job;
	private Short mgr;
	private Date hiredate;
	private Double sal;
	private Double comm;
	private Byte deptno;
	

	
	public Byte getDeptno() {
		return deptno;
	}

	public void setDeptno(Byte deptno) {
		this.deptno = deptno;
	}

	public Emp() {
	}

	public Emp(Short empno,String ename) {
		this.empno = empno;
		this.ename = ename;
	}

	public Short getEmpno() {
		return this.empno;
	}

	public void setEmpno(Short empno) {
		this.empno = empno;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Short getMgr() {
		return this.mgr;
	}

	public void setMgr(Short mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSal() {
		return this.sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return this.comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}
	
	
	
	
	

}////