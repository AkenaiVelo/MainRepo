
package com.mycompany.DTO;

public class AddressDTO {
    private String city;
    private String zipcode;

    public AddressDTO(String city, String zipcode) {
        this.city = city;
        this.zipcode = zipcode;
    }

    public AddressDTO() {
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

}
