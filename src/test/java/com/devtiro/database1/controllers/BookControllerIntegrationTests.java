package com.devtiro.database1.controllers;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author : User
 * @mailto : dothanhphat2005@gmail.com
 * @created : 10/18/2026, Sunday
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class BookControllerIntegrationTests {

    private MockMvc mockMvc;

    @Autowired
    public BookControllerIntegrationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }
}
