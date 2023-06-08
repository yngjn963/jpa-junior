package jpabasic.reserve.domain;

public class RemoveUserService {
    public void removeUser(String email) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            User user = em.find(User.class, email);
            if (user == null) {
                throw new NoUserException();
            }

            em.remove(user);

            tx.commit();
        } catch (Exception ex) {
            tx.rollback();

            throw ex;
        } finally {
            em.close();
        }
    }
    /*
    삭제
    - 삭제 대상이 존재하지 않으면
    em.remove(user); 시점에 다른 프로세스가 데이터를 삭제하면 익셉션 발생
     */
}
