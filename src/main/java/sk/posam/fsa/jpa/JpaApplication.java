package sk.posam.fsa.jpa;

import sk.posam.fsa.jpa.domain.Actor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaApplication {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dvdrental-pu-name");
        EntityManager em = factory.createEntityManager();
// ******************************* inserting language ***********************
        em.getTransaction().begin();
//        Language language = em.find(Language.class, 2L);
//        if(language != null) em.remove(language);
////        String sql = "CREATE TABLE language_actor ("
////                + "language_id BIGINT REFERENCES language(language_id),"
////                + "actor_id BIGINT REFERENCES actor(actor_id),"
////                + "PRIMARY KEY (language_id, actor_id)"
////                + ")";
////        em.createNativeQuery(sql).executeUpdate();
////        Language italian = new Language("Italian", LocalDateTime.now());
////        em.persist(italian);
//        Actor roberDJunior = new Actor("Robert", "Downey Jr", LocalDateTime.now());
//        Language greek = new Language("Greek",LocalDateTime.now());
//        roberDJunior.addLanguage(greek);
//        em.persist(greek);
//        em.persist(roberDJunior);
//        em.getTransaction().commit();
        String jpql = "SELECT DISTINCT a FROM Actor a JOIN FETCH a.languages";
        List<Actor> actors = em.createQuery(jpql, Actor.class).getResultList();
        for (Actor a:actors
             ) {
            System.out.println(a);
        }
        em.close();


        // read the existing entries and write to console
//        Query q = em.createQuery("select c from Pet c");
//        List<Pet> pets = q.getResultList();
//        for (Pet pet : pets) {
//            System.out.println(pet);
//        }

        // create new entry
//        em.getTransaction().begin();
//        Pet maki = new Pet("Makko", 4, "Dog");
//        em.persist(maki);
//        em.getTransaction().commit();

//   *******************************************     create table pet      *********************************

//        String sql = "CREATE TABLE public.pet ("
//                + "pet_id SERIAL PRIMARY KEY,"
//                + "name VARCHAR(50) NOT NULL,"
//                + "num_legs INTEGER NOT NULL,"
//                + "animal_type VARCHAR(50) NOT NULL,"
//                + "actor_id BIGINT,"
//                + "FOREIGN KEY (actor_id) REFERENCES actor (actor_id)"
//                + ")";
//        em.createNativeQuery(sql).executeUpdate();
//        em.getTransaction().commit();

//        remove pet with ID 1
//        em.getTransaction().begin();
//        Pet pet = em.find(Pet.class, 1L); // get the pet with the specified id
//        if (pet != null) {
//            em.remove(pet); // remove the pet from the database
//        }
//        em.getTransaction().commit();
//        ************************* store some actors and their pets *********************************
//        em.getTransaction().begin();
//        Actor Andy = new Actor("Andy","Bernard", LocalDateTime.now());
//        Actor Pam = new Actor("Pamela","Anderson", LocalDateTime.now().minusMonths(4).minusDays(3));
//        Pet pet1 = new Pet("Fido",4,"Rabbit");
//        Pet pet2 = new Pet("Fluffy",4,"Turtle");
//        Pet pet3 = new Pet("Buddy",4,"Dog");
//        Andy.addPet(pet1);
//        Pam.addPet(pet2);
//        Pam.addPet(pet3);
//        em.persist(Andy);
//        em.persist(Pam);
//        em.persist(pet1);
//        em.persist(pet2);
//        em.persist(pet3);
//
//        em.getTransaction().commit();
//        em.close();
    }
}
