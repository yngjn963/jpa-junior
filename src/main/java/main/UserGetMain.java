package main;

import jakarta.persistence.*;
import jpabasic.reserve.domain.User;

import java.time.LocalDateTime;

public class UserGetMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            User user = entityManager.find(User.class, "user@user.com");
            if (user == null) {
                System.out.println("User 없음");
            }
            else {
                System.out.printf("User 있음: email=%s, name=%s, createDate=%s\n", user.getEmail(), user.getName(), user.getCreateDate());
            }

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
