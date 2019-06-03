package ro.pata.jpa.eni;

import ro.pata.jpa.eni.entity.PersonneEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
        log.info("Hello World!" );
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("projetEni");
        EntityManager em=emf.createEntityManager();

        PersonneEntity p=new PersonneEntity();
        p.setDateNaissance(new Date());
        p.setNom("Coco");
        p.setPrenom("Jambo");

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

        List<PersonneEntity> persons= em.createQuery("select p from PersonneEntity p",PersonneEntity.class).getResultList();

        for(PersonneEntity pers:persons){
            log.info(pers.toString());
        }

        System.out.println(persons.size());

        em.close();
        emf.close();
    }
}
