package com.skillsup.hibernate.Build;

import com.skillsup.hibernate.Build.dao.AddressDAO;
import com.skillsup.hibernate.Build.dao.AddressDAOImpl;
import com.skillsup.hibernate.Build.entity.Address;

public class Action {
    public static void main(String[] args) {
        AddressDAO addressDAO = new AddressDAOImpl();
        Address address = new Address("zip");
        Address save = addressDAO.save(address, address.getId());
        System.out.println(address);
        address.setZip("qwe");
        addressDAO.update(address, address.getId());
        System.out.println(address);
        addressDAO.delete(address, address.getId());
        System.out.println(addressDAO.findAll(Address.class));
    }
}
