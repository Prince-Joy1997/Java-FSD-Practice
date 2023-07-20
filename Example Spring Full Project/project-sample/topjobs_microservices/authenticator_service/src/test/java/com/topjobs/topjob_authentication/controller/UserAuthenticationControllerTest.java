package com.topjobs.topjob_authentication.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.topjobs.topjob_authentication.exception.DuplicateUsernameException;
import com.topjobs.topjob_authentication.exception.UsernameNotFoundException;
import com.topjobs.topjob_authentication.model.User;
import com.topjobs.topjob_authentication.service.UserService;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc

public class UserAuthenticationControllerTest {


    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private UserService service;

    
    private User user;

    @InjectMocks
    private UserController controller;

    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        user = new User();
        user.setUsername("testid");;
        user.setPassword("testpass");
        user.setRole("admin");
        
    }
    
    @Test
    public void testRegisterUserSuccess() throws Exception {

        Mockito.when(service.registerUser(user)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/registerUser").contentType(MediaType.APPLICATION_JSON).content(jsonToString(user)))
                .andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());

    }
    
    @Test
    public void testRegisterUserFailure() throws Exception {

		 Mockito.when(service.registerUser(any())).thenThrow(DuplicateUsernameException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/registerUser").contentType(MediaType.APPLICATION_JSON).content(jsonToString(user)))
                .andExpect(MockMvcResultMatchers.status().isConflict()).andDo(MockMvcResultHandlers.print());

    }
    
    @Test
    public void testLoginUser() throws Exception {


        String username = "testid";
        String password = "testpass";
        String role = "admin";


        Mockito.when(service.registerUser(user)).thenReturn(user);
        Mockito.when(service.login(username, password, role)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/authenticate").contentType(MediaType.APPLICATION_JSON).content(jsonToString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
    
    @Test
    public void testLoginUserFailure() throws Exception {
    String username = "testid";
    String password = "testpass";
    String role = "admin";


    Mockito.when(service.login(username, password, role)).thenThrow(UsernameNotFoundException.class);
    mockMvc.perform(MockMvcRequestBuilders.post("/user/authenticate").contentType(MediaType.APPLICATION_JSON).content(jsonToString(user)))
    .andExpect(MockMvcResultMatchers.status().isConflict()).andDo(MockMvcResultHandlers.print());



    }
    

    private static String jsonToString(final Object obj) throws JsonProcessingException {
        String result;
        try {
        	
        	ObjectMapper objmapper = new ObjectMapper();
        	objmapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        	objmapper.registerModule(new JavaTimeModule());
            result = objmapper.writeValueAsString(obj);
            
        } catch (JsonProcessingException e) {
            result = "Json processing error";
        }
        return result;
    }



	
}
