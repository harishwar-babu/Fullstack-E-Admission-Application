package com.example.Eadmission.Service;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;
@Service
public class EmailAttachment {
	Logger logger = LoggerFactory.getLogger(EmailAttachment.class);
	@Autowired private JavaMailSender javamail;
	public void sendemail(String email,String sub,String body)  {
		logger.trace("Entering into the email attachment class");		
    Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true");
    logger.debug("Checking with the Email Attachment class");
    try {
    MimeMessage mimeMessage = javamail.createMimeMessage();
    MimeMessageHelper mimeMessageHelper
            = new MimeMessageHelper(mimeMessage, true);

   String attachment="C:\\Users\\91995\\Downloads\\Eadmission\\CollegeList.pdf";
    mimeMessageHelper.setFrom("hbconnex2000@gmail.com");
    mimeMessageHelper.setTo(email);
    mimeMessageHelper.setText(body);
    mimeMessageHelper.setSubject(sub);

    FileSystemResource fileSystem
            = new FileSystemResource(new File(attachment));

    mimeMessageHelper.addAttachment(fileSystem.getFilename(),
            fileSystem);

    javamail.send(mimeMessage);
    logger.info("Success No problems with this method");
    }
    catch(MessagingException e)
    {
    	logger.error("Error has Occured!!!");
    	e.printStackTrace();
    }
	}
}