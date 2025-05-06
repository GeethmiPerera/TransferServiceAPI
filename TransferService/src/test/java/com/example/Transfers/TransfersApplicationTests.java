package com.example.Transfers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.TransferService.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class TransfersApplicationTests {

	@Autowired
    private MockMvc mockMvc;

	@Test
    public void testSuccessfulTransfer() throws Exception {
        Transaction tx = new Transaction("123", "456", 100.0);
        mockMvc.perform(post("/api/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(tx)))
                .andExpect(status().isOk())
                .andExpect(content().string("Transfer successful."));
    }

    @Test
    public void testInsufficientBalance() throws Exception {
        Transaction tx = new Transaction("456", "789", 1000.0);
        mockMvc.perform(post("/api/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(tx)))
                .andExpect(status().isOk())
                .andExpect(content().string("Insufficient balance."));
    }
}
