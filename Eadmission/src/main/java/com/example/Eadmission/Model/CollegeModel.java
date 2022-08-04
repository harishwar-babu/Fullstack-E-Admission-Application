package com.example.Eadmission.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class CollegeModel {
	
	@Id
    @GenericGenerator(name = "code", strategy = "com.example.Eadmission.Model.CCodeGenerator")
    @GeneratedValue(generator = "code") 
	private String code;
	private String name;
	private String district;
	private Long mincutoff;
	private Long maxcutoff;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Long getMincutoff() {
		return mincutoff;
	}
	public void setMincutoff(Long mincutoff) {
		this.mincutoff = mincutoff;
	}
	public Long getMaxcutoff() {
		return maxcutoff;
	}
	public void setMaxcutoff(Long maxcutoff) {
		this.maxcutoff = maxcutoff;
	}
	public CollegeModel(String name, String code, String district, Long mincutoff,
			Long maxcutoff) {
		super();
		this.name = name;
		this.code=code;
		this.district = district;
		this.mincutoff = mincutoff;
		this.maxcutoff = maxcutoff;	
		}
	public CollegeModel()
	{
		
	}
}