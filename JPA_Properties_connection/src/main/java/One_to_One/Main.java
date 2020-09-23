package One_to_One;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Lamborgini");
        Car car2 = new Car("Ferrari");

        GosNumber gosNumber1 = new GosNumber("A000AA000");
        GosNumber gosNumber2 = new GosNumber("B000BB000");

        car1.setGosNumber(gosNumber1);
        car2.setGosNumber(gosNumber2);

        gosNumber1.setCar(car1);
        gosNumber2.setCar(car2);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("productsUnit");

        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();
        em.persist(car1);
        em.persist(car2);
        em.persist(gosNumber1);
        em.persist(gosNumber2);
        em.getTransaction().commit();

        List<Car> listCar = em.createQuery("from Car").getResultList();
        System.out.printf("%-20s %-20s %n", "Car_ID", "Car_Model");
        listCar.stream()
                .forEach(x -> System.out.printf("%-20s %-20s %n", x.getId(), x.getModel()));

        List<GosNumber> listGosNumber = em.createQuery("from GosNumber").getResultList();
        System.out.printf("%-20s %-20s %n", "GosNumber_ID", "GosNumber_Number");
        listGosNumber.stream()
                .forEach(x -> System.out.printf("%-20s %-20s %n", x.getId(), x.getNumber()));


    }
}
