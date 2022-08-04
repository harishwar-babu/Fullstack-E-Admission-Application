package com.example.Eadmission.Service;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.Eadmission.Model.*;
public interface CollegeService {
	//Add college 
	public String addClg(CollegeModel detail);
	
	//update the details
	public ResponseEntity<CollegeModel> updateDetail(String id,  CollegeModel detail);
	
	//view the colleges
	
	public List<CollegeModel> getAllClgs();
	
	//Delete the College
	
	public String deleteClgs(@PathVariable String id);
	
	
	// view user profile
	
	public List<ApplnModel>user();
	
	// get college by id
	
	public CollegeModel getClgbyId(@PathVariable String id);
}
