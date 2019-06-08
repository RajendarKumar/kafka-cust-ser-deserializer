/**
 * 
 */
package com.raj.kafka.model;

import java.util.Date;

/**
 * @author Rajendar
 *
 */
public class Employee {

	private int empNo;
	private String name;
	private Date dob;
	/**
	 * @param empNo
	 * @param name
	 * @param dob
	 */
	public Employee(int empNo, String name, Date dob) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.dob = dob;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name + ", dob=" + dob + "]";
	}
	
	
}
