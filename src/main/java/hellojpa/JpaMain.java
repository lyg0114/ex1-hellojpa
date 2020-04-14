package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
       EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

//         Member member3 = new Member();
//         member3.setId(3L);
//         member3.setName("HelloC");
//         em.persist(member3);
//
//         Member findMember1 = em.find(Member.class,1l);
//         findMember1.getName();
//         System.out.println("findMember1 = " + findMember1.getName());
 //        findMember1.setName("KGB1");
  //       System.out.println("findMember1 = " + findMember1.getName());

         List<Member> result = em.createQuery("select t from Member as t", Member.class).getResultList();


         for(Member tmp : result){
          System.out.println("tmp.getName() = " + tmp.getName());

         }



         tx.commit();
        }
        catch (Exception e){
         tx.rollback();
        }
        finally {
         em.close();
        }
        emf.close();
    }
}
