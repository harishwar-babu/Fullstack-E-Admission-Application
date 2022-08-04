package com.example.Eadmission.Model;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class ApplnModel {
	@Id
    @GenericGenerator(name = "code", strategy = "com.example.Eadmission.Model.IDGenerator")
    @GeneratedValue(generator = "code") 
	private String id;
	private String name;
	private Date dob;
	private String mbno;
	private String email;
	private Long sslc;
	private Long hslc;
	private String department;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getMbno() {
		return mbno;
	}
	public void setMbno(String mbno) {
		this.mbno = mbno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getSslc() {
		return sslc;
	}
	public void setSslc(Long sslc) {
		this.sslc = sslc;
	}
	public Long getHslc() {
		return hslc;
	}
	public void setHslc(Long hslc) {
		this.hslc = hslc;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public ApplnModel(String id, String name, Date dob, String mbno, String email, Long sslc, Long hslc,String department) {
		super();
		this.id=id;
		this.name = name;
		this.dob = dob;
		this.mbno = mbno;
		this.email = email;
		this.sslc = sslc;
		this.hslc = hslc;
		this.department=department;
	}
	public ApplnModel() {
		
	}
}
