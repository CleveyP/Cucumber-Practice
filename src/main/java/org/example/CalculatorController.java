package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*") // allow all origins for testing
public class CalculatorController {

    Calculator calculator = new Calculator();

    @GetMapping("/calc")
    public String calculate(
            @RequestParam(name="num1") int num1,
            @RequestParam(name="num2") int num2,
            @RequestParam(name="op") String op
    ) {

        try {
            int result;
            switch(op.toLowerCase()) {
                case "add":
                    result = calculator.add(num1, num2);
                    break;
                case "subtract":
                    result = calculator.subtract(num1, num2);
                    break;
                case "multiply":
                    result = calculator.multiply(num1, num2);
                    break;
                case "divide":
                    result = calculator.divide(num1, num2);
                    break;
                default:
                    return "Unknown operation";
            }
            return String.valueOf(result);
        } catch (ArithmeticException e) {
            return "Arithmetic Error: " + e.getMessage();
        }
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
