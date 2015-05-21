package com.mycompany.Engine;

import com.mycompany.POJO.Persons;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="HIBER.PERSONS")
@XmlRootElement
public class EnginePersons extends Persons{
    private static final long serialVersionUID = 12L;
    public EnginePersons() {
    }

    public EnginePersons(int person_id, String firstname, String Surname, List<EngineAddress> adresy) {
        super( firstname, Surname, adresy);
    }   
}