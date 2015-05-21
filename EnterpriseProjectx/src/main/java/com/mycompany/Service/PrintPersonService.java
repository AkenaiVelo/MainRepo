package com.mycompany.Service;

import com.mycompany.DAO.PersonViewDAO;
import com.mycompany.DTO.AddressDTO;
import com.mycompany.DTO.PersonDTO;
import com.mycompany.Engine.EnginePersons;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PrintPersonService {
    
    @Autowired
    private PersonViewDAO person;
    
    public PrintPersonService()
    {
        
    }
    
    public List<PersonDTO> getAll()
    {
        if(person==null)
        {
            System.out.println("pusty person w print service");
            person=new PersonViewDAO();
        }
        List<EnginePersons> tempList=person.findAll();
        System.out.println(tempList.get(0).getFirstname());
        List<PersonDTO> wynik=new ArrayList<>();
        for(int i=0;i<tempList.size();i++)
        {
            ArrayList<AddressDTO> tempAddressList=new ArrayList<>();
            for(int j=0;j<tempList.get(i).getAddressList().size();j++)
            {
                tempAddressList.add(new AddressDTO(tempList.get(i).getAddressList().get(j).getCity(), tempList.get(i).getAddressList().get(j).getZipcode()));
            }
            wynik.add(new PersonDTO(tempList.get(i).getFirstname(), tempList.get(i).getSurname(), tempAddressList));
        }
        return wynik;
    }
    
}
