package hotel_mgnt_DAO;

import hotel_mgnt_entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hotel_mgnt_util.HibernateUtil;
import java.util.List;

public class UserDAO {
    public void saveUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public User getUserById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        }
    }

    // New method to get all users
    public List<User> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).list();
        }
    }
}