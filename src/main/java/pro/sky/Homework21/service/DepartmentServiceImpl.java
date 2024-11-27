package pro.sky.Homework21.service;

import org.springframework.stereotype.Service;
import pro.sky.Homework21.exceptions.ExceptionEmptyList;
import pro.sky.Homework21.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
public EmployeeService skyPro;

    @Override
    public List<Employee> findDepartmentEmployees(Integer departmentNumber) {
        List<Employee> departmentEmployees = new ArrayList<>();
        skyPro.getEmployees().forEach(employee -> {
            if (employee.getDepartmentNumber() == departmentNumber) {
                departmentEmployees.add(employee);
            }
        });
        if (!departmentEmployees.isEmpty()) {
            return departmentEmployees;
        }
        throw new ExceptionEmptyList();
    }

    @Override
    public Employee findMaximumSalaryInDepartment(Integer departmentNumber) {
        Optional<Employee> employee = findDepartmentEmployees(departmentNumber).stream().
                max(Comparator.comparingInt(Employee::getSalaryAmount));
        return employee.get();
    }

    @Override
    public Employee findMinimumSalaryInDepartment(Integer departmentNumber) {
        Optional<Employee> employee = findDepartmentEmployees(departmentNumber).stream().
                min(Comparator.comparingInt(Employee::getSalaryAmount));
        return employee.get();
    }

    @Override
    public List<List<Employee>> showAllEmployees() {
        List<List<Employee>> allEmployees = new ArrayList<>();
        skyPro.getDepartments().forEach(department -> {
            allEmployees.add(findDepartmentEmployees(department));
        });
        return allEmployees;
    }
}
