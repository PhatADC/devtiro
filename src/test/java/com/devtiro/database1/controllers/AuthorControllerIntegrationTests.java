package com.devtiro.database1.controllers;

import com.devtiro.database1.TestDataUtil;
import com.devtiro.database1.domain.entities.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tools.jackson.databind.ObjectMapper;


/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/13/2026, Tuesday
**/

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AuthorControllerIntegrationTests {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    public AuthorControllerIntegrationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testThatCreateAuthorSuccessfullyReturnsHTTP201Create() throws Exception{
        AuthorEntity testAuthorA = TestDataUtil.createTestAuthorA();
        testAuthorA.setId(null);
        String authorJson = objectMapper.writeValueAsString(testAuthorA);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testThatCreateAuthorSuccessfullyReturnsSaveAuthor() throws Exception{
        AuthorEntity testAuthorA = TestDataUtil.createTestAuthorA();
        testAuthorA.setId(null);
        String authorJson = objectMapper.writeValueAsString(testAuthorA);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.name").value("Phat")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.age").value(80)
        );
    }
}
