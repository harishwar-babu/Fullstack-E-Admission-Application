package com.example.Eadmission.Service;
import java.util.List;

import com.example.Eadmission.Model.*;
public interface AppService {
	//Add or submit application
	
	public String submitAppln(ApplnModel detail);

	// check if the application already exists
	
	boolean appcount(String email, String mbno,String name);
	
	public List<ApplnModel> view();
	
	// GENERATING  COLLEGES BASED ON MARKS
	
	public void colleges(String appid);
	
	// sending the email for the confirmation 
	
	//public String confirmationMail(String code);
	
	//updating the details
	
}
