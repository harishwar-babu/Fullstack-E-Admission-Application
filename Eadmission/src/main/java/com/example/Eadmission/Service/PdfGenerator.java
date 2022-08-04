package com.example.Eadmission.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.Eadmission.Model.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
@Service
public class PdfGenerator {
	Logger logger = LoggerFactory.getLogger(PdfGenerator.class);
	public void generateCollegeList(List<CollegeModel> colleges,String appid) {
		logger.trace("Entering into the pdf generator method");
		Document document = new Document();
		String content="Your Application ID is  ";
	    Paragraph item=new Paragraph(content+appid);
	    item.setSpacingBefore(50);
		item.setSpacingAfter(50);
		logger.debug("Checking with pdf generator method");
		try {
			OutputStream file = new FileOutputStream(new File("CollegeList.pdf"));
		    PdfWriter writer=PdfWriter.getInstance(document, file);
		    writer.setEncryption(appid.getBytes(),
	                appid.getBytes(), PdfWriter.ALLOW_PRINTING,
	                PdfWriter.ENCRYPTION_AES_128);
			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(80);
			table.setWidths(new int[] {4,4});

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("CollegeCode", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("CollegeName", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			
			for (CollegeModel college : colleges) {

				PdfPCell cell;
				cell = new PdfPCell(new Phrase(college.getCode(),headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(college.getName(),headFont));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			}
			document.open();
			Image img=Image.getInstance("AICTE.jpg");
			img.scaleToFit(50f, 50f);
			img.setAbsolutePosition(250f,PageSize.A4.getHeight() - img.getScaledHeight());
			document.add(img);
			document.add(item);
			document.add(table);
			logger.info("No isssues occured with this method");
			document.close();
			file.close();
		} catch (Exception ex) {
			logger.error("Error has occured");
			ex.printStackTrace();
		}
	}
}
