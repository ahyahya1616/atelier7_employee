package ma.fstt.atelier7_backend.services;

import ma.fstt.atelier7_backend.entites.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Long id);
    Employee create(Employee employee);
    Employee update(Long id, Employee employee);
    void delete(Long id);
}
