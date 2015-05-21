
package com.mycompany.Engine;

import com.mycompany.POJO.Address;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="HIBER.ADDRESS")
@XmlRootElement
public class EngineAddress extends Address{
private static final long serialVersionUID = 121L;
    public EngineAddress() {
    }

    public EngineAddress(String city, String zipcode,EnginePersons person) {
        super(city, zipcode,person);
    }
    
    
}
