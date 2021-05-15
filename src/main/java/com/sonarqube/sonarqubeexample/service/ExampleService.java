package com.sonarqube.sonarqubeexample.service;

import com.sonarqube.sonarqubeexample.model.ExampleResult;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    public ExampleResult getResult(Long id) {
        return new ExampleResult(id, id.toString() + "-" + "name");
    }

}
