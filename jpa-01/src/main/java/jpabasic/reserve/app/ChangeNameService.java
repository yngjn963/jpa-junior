package jpabasic.reserve.app;

import jpabasic.reserve.domain.EMF;
import jpabasic.reserve.domain.User;

public class ChangeNameService {
    public void changeName(String email, String newName) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            User user = em.find(User.class, email);
            if (user == null) {
                throw new NoUserException();
            }

            user.changeName(newName);

            tx.commit();
        } catch (Exception ex) {
            tx.rollback();

            throw ex;
        } finally {
            em.close();
        }
    }
}
