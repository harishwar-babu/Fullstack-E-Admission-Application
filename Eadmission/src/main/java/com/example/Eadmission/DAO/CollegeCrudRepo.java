package com.example.Eadmission.DAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.Eadmission.Model.*;
public interface CollegeCrudRepo extends CrudRepository<CollegeModel,String> {
	@Query("SELECT COUNT(*) FROM CollegeModel s WHERE s.name=:name")
    int  checker(@Param("name")String name);
	
	@Query("SELECT COUNT(*) FROM CollegeModel s WHERE s.code=:code")
    int  value(@Param("code")String code);
}
