package dao.impl;

import dao.EmployeeDAO;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        try(PreparedStatement statement  = connection.prepareStatement(
                "INSERT INTO employee(first_name,last_name,gender,age,city_id) " +
                        "VALUES ((?),(?),(?),(?),(?))"
        )){
            statement.setString(1,employee.getFirst_name());
            statement.setString(2,employee.getLast_name());
            statement.setString(3,employee.getGender());
            statement.setInt(4,employee.getAge());
            statement.setInt(5,employee.getCity_id());

            statement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Employee findById(int id){
        Employee employee = new Employee();
        try(PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee WHERE id = (?)"
        )){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            employee.setId(resultSet.getInt("id"));
            employee.setFirst_name(resultSet.getString("first_name"));
            employee.setLast_name(resultSet.getString("last_name"));
            employee.setGender(resultSet.getString("gender"));
            employee.setAge(resultSet.getInt("age"));
            employee.setCity_id(resultSet.getInt("city_id"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employee;
    }

    @Override
    public List<Employee> findAll(){
        List<Employee> employeeList = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee"
        )){
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = Integer.parseInt(resultSet.getString("age"));
                int city_id = Integer.parseInt(resultSet.getString("city_id"));
                Employee employee = new Employee(id, first_name, last_name, gender, age, city_id);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public void updateCity_idById(int id, int city_id){

        try(PreparedStatement statement = connection.prepareStatement(
                "UPDATE employee SET city_id = (?) WHERE id = (?)"
        )){
            statement.setInt(6,city_id);
            statement.setInt(1,id);

            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {

        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM employee WHERE id = (?)"
        )) {
            statement.setInt(1, id);
            statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
