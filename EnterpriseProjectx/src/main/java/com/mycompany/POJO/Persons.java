
package com.mycompany.POJO;

import com.mycompany.Engine.EngineAddress;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "HIBER.PERSONS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persons implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private Integer personId;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "SURNAME")
    private String surname;
    @OneToMany(mappedBy = "personId", fetch = FetchType.EAGER)
    private List<EngineAddress> addressList;

    public Persons() {
    }

    public Persons( String firstname, String surname, List<EngineAddress> addressList) {
        this.firstname = firstname;
        this.surname = surname;
        this.addressList = addressList;
    }
    
    

    public Persons(Integer personId) {
        this.personId = personId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<EngineAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<EngineAddress> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.personId != null ? this.personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Persons)) {
            return false;
        }
        Persons other = (Persons) object;
        return (this.getPersonId() != null || other.getPersonId() == null) && (this.getPersonId() == null || this.getPersonId().equals(other.getPersonId()));
    }

    @Override
    public String toString() {
        return " personId=" + this.getPersonId() + " Firstname="+this.getFirstname()+" surname="+this.getSurname();
    }
    
}
