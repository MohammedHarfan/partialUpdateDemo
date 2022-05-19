package com.plugin.service;

import com.plugin.PartialUpdateApplication;
import com.plugin.model.ContactPhone;
import com.plugin.model.Customer;
import com.plugin.model.CustomerStructured;
import com.plugin.repository.CustomerStructuredRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PartialUpdateApplication.class)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerStructuredRepository customerStructuredRepository;

    @Test
    public void addCustomer() {
        Customer myCustomer = customerService.addCustomer("John");

        myCustomer = customerService.updateCustomer(myCustomer.customerId, "+00");
        Assertions.assertEquals("+00", myCustomer.phone);
    }

    @Test
    public void addCustomerStructured() {
        ContactPhone contactPhone = new ContactPhone();
        contactPhone.id = 1L;
        contactPhone.customerId = 1L;
        contactPhone.phone = "+00";
        CustomerStructured customerStructured = customerService.addCustomerStructured("peter", contactPhone);
        Assertions.assertEquals("peter", customerStructured.name);
    }

    @Test
    public void updateCustomerStructured() {
        CustomerStructured customerStructured = new CustomerStructured();
        customerStructured.id = 1L;
        customerStructured.name = "Tom";
        customerStructuredRepository.save(customerStructured);
        CustomerStructured actual = customerService.updateCustomerStructured(customerStructured.id, "Cruise");
        Assertions.assertEquals("Cruise", actual.name);
    }
}