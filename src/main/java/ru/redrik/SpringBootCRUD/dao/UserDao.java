package ru.redrik.SpringBootCRUD.dao;

import org.springframework.stereotype.Repository;
import ru.redrik.SpringBootCRUD.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDao implements Dao {
    @PersistenceContext
    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = entityManager.createQuery("FROM User", User.class).getResultList();
        return userList;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(Long id, User user) {
        User userToUpdate = entityManager.find(User.class, id);
        entityManager.detach(userToUpdate);
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        entityManager.merge(userToUpdate);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

}
