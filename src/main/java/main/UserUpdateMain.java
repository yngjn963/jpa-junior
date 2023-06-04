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
            logger.info("EntityManager.persist 호출함");

            transaction.commit();
            logger.info("EntityTransaction.commit 호출함"); // 식별자를 직접 설정하는 경우 commit 시점에 insert를 실행.
            // *id 식별자를 생성하는 방식에 따라 persist 시점에 insert를 실행하기도 함.
        } catch (Exception ex) {
            ex.printStackTrace();

            transaction.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}
