package ro.pata.jpa.eni;

import ro.pata.jpa.eni.entity_test.AgendaDetailEntity;
import ro.pata.jpa.eni.entity_test.AgendaEntity;
import ro.pata.jpa.eni.entity.PersonneDetailEntity;
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
        adi();
    }

    public static void adi(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("agenda");
        EntityManager em=emf.createEntityManager();

        em.getTransaction().begin();

        AgendaDetailEntity detail=new AgendaDetailEntity();
        detail.setAddress("Cotoi");
        em.persist(detail);

        AgendaEntity person=new AgendaEntity();
        person.setNume("Cucurel");
        person.setTelefon("567");
        person.setDetail(detail);
        em.persist(person);
        em.getTransaction().commit();

        List<AgendaEntity> agenda=em.createQuery("select a from AgendaEntity a",AgendaEntity.class).getResultList();
        log.info("*** List agenda items");
        for(AgendaEntity ai:agenda){
            System.out.println(ai);
        }

        em.close();
        emf.close();
    }

    public static void eni(){
        log.info("Hello World!" );
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("projetEni");
        EntityManager em=emf.createEntityManager();

        PersonneEntity p=new PersonneEntity();
        p.setDateNaissance(new Date());
        p.setNom("Coco");
        p.setPrenom("Jambo");
        System.out.println(p);



        em.getTransaction().begin();
        em.persist(p);

        PersonneDetailEntity detail=new PersonneDetailEntity();
        detail.setNumSecu("1234");
        detail.setSexe("M");
        detail.setPersonne(p);
        detail.setIdPersonne(p.getId());
        p.setDetail(detail);

        em.getTransaction().commit();

        List<PersonneEntity> persons= em.createQuery("select p from PersonneEntity p",PersonneEntity.class).getResultList();

        for(PersonneEntity pers:persons){
            log.info(pers.toString()+" "+pers.getDetail());
        }

        System.out.println(persons.size());

        em.close();
        emf.close();
    }
}
