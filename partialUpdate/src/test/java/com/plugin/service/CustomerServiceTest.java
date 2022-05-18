package com.plugin.service;

import com.plugin.PartialUpdateApplication;
import com.plugin.model.Customer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PartialUpdateApplication.class)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void addCustomer() {
        Customer myCustomer = customerService.addCustomer("John");
        myCustomer = customerService.updateCustomer(myCustomer.customerId, "+00");
        Assertions.assertEquals("+00", myCustomer.phone);
    }
}