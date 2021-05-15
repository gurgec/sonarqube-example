package com.sonarqube.sonarqubeexample.controller;

import com.sonarqube.sonarqubeexample.model.ExampleResult;
import com.sonarqube.sonarqubeexample.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/api/result/{id}")
    ExampleResult getResult(@PathVariable Long id){
        return exampleService.getResult(id);
    }

}
