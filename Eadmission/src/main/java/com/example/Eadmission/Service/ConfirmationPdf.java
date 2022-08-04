package com.example.Eadmission.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
@Service
public class ConfirmationPdf {
	Logger logger = LoggerFactory.getLogger(ConfirmationPdf.class);
	public void successMessage(String name,String code,String collegename,String department,String appid)
	{
		logger.trace("Entering into the PDF class");
		Document document=new Document();
		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
		String content="Hi"+" "+name+" "+"This is to inform you that you have selected"+" "+code+" "+". "+" "+"("+collegename+")"+" "+"Department: "+department;
		String bar="Applicant Name :"+ name+" "+"Application ID :"+appid+" "+"College Name : "+collegename+" "+"CollegeCode : "+code+" "+"Department: "+department;
		 Paragraph item=new Paragraph(content,boldFont);
		 item.setSpacingBefore(50);
		 item.setSpacingAfter(50);
		 try {
			 	logger.debug("Checking if the pdf is generating");
				OutputStream file = new FileOutputStream(new File("Confirmation.pdf"));
			    PdfWriter writer=PdfWriter.getInstance(document, file);
			    document.open();
				Image img=Image.getInstance("AICTE.jpg");
				img.scaleToFit(50f, 50f);
				img.setAbsolutePosition(250f,PageSize.A4.getHeight() - img.getScaledHeight());
				BarcodeQRCode barcodeQrcode = new BarcodeQRCode(bar,1,1,null);
                Image qrcodeImage = barcodeQrcode.getImage();
                qrcodeImage.setAbsolutePosition(20, 500);
                qrcodeImage.scalePercent(100);
                qrcodeImage.setAbsolutePosition(250f,250f);
				document.add(img);
				document.add(item);
				document.add(qrcodeImage);
				document.close();
				file.close();
				logger.info("PDF SUCCESSFULL!!!");
	} 
		 catch (Exception ex) {
			 	logger.error(" PDF UNSUCCESSFULL");
				ex.printStackTrace();
			}
			    
	}
}

