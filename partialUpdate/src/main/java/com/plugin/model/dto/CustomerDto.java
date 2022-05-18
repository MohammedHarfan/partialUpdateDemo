package com.plugin.model.dto;

import com.plugin.model.Customer;

import javax.persistence.Entity;
import javax.persistence.Table;

public class CustomerDto {
    public Long id;
    public String name;
    public String phone;
//    public String phone99;

    public CustomerDto(long id) {
      this.id = id;
    }

    public CustomerDto(Customer c) {
        this.id = c.customerId;
        this.name = c.name;
        this.phone = c.phone;
    }

    public long getId(long id) {
        return this.id;
    }

    public Customer convertToEntity() {
        Customer customer = new Customer();
        customer.customerId = id;
        customer.name = name;
        customer.phone = phone;
        return customer;
    }
}
