package com.example.Eadmission.DAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Eadmission.Model.*;
public interface UserCrudRepo extends CrudRepository<UserModel,Long> {
	@Query("SELECT COUNT(*) FROM UserModel s WHERE s.email=:email and  s.mobileNumber=:mobileNumber and s.username=:username")
    int  appcount(@Param("email")String email,@Param("mobileNumber")String mobileNumber,@Param("username") String username);
	
	@Query("SELECT COUNT(*) FROM UserModel s where s.username=:username and s.email=:email")
	int usernamecount(@Param("username") String username,@Param("email")String email);
	
	@Query("SELECT COUNT(*) FROM UserModel s where s.username=:username")
	int count1(@Param("username") String username);
	
	@Query("SELECT COUNT(*) FROM UserModel s where s.email=:email")
	int count2(@Param("email")String email);
}
