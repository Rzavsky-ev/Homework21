package pro.sky.Homework21.service;

import pro.sky.Homework21.model.Employee;

import java.util.*;

public interface EmployeeService {
    void addEmployee(String firstName, String lastName, Integer departmentNumber, Integer salaryAmount);

    void removeEmployee(String firstName, String lastNam);


    List<Employee> findDepartmentEmployees(Integer departmentNumber);


    Employee findMaximumSalaryInDepartment(Integer departmentNumber);


    Employee findMinimumSalaryInDepartment(Integer departmentNumber);


    List<List<Employee>> showAllEmployees();

}
