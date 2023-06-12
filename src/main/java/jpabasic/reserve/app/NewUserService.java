package jpabasic.reserve.app;

import jpabasic.reserve.domain.EMF;
import jpabasic.reserve.domain.User;

public class NewUserService {
    public void saveNewUser(User user) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(user);
            tx.commit();
        } catch(Exception ex) {
            tx.rollback();

            throw ex;
        } finally {
            em.close();
        }
    }
}
