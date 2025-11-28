package ma.fstt.atelier7_backend.security;

import ma.fstt.atelier7_backend.entites.Employee;
import ma.fstt.atelier7_backend.repositories.EmployeeRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService implements UserDetailsService {

    private final EmployeeRepository repository;

    public EmployeeDetailsService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee emp = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(emp.getEmail())
                .password(emp.getPassword())
                .roles("USER")
                .build();
    }
}
