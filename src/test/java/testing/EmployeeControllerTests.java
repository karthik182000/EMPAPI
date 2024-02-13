package testing;

import org.applcation.Service.EmployeeService;
import org.applcation.controller.EmployeeController;
import org.applcation.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTests {
    @InjectMocks
    EmployeeController employeeController;
    @Mock
    private EmployeeService employeeService;

    @Test
    public void getTest(){
        Employee savedEmployee = new Employee(1L, "Ramesh Kumar", 60000, "IT");
        when(employeeService.getEmployeeById(Mockito.any())).thenReturn(savedEmployee);
        assertNotNull(employeeController.getEmployeeById(1L));
    }



}
