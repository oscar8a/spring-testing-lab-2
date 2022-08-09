package com.testlab2.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ApplicationController.class)
class ApplicationControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

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

//    @Test
//    void getBitcoinData() {
//        CryptoPricingService cpservice = new CryptoPricingService();
//        BitcoinData bitcoinData = cpservice.getBitcoinData();
//
//        assertThat(bitcoinData).isNotNull();
//    }
}