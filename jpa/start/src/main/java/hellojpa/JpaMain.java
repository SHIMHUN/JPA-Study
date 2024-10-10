package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        try{
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("Hello");
//            em.persist(member);
//            tx.commit();
//        }catch(Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }

//        try{
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//        }catch(Exception e){
//
//        }

//        try{
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);
//        }catch(Exception e){
//
//        }

//        try{
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//            tx.commit();
//        }catch(Exception e){
//
//        }

        try{
            List<Member> result = em.createQuery("select m from Member m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
        }catch (Exception e){

        }

        emf.close();
    }
}
