package dao.impl;

import Utils.HibernateSessionFactoryUtil;
import dao.EmployeeDAO;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().get(Employee.class,id);
    }

    @Override
    public List<Employee> findAll(){
        return (List<Employee>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("FROM Employee").list();
    }

    @Override
    public void update(Employee employee){

        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void delete(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
