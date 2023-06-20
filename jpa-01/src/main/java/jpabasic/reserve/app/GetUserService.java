package jpabasic.reserve.app;

import jpabasic.reserve.domain.EMF;
import jpabasic.reserve.domain.User;

public class GetUserService {
    public User getUser(String email) {
        EntityManager em = EMF.createEntityManager();

        try {
            User user = em.find(User.class, email);
            if (user == null) {
                throw new NoUserException();
            }

            return user;
        } finally {
            em.close();
        }
    }
    /*
    엔티티 타입, ID 타입이 맞아야 한다.
    - 일치하지 않으면 익셉션
    String str = em.find(String.class, "1");
    User user = em.find(User.class, 11);
     */
}
