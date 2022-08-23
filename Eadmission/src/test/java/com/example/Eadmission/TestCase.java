package com.example.Eadmission;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.example.Eadmission.Model.*;
import com.example.Eadmission.Service.*;
import com.example.Eadmission.Controller.*;
import com.example.Eadmission.DAO.*;
import org.modelmapper.ModelMapper;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TestCase {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private CollegeServiceImpl service;
	
	@Mock
	private CollegeRepo repo;
	
	@Mock 
	private ModelMapper mapper;
	
	@InjectMocks
	CollegeController cc;
	
	@BeforeEach
	public void setUp()
	{	  
		mockMvc=MockMvcBuilders.standaloneSetup(cc).build();
	} 
	ObjectMapper objectmapper=new ObjectMapper();
	ObjectWriter obj=objectmapper.writer();
	
	@Test
	void getCollegById() throws Exception
	{
		String id ="CEA202218970";
		final CollegeModel model = new CollegeModel(id,"Anna University","Chennai",(long)200,(long)197);
		given(service.getClgbyId(id)).willReturn(model);
		this.mockMvc.perform(get("/ViewClg/{id}",id))
		.andExpect(status().is(200))
		.andExpect(jsonPath("$.name").value(model.getName()));
	}
	
	@Test
	
	void deleteCol() throws Exception
	{
		String id ="CEA202218970";
		final String college ="Deleted Successfully!!!";
		given(service.deleteClgs(id)).willReturn(college);
		this.mockMvc.perform(delete("/deleteClg/{id}",id))
		.andExpect(status().is(200));
	}
	
	@Test
	
	void addcollege() throws Exception
	{
		CollegeModel college = new CollegeModel("UEA","123","1234",(long)190,(long)198);
		String json = obj.writeValueAsString(college);
		final String result = "Added Successfully";
		
		given(service.addClg(college)).willReturn(result);
		this.mockMvc.perform(post("/AddClg")
		.contentType(MediaType.APPLICATION_JSON)
		.content(json))
		.andExpect(status().is(200))
		.andExpect(content().string(result));
		
		given(service.addClg(college)).willReturn("Already Exists");
		this.mockMvc.perform(post("/AddClg")
		.contentType(MediaType.APPLICATION_JSON)
		.content(json))
		.andExpect(status().is(200))
		.andExpect(content().string("Already Exists"));
	}
}