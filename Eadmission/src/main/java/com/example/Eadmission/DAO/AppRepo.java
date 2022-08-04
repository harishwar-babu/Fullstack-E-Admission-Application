package com.example.Eadmission.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Eadmission.Model.ApplnModel;
@Repository
public interface AppRepo extends JpaRepository<ApplnModel,String>{
	
}