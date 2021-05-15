package com.sonarqube.sonarqubeexample;

import com.sonarqube.sonarqubeexample.controller.ExampleController;
import com.sonarqube.sonarqubeexample.model.ExampleResult;
import com.sonarqube.sonarqubeexample.service.ExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ExampleController.class)
class SonarqubeExampleApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExampleService exampleService;

    @Test
    void contextLoads() {
    }

    @Test
    void testExampleController() throws Exception {
        Long id = 1L;
        given(exampleService.getResult(id)).willReturn(new ExampleResult(id, "id"));

        this.mockMvc.perform(get("/api/result/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("id")));
    }

    @Test
    void testExampleService() throws Exception {
        ExampleService exampleService = new ExampleService();
        ExampleResult serviceResult = exampleService.getResult(1L);
        assertEquals("id", serviceResult.getName());
        assertEquals(1L, serviceResult.getId());
    }


}
