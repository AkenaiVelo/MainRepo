package com.mycompany.POJO;

import com.mycompany.Engine.EnginePersons;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "HIBER.ADDRESS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Address implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADDRESS_ID")
    private Integer addressId;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ZIPCODE")
    private String zipcode;
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private EnginePersons personId;

    public Address() {
    }

    public Address( String city, String zipcode, EnginePersons personId) {
        this.city = city;
        this.zipcode = zipcode;
        this.personId = personId;
    }

    public Address(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public EnginePersons getPersonId() {
        return personId;
    }

    public void setPersonId(EnginePersons personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getAddressId() != null ? this.getAddressId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        return (this.addressId != null || other.addressId == null) && (this.addressId == null || this.addressId.equals(other.addressId));
    }

    @Override
    public String toString() {
        return " addressId=" + this.getAddressId() + " City="+this.getCity()+" Zip-Code="+this.getZipcode();
    }
}