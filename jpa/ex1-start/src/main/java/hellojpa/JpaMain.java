package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        try {
//            Member member = new Member();
//            member.setId(3L);
//            member.setName("HelloC");
//
//            em.persist(member);
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

//        try {
//            Member findMember = em.find(Member.class, 3L);
//            findMember.setName("HelloD");
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        try{
            List<Member> findMembers = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
            tx.commit();

            for(Member member : findMembers){
                System.out.println("member.name: " + member.getName());
            }
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
