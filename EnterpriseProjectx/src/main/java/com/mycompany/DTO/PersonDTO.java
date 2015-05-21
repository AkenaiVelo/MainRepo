package com.mycompany.DTO;

import java.util.ArrayList;

public class PersonDTO {
    private String firstname;
    private String surname;
    private ArrayList<AddressDTO> addressList;

    public PersonDTO() {
    }

    public PersonDTO(String firstname, String surname, ArrayList<AddressDTO> addressList) {
        this.firstname = firstname;
        this.surname = surname;
        this.addressList = addressList;
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

    public ArrayList<AddressDTO> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<AddressDTO> addressList) {
        this.addressList = addressList;
    }
    
    
}
