package com.example.Eadmission.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Eadmission.DAO.CollegeCrudRepo;
import com.example.Eadmission.Model.*;
import com.example.Eadmission.Service.*;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class CollegeController {
	@Autowired CollegeServiceImpl c1;
	@Autowired CollegeCrudRepo c2;
	//Adding colleges
	@PostMapping("/AddClg")
	public String addclg(@RequestBody CollegeModel detail)
	{
		return c1.addClg(detail);
	}
	
	// get college by id;
	@GetMapping("/ViewClg/{id}")
	
	public CollegeModel viewbyid(@PathVariable String id)
	{
		return c1.getClgbyId(id);
	}
	
	//View colleges
	@GetMapping("/ViewClg")
	public List<CollegeModel> view()
	{
		return c1.getAllClgs();
	}
	
	//update college
	
	@PutMapping("/Clgupdate/{id}")
	public ResponseEntity<CollegeModel> updateDetail(@PathVariable String id, @RequestBody CollegeModel detail) {
		return c1.updateDetail(id,detail);
	}
	
	//delete colleges
	
	@DeleteMapping("/deleteClg/{id}")
	public String deleteClg(@PathVariable String id) {
		return c1.deleteClgs(id);
	}
	
	//View the user profile
	@GetMapping("/viewusers")
	public List<ApplnModel> users()
	{
		return c1.user();
	}
	@GetMapping("/count/{name}")
	public int count(@PathVariable String name)
	{
		return c2.checker(name);
	}
	

}
