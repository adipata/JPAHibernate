package ro.pata.jpa.eni;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.pata.jpa.eni.entity_test.AgendaDetailEntity;
import ro.pata.jpa.eni.entity_test.AgendaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static final Logger log = LoggerFactory.getLogger(AppTest.class);

    private static EntityManagerFactory emf;
    private EntityManager em;

    @BeforeClass
    public static void InitEntityManagerFactory(){
        log.info("InitEntityManagerFactory");
        emf= Persistence.createEntityManagerFactory("agenda");
    }

    @Before
    public void InitEntityManager(){
        log.info("InitEntityManager");
        em=emf.createEntityManager();
    }

    @Test
    public void Test01()
    {
        em.getTransaction().begin();

        AgendaDetailEntity detail=new AgendaDetailEntity();
        detail.setAddress("Cotoi");

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
            System.out.println(ai.getDetail());
        }
        assertTrue( true );
    }

    @After
    public void CloseEntityManager(){
        log.info("CloseEntityManager");
        em.close();
    }

    @AfterClass
    public static void CloseEntityManagerFactory(){
        log.info("CloseEntityManagerFactory");
        emf.close();
    }
}
