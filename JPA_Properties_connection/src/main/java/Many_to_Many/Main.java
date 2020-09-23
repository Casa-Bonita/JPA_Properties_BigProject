package Many_to_Many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Student st1 = new Student("Semen");
//        Student st2 = new Student("Oleg");
//
//        Prepod prepod1 = new Prepod("Ivan Ivanovich");
//        Prepod prepod2 = new Prepod("Sergey Sergeevich");
//
//        prepod1.getStudentList().add(st1);
//        st1.getPrepodList().add(prepod1);
//
//        prepod1.getStudentList().add(st2);
//        st2.getPrepodList().add(prepod1);
//
//        prepod2.getStudentList().add(st2);
//        st2.getPrepodList().add(prepod2);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("productsUnit");

        EntityManager em = entityManagerFactory.createEntityManager();

//        em.getTransaction().begin();
//        em.persist(st1);
//        em.persist(st2);
//        em.persist(prepod1);
//        em.persist(prepod2);
//        em.getTransaction().commit();

        List<Student> listStudent = em.createQuery("from Student").getResultList();
        System.out.printf("%-20s %-20s %n", "Student_ID", "Student_Name");
        listStudent.stream()
                .forEach(x -> System.out.printf("%-20s %-20s %n", x.getId(), x.getStudentName()));

        System.out.println();

        List<Prepod> listPrepod = em.createQuery("from Prepod").getResultList();
        System.out.printf("%-20s %-20s %n", "Prepod_ID", "Prepod_Name");
        listPrepod.stream()
                .forEach(x -> System.out.printf("%-20s %-20s %n", x.getId(), x.getPrepodName()));

        
    }
}
