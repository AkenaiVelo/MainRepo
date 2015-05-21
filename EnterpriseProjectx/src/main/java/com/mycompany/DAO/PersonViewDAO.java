package com.mycompany.DAO;

//import com.mycompany.HibernateUtils.HibernateUtil;
import com.mycompany.Engine.EnginePersons;
import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import org.hibernate.*;
@Repository
public class PersonViewDAO {
    //private Session session;
    private EntityManager mg;

    public PersonViewDAO() {
        System.out.println("Konstruktor Person View DAO");
        //session=HibernateUtil.getSessionFactory().openSession(); 
        mg=Persistence.createEntityManagerFactory( "example-unit" ).createEntityManager();  
    }
    @Transactional
    public EnginePersons getPersonById(int id)
    {
        //EnginePersons result=(EnginePersons) session.get(EnginePersons.class, id);
        EnginePersons result = mg.find(EnginePersons.class, id);
        return result;
    }
     public void AddPerson(EnginePersons person)
     {
         /*
    	 session.beginTransaction();   	 
    	 session.save(person);
    	 session.getTransaction().commit();
                 */
         mg.persist(person);
     }
     
     public List<EnginePersons> findAll() {
        List<EnginePersons> all;
        Query query = mg.createQuery("from EnginePersons e"); //You will get Weayher object
        all = query.getResultList(); //You are accessing  as list<WeatherModel>
        //session.close();
        return all;
    }

}
