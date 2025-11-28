package ma.fstt.atelier7_backend.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le prénom est requis")
    @Size(max = 100)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Le nom est requis")
    @Size(max = 100)
    @Column(name = "last_name", nullable = false)
    private String lastName;



    @Email(message = "Email invalide")
    @NotBlank(message = "L'email est requis")
    @Size(max = 150)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Le mot de passe est requis")
    @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "Le salaire est requis")
    @PositiveOrZero(message = "Le salaire doit être positif ou nul")
    @Column(name = "salary", nullable = false)
    private Double salary;
}
