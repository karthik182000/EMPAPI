package testing;

import org.applcation.Service.EmployeeService;
import org.applcation.entity.Employee;
import org.applcation.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testGetEmployeeById() {
        MockitoAnnotations.initMocks(this);
        Long id = 1L;
        Employee mockEmployee = new Employee(id, "Ramesh Kumar", 60000, "IT");
        when(employeeRepository.findById(id)).thenReturn(Optional.of(mockEmployee));

        Employee result = employeeService.getEmployeeById(id);


        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Ramesh Kumar");
        assertThat(result.getSalary()).isEqualTo(60000);
        assertThat(result.getDepartment()).isEqualTo("IT");
    }
}

