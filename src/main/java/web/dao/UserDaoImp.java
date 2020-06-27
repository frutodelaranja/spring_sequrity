package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User findById(Long id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
    }

    @Override
    public void delete(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void editUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User findByUsername(String username) {
        Query query=sessionFactory.getCurrentSession()
                .createQuery("from User where username = :name")
                .setParameter("name", username);
        return (User) query.getSingleResult();
    }
}
