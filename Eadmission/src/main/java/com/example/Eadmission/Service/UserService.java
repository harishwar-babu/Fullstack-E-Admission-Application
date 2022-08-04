package com.example.Eadmission.Service;

import com.example.Eadmission.Model.*;



public interface UserService {
		
    public String createEmployee(UserModel detail);
    
	public String existsByemail(String email);
	
	public String existsByemailAndpassword(String email, String password);
	
	public UserModel getDetailByemail(String email);
	
	public String existsByemailandusername(String email, String username);

	public UserModel getDetailByusername(String username);
	
    
}
