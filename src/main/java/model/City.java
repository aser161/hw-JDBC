package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int city_id;
    @Column(name = "city_name")
    private String city_name;
//    @OneToOne
//    @Column(name = "employee")
//    private Employee employee;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public City(String city_name) {
        this.city_name = city_name;
//        this.employee = employee;
    }
}
