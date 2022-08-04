package com.example.Eadmission.DAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.Eadmission.Model.*;
public interface CCrudRepo extends CrudRepository<ConfirmationModel,Long> {
	
	//checking if the college is available
	@Query("SELECT COUNT(*) from ConfirmationModel s where s.code=:code")
	int codechecker(@Param("code") String code);
	
	@Query("SELECT COUNT(*) from ConfirmationModel s where s.appid=:appid")
	int count(@Param("appid") String appid);
	
	@Query("select count(*) from ApplnModel s where s.id=:id")
	int checkappln(@Param("id") String id);
}