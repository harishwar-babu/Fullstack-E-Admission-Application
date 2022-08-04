package com.example.Eadmission.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ConfirmationModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)private Long id;
	private String appid;
	private String code;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ConfirmationModel(Long id, String appid, String code) {
		super();
		this.id = id;
		this.appid = appid;
		this.code = code;
	}
	public ConfirmationModel()
	{
		
	}
	
}
