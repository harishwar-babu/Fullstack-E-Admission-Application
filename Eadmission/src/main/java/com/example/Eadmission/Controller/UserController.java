package com.example.Eadmission.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Eadmission.Model.*;
import com.example.Eadmission.Utils.*;
import com.example.Eadmission.Service.*;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class UserController {
	Logger logger =LoggerFactory.getLogger(UserController.class);
	@Autowired
    public UserService userservice;
	
	@Autowired
    private JwtUtil jwtUtil;
	
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
    	logger.trace("Entering into the authenticate function");
    	logger.debug("Checking");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
        	logger.error("error occured while login");
            throw new Exception("inavalid username/password");
        }
        logger.info(" Authenticated Success Fully");
        return jwtUtil.generateToken(authRequest.getUsername());
    }

   

    //add
	@PostMapping("/UserAdd")
	public String createEmployee(@RequestBody UserModel detail) {
		return userservice.createEmployee(detail);
	}
	
		//Find mail id is already exixts or not
		@GetMapping("/getByMailId/{email}&{username}")
		public String existsByemail(  @PathVariable String email, @PathVariable String username) {
				return(userservice.existsByemailandusername(email,username));
					
		}
		
		//check email and password is exixts or not
		@GetMapping("/getByEmailandpassword/{email}&{password}")
		 public String existsByemailAndPassword(  @PathVariable String email , @PathVariable String password) {
			return(userservice.existsByemailAndpassword(email,password));
				
		}
		
		//find by emailId
		@GetMapping("/getByemail/{email}")
		public UserModel getDetailByemail(@PathVariable String email) {
			 return userservice.getDetailByemail(email);
			
		}
		
		@GetMapping("/getByusername/{username}")
		public UserModel getDetailByusername(@PathVariable String username) {
			 return userservice.getDetailByusername(username);
			
		}
		
}
