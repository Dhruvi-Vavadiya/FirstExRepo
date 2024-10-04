/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Planet
 */
@Local
public interface PublishBeanLocal {
//    customer
    
    void addCust(String fname,String lname);
    void updateCust(Integer custId,String fname,String lname);
    void deleCust(Integer custId);
    Collection<Customer> getAllCustomer();
    Collection<Customer> getAllCustomerByFirstname(String fnm);
    Collection<Customer> getAllCustomerByLastname(String lnm);
    Customer getCustomerById(Integer id); //pending
    
    

//  Address
//    Collection<Address> getAllAddress();
    
    void addAddressToCustomer(String street,String city,String state,String zip,Integer custId);
    void updateAddressToCustomer(Integer addressId,String street,String city,String state,String zip,Integer custId);
    void removeAddressToCustomer(Integer addressId,Integer custId);
    Collection<Address> getAddressOfCustomer(Integer custId);
    Customer getCustomerFromAddress(Integer addressId);
    
    
    Collection<Address> getAddressByCity(String city);
    Collection<Address> getAddressByState(String state);
    Collection<Address> getAddressesByZip(String zip);
//    
    
}
