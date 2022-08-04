package com.example.Eadmission.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Eadmission.DAO.*;
import com.example.Eadmission.Model.*;
@Service
public class CollegeServiceImpl implements CollegeService {
	Logger logger= LoggerFactory.getLogger(CollegeServiceImpl.class);
	@Autowired CollegeRepo c1;
	@Autowired CollegeCrudRepo c2;
	@Autowired AppRepo c3;
	
	@Override
	public ResponseEntity<CollegeModel> updateDetail(String id, CollegeModel detail) {
		logger.trace("Entering into update details");
		logger.debug(" Checking if the update details is working");
		CollegeModel v1 = c1.findByCode(id);
		v1.setName(detail.getName());
		v1.setDistrict(detail.getDistrict());
		v1.setMincutoff(detail.getMincutoff());
		v1.setMaxcutoff(detail.getMaxcutoff());
		logger.info("Working successfully");
		return ResponseEntity.ok(c1.save(v1));
	}
	@Override
	public List<CollegeModel> getAllClgs() {
		return c1.findAll();
	}
	@Override
	public String deleteClgs(String id) {
		c1.deleteById(id);
		return "Deleted Successfully!!!";
	}
	@Override 
	public List<ApplnModel> user()
	{
		return c3.findAll();
	}
	@Override
	public String addClg(CollegeModel detail) {
		logger.trace("Entering into add college method for checking if the college name exists");
		logger.debug("Checking if add college method is working");
		if(c2.checker(detail.getName())==0)
		{
			c1.save(detail);
			logger.info("Success");
			return "Added Successfully";
		}
		logger.error("Failure");
		return "Already Exists";
	}
	@Override
	
	public CollegeModel getClgbyId(String id)
	{
		return c1.findByCode(id);
	}
	
}
