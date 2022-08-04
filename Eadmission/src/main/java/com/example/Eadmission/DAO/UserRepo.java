package com.example.Eadmission.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eadmission.Model.UserModel;


@Repository
public interface UserRepo extends JpaRepository<UserModel, Long>{
	
	boolean existsByemail(String email);

	boolean existsByemailAndPassword(String email, String password);
	
	UserModel getDetailByemail(String email);

	UserModel findByUsername(String username);

	boolean existsByemailAndUsername(String email, String username);

	UserModel getDetailByusername(String username);
	
	UserModel findByEmail(String email);
}
