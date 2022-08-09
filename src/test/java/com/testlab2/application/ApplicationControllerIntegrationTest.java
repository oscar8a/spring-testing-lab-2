package com.testlab2.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ApplicationController.class)
class ApplicationControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CryptoService cpservice;

    @Test
    void shouldGreetDefault() throws Exception {
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello Oscar")));
    }

    @Test
    void shouldGreetByName() throws Exception {
        String greetingName = "Ferguson";
        mockMvc.perform(get("/hello").param("targetName", greetingName))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello Ferguson")));
    }

    @Test
    void getBitcoinData() throws Exception {
        mockMvc.perform(get("/getBitcoinPrice"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("The Price of Bitcoin is: " + cpservice.getCoinPrice())));
    }
}