package One_to_Many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("productsUnit");

        Library library = new Library();
//        library.setAddress("Moscow");
//
//        Book book1 = new Book("Voina I Mir");
//        Book book2 = new Book("Oblomov");
//        Book book3 = new Book("Master I Margarita");
//
//        //связываем обязательно библиотеку  с книгами
//        library.getBookList().add(book1);
//        library.getBookList().add(book2);
//        library.getBookList().add(book3);
//
//        //связываем обязательно книги с библиотекой
//        book1.setLibrary(library);
//        book2.setLibrary(library);
//        book3.setLibrary(library);
//
        EntityManager em = entityManagerFactory.createEntityManager();
//
//        em.getTransaction().begin();
//        em.persist(book1);
//        em.persist(book2);
//        em.persist(book3);
//        em.persist(library);
//        em.getTransaction().commit();


        //Загрузим библиотеку из базы
        library = (Library) em.createQuery("from Library").getSingleResult();


        System.out.println("RESULT:");
        System.out.printf("%-20s %-20s %n", "Library_ID", "Library_Address");
        System.out.printf("%-20s %-20s %n", library.getId(), library.getAddress());
        System.out.println();
        System.out.printf("%-20s %-20s %n", "Book_ID", "Book_Name");
        for (Book temp : library.getBookList()){
            System.out.printf("%-20s %-20s %n", temp.getId(), temp.getBook_name());
        }

    }
}
