package thelameres.bobday.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeControllerTest {

    private static final Logger log = LoggerFactory.getLogger(EmployeeControllerTest.class);

    @Autowired
    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
    }

    @Test
    void test() throws Exception {
      mockMvc.perform(get("/api/v1/employee"))
              .andExpect(jsonPath("success").value(true))
              .andExpect(status().is(200))
              .andDo(print());
    }
}