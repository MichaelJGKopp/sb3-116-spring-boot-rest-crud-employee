package com.luv2code.springboot.demo.service;

import com.luv2code.springboot.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    // crud operations
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(Integer id);
}
