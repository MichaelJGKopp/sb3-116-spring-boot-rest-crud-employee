package com.luv2code.springboot.demo.rest;

import com.luv2code.springboot.demo.dao.EmployeeDAO;
import com.luv2code.springboot.demo.entity.Employee;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private EmployeeDAO employeeDAO;
//    private List<Employee> employees;

//    @PostConstruct
//    public void loadData() {
//
//        employees = employeeDAO.readAll();
//    }

    public RestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @PostMapping("/employees")
    void createEmployee(@RequestBody Employee employee) {

        employeeDAO.create(employee);
    }

    @GetMapping("/employees")
    List<Employee> getEmployees() {

        return employeeDAO.readAll();
    }

    @GetMapping("/employees/{employeeId}")
    Employee getEmployee(@PathVariable int employeeId) {

        return employeeDAO.readById(employeeId);
    }

    @PutMapping("/employees")
    void updateEmployee(@RequestBody Employee employee) {

        employeeDAO.update(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    void deleteEmployee(@PathVariable int employeeId) {

        employeeDAO.delete(employeeId);
    }
}
