package ma.fstt.atelier7_backend.services.impl;

import ma.fstt.atelier7_backend.entites.Employee;
import ma.fstt.atelier7_backend.repositories.EmployeeRepository;
import ma.fstt.atelier7_backend.services.EmployeeService;
import ma.fstt.atelier7_backend.exceptions.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final PasswordEncoder encoder;

    public EmployeeServiceImpl(EmployeeRepository repository , PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }


    @Override
    public Employee create(Employee employee) {
        if (repository.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Email already used");
        }

        employee.setPassword(encoder.encode(employee.getPassword()));

        return repository.save(employee);
    }


    @Override
    public Employee update(Long id, Employee employee) {
        Employee existing = findById(id);
        existing.setFirstName(employee.getFirstName());
        existing.setLastName(employee.getLastName());
        existing.setEmail(employee.getEmail());
        existing.setSalary(employee.getSalary());
        if (employee.getPassword() != null) {
            existing.setPassword(encoder.encode(employee.getPassword()));
        }

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Employee existing = findById(id);
        repository.delete(existing);
    }
}
