package com.plugin.service.impl;

import com.plugin.model.ContactPhone;
import com.plugin.model.Customer;
import com.plugin.model.dto.CustomerDto;
import com.plugin.model.CustomerStructured;
import com.plugin.repository.ContactPhoneRepository;
import com.plugin.repository.CustomerRepository;
import com.plugin.repository.CustomerStructuredRepository;
import com.plugin.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerStructuredRepository customerStructuredRepository;
    private ContactPhoneRepository contactPhoneRepository;
//    private CustomerMapper mapper;

        public CustomerServiceImpl(
            CustomerRepository customerRepository,
                               CustomerStructuredRepository customerStructuredRepository,
                               ContactPhoneRepository contactPhoneRepository
//                               ,CustomerMapper mapper
                               )
        {
        this.customerRepository = customerRepository;
        this.customerStructuredRepository = customerStructuredRepository;
        this.contactPhoneRepository = contactPhoneRepository;
//        this.mapper = mapper;
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCustomerWithCustomQuery(long id, String phone) {
        customerRepository.updatePhone(id, phone);
    }

    @Override
    public Customer addCustomer(String name) {
        Customer customer = new Customer();
        customer.name = name;
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Long id, String phone) {
        Customer myCustomer = customerRepository.findById(id).orElse(null);
        if (myCustomer != null) {
            myCustomer.phone = phone;
            customerRepository.save(myCustomer);
        }
        return myCustomer;
    }

    @Override
    public Customer updateCustomerContacts(long id, String phone) {
        Customer myCustomer = customerRepository.findById(id).orElse(null);
        if (myCustomer != null) {
            myCustomer.phone = phone;
            customerRepository.save(myCustomer);
        }
        return myCustomer;
    }

    @Override
    public Customer addCustomer(CustomerDto customerDto) {
        Customer myCustomer = new Customer();
//        mapper.updateCustomerFromDto(customerDto, myCustomer);
//        customerRepository.save(myCustomer);
        return myCustomer;
    }

    @Override
    public Customer updateCustomer(CustomerDto customerDto) {
        Customer myCustomer = customerRepository.findById(customerDto.id).orElse(null);
//        mapper.updateCustomerFromDto(customerDto, myCustomer);
//        customerRepository.save(myCustomer);
        return myCustomer;
    }

    @Override
    public CustomerStructured addCustomerStructured(String name) {
        CustomerStructured customerStructured = new CustomerStructured();
        customerStructured.name = name;
        customerStructuredRepository.save(customerStructured);
        return customerStructured;
    }

    @Override
    public CustomerStructured updateCustomerStructured(long id, String name){
        CustomerStructured customerStructured = customerStructuredRepository.findById(id);
        customerStructured.name = name;
        customerStructuredRepository.save(customerStructured);
        return customerStructured;
    }

    @Override
    public void addCustomerPhone(long customerId, String phone) {
        ContactPhone contactPhone = new ContactPhone();
        contactPhone.customerId = customerId;
        contactPhone.phone = phone;
        contactPhoneRepository.save(contactPhone);
    }

}
