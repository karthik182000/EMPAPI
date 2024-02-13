package org.applcation.Service;

import org.applcation.compare.EmployeeComparator;
import org.applcation.entity.Employee;
import org.applcation.exception.EmployeeNotFoundException;
import org.applcation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
    public List<Employee> getAllEmployeesSortedByName() {
        List<Employee> employees = employeeRepository.findAll();
        Collections.sort(employees);
        return employees;
    }

    public List<Employee> getAllEmployeesSortedBySalary() {
        List<Employee> employees = employeeRepository.findAll();
        employees.sort(new EmployeeComparator());
        return employees;
    }

}
