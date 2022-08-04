package com.example.Eadmission.DAO;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Eadmission.Model.*;
public interface AppCrudRepo extends CrudRepository<ApplnModel,Long> {
	// checking if the application already submitted
	@Query("SELECT COUNT(*) FROM ApplnModel s WHERE s.email=:email and  s.mbno=:mbno and s.name=:name")
    int  appcount(@Param("email")String email,@Param("mbno")String mbno,@Param("name") String name);
	// generating the college based on Cutoff;
	@Query("select s from CollegeModel s where s.mincutoff<=:hslc and s.maxcutoff>=:hslc")
	List<CollegeModel> collegeList(@Param("hslc") Long hslc);
	// count of Departments
	@Query("select count(*) from ApplnModel s where s.department=:department")
	Long Deptcount(@Param("department") String department);
	// checking if the appln id exists;
	
	
	//Checking if the application number is Present
	
	@Query("select count(*) from ApplnModel s where s.id=:id")
	int appnocount(@Param("id") String id);
	}
