package dao.impl;

import Utils.HibernateSessionFactoryUtil;
import dao.CityDAO;
import model.City;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public void create(City city) {
        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().get(City.class, id);
    }

    @Override
    public List<City> findAll() {
        return (List<City>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("FROM City").list();
    }

    @Override
    public void update(City city) {
        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void delete(City city) {
        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
