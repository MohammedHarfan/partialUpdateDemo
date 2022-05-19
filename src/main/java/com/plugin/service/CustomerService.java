package com.plugin.service;

import com.plugin.model.ContactPhone;
import com.plugin.model.Customer;
import com.plugin.model.dto.CustomerDto;
import com.plugin.model.CustomerStructured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
 public interface CustomerService {

     Customer getCustomer(Long id);

     void updateCustomerWithCustomQuery(long id, String phone);

     Customer addCustomer(String name);

     Customer updateCustomer(Long id, String phone);

     Customer addCustomer(CustomerDto customerDto);

     Customer updateCustomer(CustomerDto customerDto);

     CustomerStructured addCustomerStructured(String name, ContactPhone contactPhone);

     CustomerStructured updateCustomerStructured(Long id, String name);

     void addCustomerPhone(long customerId, String phone);
}
