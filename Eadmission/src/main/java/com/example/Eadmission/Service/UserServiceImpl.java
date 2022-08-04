package com.example.Eadmission.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Eadmission.DAO.*;
import com.example.Eadmission.Model.*;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired UserCrudRepo user;
    @Autowired
    public UserRepo userrepo;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired SimpleEmail se;
    // add new users
	public String createEmployee(UserModel detail) {
		String password = detail.getPassword();
		if(user.usernamecount(detail.getUsername(),detail.getEmail())==0 && user.count1(detail.getUsername())==0 && user.count2(detail.getEmail())==0) {
		detail.setPassword(passwordEncoder.encode(detail.getPassword()));
		userrepo.save(detail);
		String email=detail.getEmail();
		String body="Your Login Credentials is UserName:"+" "+detail.getUsername()+" "+"Password:"+" "+password;
		String subject ="Login Credentials";
		se.sendemail(email, subject, body);return "Saved";}
		return "Username Already Exists";
	}
		public String existsByemail(String email) {
			return((userrepo.existsByemail(email)) ? "true" :"false" );
		}

		public String existsByemailAndpassword(String email, String password) {
			return((userrepo.existsByemailAndPassword(email, password))? "true" :"false");
		}
		
		public UserModel getDetailByemail(String email) {

			 return userrepo.getDetailByemail(email);
			 
		}
		
		@Override
		public String existsByemailandusername(String email, String username) {
			String b=userrepo.existsByemailAndUsername(email, username)? "true" :"false";
			return (b);
			
		}

		@Override
		public UserModel getDetailByusername(String username) {
			return userrepo.getDetailByusername(username);
		}	
}