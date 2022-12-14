package com.example.Eadmission.Service;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Eadmission.DAO.*;
import com.example.Eadmission.Model.ApplnModel;
import com.example.Eadmission.Model.CollegeModel;
import com.example.Eadmission.Model.UserModel;
@Service
public class AppServiceImpl implements AppService {
	Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);
	@Autowired EmailAttachment e1;
	@Autowired AppRepo c1;
	@Autowired AppCrudRepo c2;
	@Autowired CollegeRepo col1;
	@Autowired CCrudRepo cc1;
	@Autowired PdfGenerator pdf;
	@Autowired UserCrudRepo user;
	@Autowired UserRepo u1;
	@Override
	public String submitAppln(ApplnModel detail)  {
		logger.trace("Entering into submit Application method");
		try {
		UserModel u2=u1.findByEmail(detail.getEmail());
		String email=detail.getEmail();
		String name=detail.getName();
		String mbno=detail.getMbno();
		Long hslc = detail.getHslc();
		if(user.appcount(email, mbno,u2.getUsername())==1) {
		logger.debug("Checking");
		if(appcount(email,mbno) && c2.possible(hslc)>=1)
		{
			c1.save(detail);
			String appid=detail.getId();
			final String sub = "Confirmation message for the submission of the form for Engineering-Admissions 2022";
			final String body="Hi "+name+" "+"This is to inform you that you have submitted the form"+" "+ "View the colleges based on your cutoff"+" "+"Here is the password to unlock the pdf"+" "+appid;
			colleges(appid);
			e1.sendemail(email, sub, body);
			logger.info("Application Submitted SuccessFully");
			return "CHECK WITH YOUR MAIL!!!!";
		}
		else if(appcount(email,mbno) && c2.possible(hslc)<1)
		{
			logger.info("No Colleges available");
			return "No Colleges available for your HSLC cutoff";
		}
		logger.error("Application can be submitted inly once");  return "YOU CAN SUBMIT ONLY ONCE";
		}
		return "Enter a Valid Email and Mobile Number";}
		catch(Exception ex) {
			return "Email Does not Exists";
		}
	}
	@Override
	public boolean appcount(String email, String mbno) {
		int value=c2.appcount(email, mbno);
		if(value==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public List<ApplnModel> view()
	{
		return c1.findAll();
	}
	@Override
	public void colleges(String appid) 
	{
		logger.trace("Entering into colleges list");
		List<CollegeModel> list1= new ArrayList<CollegeModel>();
		ApplnModel record=c1.findById(appid).orElseThrow();
		Long hslc=record.getHslc();
		String department=record.getDepartment();
		logger.debug("checking");
		if(!c2.collegeList(hslc).isEmpty())
		{
			for(int i=0;i<c2.collegeList(hslc).size();i++)
			{
				int codecount=cc1.codechecker(c2.collegeList(hslc).get(i).getCode());
				if(codecount<600 && c2.Deptcount(department)<120)
				{
					list1.add(c2.collegeList(hslc).get(i));
				}
			}
		}logger.info("Generating PDF");
		pdf.generateCollegeList(list1, appid);
	}	
}
