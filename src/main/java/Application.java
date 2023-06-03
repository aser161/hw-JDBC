import dao.CityDAO;
import dao.EmployeeDAO;
import dao.impl.CityDAOImpl;
import dao.impl.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CityDAO cityDAO = new CityDAOImpl();

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();


        Employee employee1 = new Employee(
                1, "Jim", "Lee", "m", 58, cityDAO.findById(4));
        employeeDAO.create(employee1);

        List<Employee> employees = employeeDAO.findAll();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
        cityDAO.create(new City("Moscow"));
        City byId = cityDAO.findById(1);
        System.out.println(byId);
        System.out.println(employeeDAO.findById(2));
    }
}
