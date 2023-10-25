package thelameres.bobday.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thelameres.bobday.responses.EmployeeControllerResponse;
import thelameres.bobday.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeServiceProxy) {
        this.employeeService = employeeServiceProxy;
    }

    @GetMapping
    public EmployeeControllerResponse getEmployee() {
        return employeeService.getEmployees();
    }
}

