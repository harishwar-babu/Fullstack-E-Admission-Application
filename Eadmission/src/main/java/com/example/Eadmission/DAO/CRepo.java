package com.example.Eadmission.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Eadmission.Model.*;
@Repository
public interface CRepo extends JpaRepository<ConfirmationModel,Long>{
	
}
