package pro.sky.Homework21.service;

import org.springframework.stereotype.Service;
import pro.sky.Homework21.exceptions.*;
import pro.sky.Homework21.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private final int maxEmpoloyee = 20;
    private List<Integer> departments = List.of(1, 2, 3, 4, 5);

    @Override
    public void addEmployee(String firstName, String lastName, Integer departmentNumber, Integer salaryAmount) {
        if (firstName != null && lastName != null && departmentNumber != null && salaryAmount != null) {
            Employee employee = new Employee(firstName, lastName, departmentNumber, salaryAmount);
            if (employees.size() >= maxEmpoloyee) {
                throw new TheListIsFull();
            } else if (employees.contains(employee)) {
                throw new EmployeeAlreadyAdded();
            } else {
                employees.add(employee);
            }
        }
        throw new ExceptionMissingData();
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            if (!employees.isEmpty()) {
                employees.forEach(employee -> {
                    if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                        employees.remove(employee);
                    } else {
                        throw new EmployeeNotFoundException();
                    }
                });
            } else {
                throw new ExceptionEmptyList();
            }
        }
        throw new ExceptionMissingData();
    }

    @Override
    public List<Employee> findDepartmentEmployees(Integer departmentNumber) {
        List<Employee> departmentEmployees = new ArrayList<>();
        employees.forEach(employee -> {
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
        departments.forEach(department -> {
            allEmployees.add(findDepartmentEmployees(department));
        });
        return allEmployees;
    }
}
