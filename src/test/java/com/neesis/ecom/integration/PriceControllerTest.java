package com.neesis.ecom.integration;

import com.neesis.ecom.infrastructure.config.EcomApplication;
import com.neesis.ecom.integration.configuration.IntegrationTestDatasource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        classes = {IntegrationTestDatasource.class, EcomApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@SqlGroup({
        @Sql(scripts = "/db/populate.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        @Sql(scripts = "/db/isolate.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
})
public class PriceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_price_when_get_price_having_system_date_14_06_and_hour_10_00() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices/get?brandId=1&productId=35455&systemDate=2020-06-14T10:00:00.000Z"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.5));
    }

    @Test
    public void should_return_price_when_get_price_having_system_date_14_06_and_hour_16_00() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices/get?brandId=1&productId=35455&systemDate=2020-06-14T16:00:00.000Z"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    public void should_return_price_when_get_price_having_system_date_14_06_and_hour_21_00() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices/get?brandId=1&productId=35455&systemDate=2020-06-14T21:00:00.000Z"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.5));
    }

    @Test
    public void should_return_price_when_get_price_having_system_date_15_06_and_hour_10_00() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices/get?brandId=1&productId=35455&systemDate=2020-06-15T10:00:00.000Z"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.5));
    }

    @Test
    public void should_return_price_when_get_price_having_system_date_16_06_and_hour_21_00() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices/get?brandId=1&productId=35455&systemDate=2020-06-16T21:00:00.000Z"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95));
    }

}
