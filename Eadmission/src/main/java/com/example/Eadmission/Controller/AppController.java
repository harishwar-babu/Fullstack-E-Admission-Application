package com.example.Eadmission.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Eadmission.Model.*;
import com.example.Eadmission.Service.AppServiceImpl;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class AppController {
	@Autowired AppServiceImpl c1;
	
	//Submiting the application
	
	@PostMapping("/submit")
	public String submit( @RequestBody ApplnModel detail)
	{
		return c1.submitAppln(detail);
		
	}
	@GetMapping("/view")
	
	public List<ApplnModel> view()
	{
		return c1.view();
	}	
}
