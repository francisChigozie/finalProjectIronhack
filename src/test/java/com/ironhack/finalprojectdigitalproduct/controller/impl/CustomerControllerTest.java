package com.ironhack.finalprojectdigitalproduct.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.finalprojectdigitalproduct.model.user.User;
import com.ironhack.finalprojectdigitalproduct.security.SecurityConfig;
import com.ironhack.finalprojectdigitalproduct.service.impl.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerControllerTest.class)
@Import(SecurityConfig.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;


    @Autowired
    private UserServiceImpl userService;

    @Autowired private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

   @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        User user3 = new User("Benson", "user3", "bensonn@gmail.com",
                "12345","10-09-2005","Male","1000", new ArrayList<>());
        User user4 = new User("Jackson", "admin2", "admin2@gmail.com",
                "654321","3-11-2014","Female","500", new ArrayList<>());
        userService.saveUser(user3);
        userService.saveUser(user4);
    }

    @AfterEach
    void tearDown() {
        userService.deleteAll();
    }

    @Test
    @WithMockUser(username = "withMockUser",password = "pass",roles = "ADMIN")
    void withMockUser() throws Exception {
        User user5 = new User("Jackson", "admin2", "admin2@gmail.com",
                "654321","3-11-2014","Female","500", new ArrayList<>());

        String body = objectMapper.writeValueAsString(user5);
        MvcResult mvcResult = mockMvc.perform(post("/api/v1/auth/customer")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("John"));
    }

    @Test
    @WithMockUser(username = "withMockUser",password = "pass",roles = "ADMIN")
    void getAll_Valid_AllCourses() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/customers"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Benson"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Jackson"));
    }

}