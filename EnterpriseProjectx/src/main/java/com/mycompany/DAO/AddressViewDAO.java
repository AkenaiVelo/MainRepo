package com.mycompany.DAO;

import com.mycompany.Engine.EngineAddress;
//import com.mycompany.HibernateUtils.HibernateUtil;
import com.mycompany.Engine.EnginePersons;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import org.hibernate.*;
@Repository("addressViewDAO")
public class AddressViewDAO {
    //private Session session;
    private EntityManager mg;

    public AddressViewDAO() {
        //session=HibernateUtil.getSessionFactory().openSession(); 
        mg=Persistence.createEntityManagerFactory( "example-unit" ).createEntityManager();  
    }
    @Transactional
    public EngineAddress getAddressById(int id)
    {
        EngineAddress result= mg.find(EngineAddress.class, id);
        return result;
    }
    @Transactional
     public void AddAddress(EngineAddress address)
     {
    	 //session.beginTransaction();   	 
    	 //session.save(address);
    	 //session.getTransaction().commit();
         mg.persist(address);
     }
    @Transactional(readOnly = true)
     public List<EnginePersons> findPersonsByAddress(String zipcode) {
        List<EngineAddress> all_addresses;
        List<EnginePersons> all_persons = new ArrayList<EnginePersons>();
        Query query = mg.createQuery("Select c FROM EngineAddress c WHERE c.zipcode LIKE :par" ).setParameter("par", zipcode); 
        all_addresses = query.getResultList(); //You are accessing  as list<WeatherModel>

        for(EngineAddress address : all_addresses)
        {
             //Hibernate.initialize(address.getPersonId());
            all_persons.add(address.getPersonId());
        }
          //session.close();
        return all_persons;       
    }
}
