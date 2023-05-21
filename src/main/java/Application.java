import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "0000";
        final String url = "jdbc:postgresql://localhost:5433/postgres";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

//            Employee employee1 = new Employee(
//                    1, "Jim", "Lee", "m", 58, 4);
//            employeeDAO.create(employee1);

            List<Employee>employees = employeeDAO.findAll();

            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }

//        try (final Connection connection = DriverManager.getConnection(url, user, password);
//             PreparedStatement statement = connection.prepareStatement(
//                     "SELECT * FROM employee WHERE id = (?)"
//             )) {
//            statement.setInt(1, 2);
//            final ResultSet resultSet = statement.executeQuery();
//
//            resultSet.next();
//            String nameOfEmployee = "Name: " + resultSet.getString("first_name");
//            String familyOfEmployee = "Family: " + resultSet.getString("last_name");
//            String genderOfEmployee = "Gender: " + resultSet.getString("gender");
//            int ageOfEmployee = resultSet.getInt(5);
//            int cityOfEmployee = resultSet.getInt(6);
//
//            System.out.println(nameOfEmployee + " " + familyOfEmployee);
//            System.out.println(genderOfEmployee);
//            System.out.println(ageOfEmployee + " year");
//            System.out.println(cityOfEmployee);
//        }


    }
}
