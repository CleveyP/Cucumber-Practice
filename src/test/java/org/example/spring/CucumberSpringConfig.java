package org.example.spring;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
//@ComponentScan(basePackages = {"org.example.steps"})
public class CucumberSpringConfig {

}
