package com.example.Eadmission.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Eadmission.Model.*;
import com.example.Eadmission.Service.ConfirmationServiceImpl;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ConfirmationController {
	@Autowired ConfirmationServiceImpl c1;
	@PostMapping("/confirm")
	public String Message(@RequestBody ConfirmationModel detail)
	{
		return c1.SuccessMessage(detail);
	}
	
	@GetMapping("/choices")
	public List<ConfirmationModel> choices(){
		return c1.choices();
	}
}
