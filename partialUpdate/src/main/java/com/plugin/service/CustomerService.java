package com.plugin.service;

import com.plugin.model.Customer;
import com.plugin.model.dto.CustomerDto;
import com.plugin.model.CustomerStructured;
import org.springframework.stereotype.Service;

@Service
 public interface CustomerService {

     Customer getCustomer(Long id);

     void updateCustomerWithCustomQuery(long id, String phone);

     Customer addCustomer(String name);

     Customer updateCustomer(Long id, String phone);

     Customer updateCustomerContacts(long id, String phone);

     Customer addCustomer(CustomerDto customerDto);

     Customer updateCustomer(CustomerDto customerDto);

     CustomerStructured addCustomerStructured(String name);

     CustomerStructured updateCustomerStructured(long id, String name);

     void addCustomerPhone(long customerId, String phone);
}
