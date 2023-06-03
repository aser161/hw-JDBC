package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private int cityId;
    @Column(name = "city_name")
    private String cityName;
//    @OneToOne
//    @Column(name = "employee")
//    private Employee employee;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public City(String city_name) {
        this.cityName = city_name;
//        this.employee = employee;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + cityId +
                ", city_name='" + cityName + '\'' +
                '}';
    }
}
