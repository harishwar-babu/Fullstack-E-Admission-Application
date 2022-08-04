package com.example.Eadmission;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.example.Eadmission.Model.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser(username = "hfc123", password = "HBC@1234a")
class TestCase {
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private MockMvc mockMvc;
	ObjectMapper objectmapper=new ObjectMapper();
	ObjectWriter obj=objectmapper.writer();
	@Before
	public void setUp()
	{
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	@Test
	
	void loginTest() throws Exception
	{
		AuthRequest auth= new AuthRequest();
		auth.setUsername("hfc123");
		auth.setPassword("HBC@1234a");
		String jsonvalue=obj.writeValueAsString(auth);		
		MockHttpServletRequestBuilder mvc=MockMvcRequestBuilders.post("/authenticate")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonvalue);
			mockMvc.perform(mvc)
			.andExpect(status().isOk());
	}
	@Test
	void AddCollege() throws Exception
	{
		CollegeModel college = new CollegeModel();
		college.setName("Eshwari Engineering College");
		college.setDistrict("Chennai");
		college.setMincutoff((long) 164);
		college.setMaxcutoff((long) 178);
		String jsonvalue=obj.writeValueAsString(college);		
		MockHttpServletRequestBuilder mvc=MockMvcRequestBuilders.post("/AddClg")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonvalue);
			mockMvc.perform(mvc)
			.andExpect(status().isOk())
			.andExpect(content().string("Already Exists"));
	}
	
	@Test 
	void SubmitApplication() throws Exception
	{
		ApplnModel application = new ApplnModel();
		application.setName("Harishwara");
		application.setEmail("hbapplication2000@gmail.com");
		application.setMbno("12345678910");
		application.setDob(null);
		application.setSslc((long) 97);
		application.setHslc((long) 170);
		String jsonvalue=obj.writeValueAsString(application);		
		MockHttpServletRequestBuilder mvc=MockMvcRequestBuilders.post("/submit")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonvalue);
			mockMvc.perform(mvc)
			.andExpect(status().isOk())
			.andExpect(content().string("CHECK WITH YOUR MAIL!!!!"));
			// Again Submitting the same Application
			ApplnModel application1 = new ApplnModel();
			application1.setName("Harishwara");
			application1.setEmail("hbapplication2000@gmail.com");
			application1.setMbno("12345678910");
			application1.setDob(null);
			application1.setSslc((long) 97);
			application1.setHslc((long) 170);
			String jsonvalue1=obj.writeValueAsString(application1);		
			MockHttpServletRequestBuilder mvc1=MockMvcRequestBuilders.post("/submit")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.accept(MediaType.APPLICATION_JSON_VALUE)
					.content(jsonvalue1);
				mockMvc.perform(mvc1)
				.andExpect(status().isOk())
				.andExpect(content().string("YOU CAN SUBMIT ONLY ONCE"));
	}
	
	@Test 
	public void Confirm() throws Exception
	{
		ConfirmationModel cnfrm=new ConfirmationModel();
		cnfrm.setAppid("UEA202213323");
		cnfrm.setCode("CEA202219350");
		String jsonvalue=obj.writeValueAsString(cnfrm);		
		MockHttpServletRequestBuilder mvc=MockMvcRequestBuilders.post("/confirm")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonvalue);
			mockMvc.perform(mvc)
			.andExpect(status().isOk())
			.andExpect(content().string("Check with your mail"));
		ConfirmationModel cnfrm1=new ConfirmationModel();
		cnfrm1.setAppid("UEA202213323");
		cnfrm1.setCode("CEA202219350");
		String jsonvalue1=obj.writeValueAsString(cnfrm1);		
		MockHttpServletRequestBuilder mvc1=MockMvcRequestBuilders.post("/confirm")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.accept(MediaType.APPLICATION_JSON_VALUE)
					.content(jsonvalue1);
			mockMvc.perform(mvc1)
				.andExpect(status().isOk())
				.andExpect(content().string("You have already Submitted this form or your Application ID may be wrong or the Entered College Id may be Wrong"));
			ConfirmationModel cnfrm2=new ConfirmationModel();
			cnfrm2.setAppid("UEA202213324");
			cnfrm2.setCode("CEA202219350");
			String jsonvalue2=obj.writeValueAsString(cnfrm2);		
			MockHttpServletRequestBuilder mvc2=MockMvcRequestBuilders.post("/confirm")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.accept(MediaType.APPLICATION_JSON_VALUE)
						.content(jsonvalue2);
				mockMvc.perform(mvc2)
					.andExpect(status().isOk())
					.andExpect(content().string("You have already Submitted this form or your Application ID may be wrong or the Entered College Id may be Wrong"));
				
				ConfirmationModel cnfrm3=new ConfirmationModel();
				cnfrm2.setAppid("UEA202213323");
				cnfrm2.setCode("CEA202219351");
				String jsonvalue3=obj.writeValueAsString(cnfrm3);		
				MockHttpServletRequestBuilder mvc3=MockMvcRequestBuilders.post("/confirm")
							.contentType(MediaType.APPLICATION_JSON_VALUE)
							.accept(MediaType.APPLICATION_JSON_VALUE)
							.content(jsonvalue3);
					mockMvc.perform(mvc3)
						.andExpect(status().isOk())
						.andExpect(content().string("You have already Submitted this form or your Application ID may be wrong or the Entered College Id may be Wrong"));
					ConfirmationModel cnfrm4=new ConfirmationModel();
					cnfrm4.setAppid("UEA202213324");
					cnfrm4.setCode("CEA202219353");
					String jsonvalue4=obj.writeValueAsString(cnfrm4);		
					MockHttpServletRequestBuilder mvc4=MockMvcRequestBuilders.post("/confirm")
								.contentType(MediaType.APPLICATION_JSON_VALUE)
								.accept(MediaType.APPLICATION_JSON_VALUE)
								.content(jsonvalue4);
						mockMvc.perform(mvc4)
							.andExpect(status().isOk())
							.andExpect(content().string("You have already Submitted this form or your Application ID may be wrong or the Entered College Id may be Wrong"));
	}
	
	@Test
	
	public void viewcollegebyidandviewusers() throws Exception
	{
		// View College By id
		MockHttpServletRequestBuilder mvc=MockMvcRequestBuilders
				.get("/ViewClg/CEA202219350");
			mockMvc.perform(mvc)
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("$.name").value("Kanyakumari Institute Of Technology"))
            .andDo(MockMvcResultHandlers.print());
		//View users
		MockHttpServletRequestBuilder mvc1=MockMvcRequestBuilders
				.get("/viewusers");
				mockMvc.perform(mvc1)
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test 
	
	public void deleteandupdatecollegebyid() throws Exception
	{
		//Delete College By ID
		MockHttpServletRequestBuilder mvc=MockMvcRequestBuilders
				.delete("/deleteClg/CEA202214593");
			mockMvc.perform(mvc)
			.andExpect(status().isOk())
			.andExpect(content().string("Deleted Successfully!!!"));
		// Update College By ID
		CollegeModel college = new CollegeModel();
		college.setName("Sairam Institute Of Technology");
		college.setDistrict("Kanchipuram");
		college.setMincutoff((long) 175);
		college.setMaxcutoff((long) 187);
		String jsonvalue=obj.writeValueAsString(college);
		MockHttpServletRequestBuilder mvc1=MockMvcRequestBuilders.put("/Clgupdate/CEA202219350")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonvalue);
		mockMvc.perform(mvc1)
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andDo(MockMvcResultHandlers.print());
	}
}