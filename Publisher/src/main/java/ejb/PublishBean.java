/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Planet
 */
@Stateless
public class PublishBean implements PublishBeanLocal {

    @PersistenceContext(name = "mypub")
    EntityManager em;

    @Override
    public void addCust(String fname, String lname) {
        Customer c = new Customer();
        c.setFirstName(fname);
        c.setLastName(lname);

        em.persist(c);
    }

    @Override
    public void updateCust(Integer custId, String fname, String lname) {

        Customer c = (Customer) em.find(Customer.class, custId);
        c.setFirstName(fname);
        c.setLastName(lname);

        em.merge(c);
    }

    @Override
    public void deleCust(Integer custId) {
        Customer c = (Customer) em.find(Customer.class, custId);
        em.remove(c);
    }

    @Override //all customer
    public Collection<Customer> getAllCustomer() {
        return em.createNamedQuery("Customer.findAll").getResultList();
    }

    @Override // select * from customer where fnm="dhruvi"
    public Collection<Customer> getAllCustomerByFirstname(String fnm) {
        return em.createNamedQuery("Customer.findByFirstName").setParameter("firstName", fnm).getResultList();
    }

    @Override //select * from customer where lnm="dhruvi"
    public Collection<Customer> getAllCustomerByLastname(String lnm) {
        return em.createNamedQuery("Customer.findByLastName").setParameter("lastName", lnm).getResultList();
    }

    @Override //pending
    public Customer getCustomerById(Integer id) {
        Customer c = (Customer) em.find(Customer.class, id);
        return c;
    }

//    @Override
//    public Collection<Address> getAllAddress() {
//       return em.createNamedQuery("Address.findAll").getResultList();
//    }
    
    

    @Override
    public void addAddressToCustomer(String street, String city, String state, String zip, Integer custId) {
        Customer c = em.find(Customer.class, custId);
        Collection<Address> address = c.getAddressCollection();

        Address a = new Address();
        a.setStreet(street);
        a.setCity(city);
        a.setState(state);
        a.setZip(zip);
        a.setCustomer(c);

        address.add(a);
        c.setAddressCollection(address);

        em.persist(a);
        em.merge(c);
    }

    @Override // update only street,stste,city or zip doesn't edit addressID and custId must be your added to inserting time 
    public void updateAddressToCustomer(Integer addressId, String street, String city, String state, String zip, Integer custId) {
        Customer c = em.find(Customer.class, custId);
       
        Address a = null;
        for (Address address : c.getAddressCollection()) {
            if (address.getAddressId().equals(addressId)) { 
                a = address;
                break;
            }
        }
        a.setStreet(street);
        a.setCity(city);
        a.setState(state);
        a.setZip(zip);

       
        em.merge(a); 
    }

    @Override
    public void removeAddressToCustomer(Integer addressId,Integer custId) {
        Customer c = (Customer) em.find(Customer.class, custId);
        Address a = (Address) em.find(Address.class, addressId);

        Collection<Address> address = c.getAddressCollection();

        if (address.contains(a)) {
            address.remove(a);
            c.setAddressCollection(address);
            em.remove(a);
            em.merge(c);
        }
    }

    @Override
    public Collection<Address> getAddressOfCustomer(Integer custId) {
        Customer c=em.find(Customer.class, custId);
        return c.getAddressCollection();
    }

    @Override
    public Customer getCustomerFromAddress(Integer addressId) {
        Address a = em.find(Address.class, addressId);
        return a.getCustomer();
    }

    @Override
    public Collection<Address> getAddressByCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressByState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByZip(String zip) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
