package sk.posam.fsa.jpa;

import sk.posam.fsa.jpa.domain.Category;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class JpaApplication {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dvdrental-pu-name");
        EntityManager em = factory.createEntityManager();

        // read the existing entries and write to console
        Query q = em.createQuery("select c from Category c");
        List<Category> categories = q.getResultList();
        for (Category category : categories) {
            System.out.println(category);
        }
        System.out.println("Size: " + categories.size());

        // create new entry
        em.getTransaction().begin();
        Category category = new Category();
        category.setName("This is a test");
        category.setLastUpdated(new Date());
        em.persist(category);
        em.getTransaction().commit();

        em.close();
    }
}
