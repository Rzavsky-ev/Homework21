package pro.sky.Homework21.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Homework21.model.Employee;
import pro.sky.Homework21.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee/add")
    public void add(@RequestParam(required = false) String firstName,

                    @RequestParam(required = false) String lastName, @RequestParam(required = false) Integer departmentNumber,
                    @RequestParam(required = false) Integer salaryAmount) {
        employeeService.addEmployee(firstName, lastName, departmentNumber, salaryAmount);
    }

    @GetMapping(path = "/employee/remove")
    public void remove(@RequestParam(required = false) String firstName,
                       @RequestParam(required = false) String lastName) {
        employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/departments/max-salary?departmentId=5")
    public Employee findMaximumSalaryInDepartment(@RequestParam Integer departmentId) {
        return employeeService.findMaximumSalaryInDepartment(departmentId);
    }

    @GetMapping(path = "/departments/min-salary?departmentId=5")
    public Employee findMinimumSalaryInDepartment(@RequestParam Integer departmentId) {
        return employeeService.findMinimumSalaryInDepartment(departmentId);
    }

    @GetMapping(path = "/departments/all?departmentId=5")
    public List<Employee> findDepartmentEmployees(@RequestParam Integer departmentId) {
        return employeeService.findDepartmentEmployees(departmentId);
    }

    @GetMapping(path = "/departments/all")
    public List<List<Employee>> showAllEmployees() {
        return employeeService.showAllEmployees();
    }
}
