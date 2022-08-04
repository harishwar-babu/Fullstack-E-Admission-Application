package com.example.Eadmission.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Eadmission.Model.CollegeModel;
@Repository
public interface CollegeRepo extends JpaRepository<CollegeModel,String>{
	CollegeModel findByCode(String code);
	
}