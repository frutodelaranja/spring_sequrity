package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Query;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {
        Query query=sessionFactory.getCurrentSession().createQuery("from User where username= :name").setParameter("name", username);
        return (User) query.getSingleResult();
    }
}
