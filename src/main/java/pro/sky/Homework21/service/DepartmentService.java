package pro.sky.Homework21.service;

import pro.sky.Homework21.exceptions.ExceptionEmptyList;
import pro.sky.Homework21.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {

   List<Employee> findDepartmentEmployees(Integer departmentNumber);


    Employee findMaximumSalaryInDepartment(Integer departmentNumber);


    Employee findMinimumSalaryInDepartment(Integer departmentNumber);


    List<List<Employee>> showAllEmployees();
}
