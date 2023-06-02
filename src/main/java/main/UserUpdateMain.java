package main;

import jpabasic.reserve.domain.User;

import java.time.LocalDateTime;

public class UserUpdateMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            User user = new User("user@user.com", "user", LocalDateTime.now());

            entityManager.persist(user);

            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();

            transaction.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}
