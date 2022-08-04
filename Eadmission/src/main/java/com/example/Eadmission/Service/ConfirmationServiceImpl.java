package com.example.Eadmission.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
import com.example.Eadmission.DAO.*;
import com.example.Eadmission.Model.*;
@Service
public class ConfirmationServiceImpl implements ConfirmationService {
	Logger logger = LoggerFactory.getLogger(ConfirmationServiceImpl.class);
	@Autowired AppRepo c1;
	@Autowired AppCrudRepo c2;
	@Autowired CCrudRepo cc1;
	@Autowired CRepo cc2;
	@Autowired ConfirmationMail e1;
	@Autowired CollegeRepo coll1;
	@Autowired CollegeCrudRepo coll2;
	@Autowired ConfirmationPdf pdf;
	@Override
	public String SuccessMessage(ConfirmationModel detail) {
		logger.trace("Entering into Success Model method");
		String appid=detail.getAppid();
		String code=detail.getCode();
		if(c2.appnocount(appid)==1 && coll2.value(code)==1) {
		ApplnModel record=c1.findById(appid).orElseThrow();
		CollegeModel college= coll1.findByCode(code);
		String email=record.getEmail();
		String name=record.getName();
		String cname=college.getName();
		String department=record.getDepartment();
		logger.debug("Checking");
		if(cc1.count(appid)==0 && Checker(appid,code)==true)
		{
			cc2.save(detail);
			final String sub = "Confirmation message for the Selection of the College";
			final String body= "Hi"+" "+record.getName()+" "+"Here is your AIEA2022 College Confirmation Allocation.. Note.. Take this during at the first day of your college";
			pdf.successMessage(name, code, cname, department, appid);
			e1.sendemail(email, sub, body);
			logger.info("Success");
			return "Check with your mail";
		}}logger.error("Already Submitted");
		return "You have already Submitted this form or your Application ID may be wrong or the Entered College Id may be Wrong";
	}

	@Override
	public boolean Checker(String appid,String code) {
		boolean flag=false;
		if(c2.appnocount(appid)==1) {
		ApplnModel record=c1.findById(appid).orElseThrow();
		Long hslc=record.getHslc();
		for(int i=0;i<c2.collegeList(hslc).size();i++)
		{
			if(c2.collegeList(hslc).get(i).getCode().equals(code))
			{
				flag=true;
			}
		}}return flag;
	}
	@Override
	public List<ConfirmationModel> choices()
	{
		return cc2.findAll();
	}
}
