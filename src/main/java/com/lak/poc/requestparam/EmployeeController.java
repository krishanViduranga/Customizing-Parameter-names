package com.lak.poc.requestparam;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping
    public Employee getEmployee(@RequestParam EmployeeSearchParam param) {

        System.out.println(param);
        Employee employee = new Employee();
        employee.setId(101);
        employee.setName("Kamala");
        return employee;

    }

}

