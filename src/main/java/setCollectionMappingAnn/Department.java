package setCollectionMappingAnn;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name")
    private String name;

    @ElementCollection
    @CollectionTable(
        name = "employee_names_list",
        joinColumns = @JoinColumn(name = "department_id")
    )
    @OrderColumn(name = "employee_index")
    @Column(name = "employee_name")
    private Set<String> employeeNames;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(Set<String> employeeNames) {
        this.employeeNames = employeeNames;
    }
}
