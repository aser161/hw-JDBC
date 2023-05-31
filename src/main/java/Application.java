import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();


        Employee employee1 = new Employee(
                    1, "Jim", "Lee", "m", 58, 4);
        employeeDAO.create(employee1);

        List<Employee>employees = employeeDAO.findAll();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
