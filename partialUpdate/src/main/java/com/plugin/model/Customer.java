package com.plugin.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id", unique=true, nullable=false)
    public Long customerId;
    @Column(name = "name")
    public String name;
    @Column(name = "phone")
    public String phone;
//    public String phone99;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return String.format("Customer %s, Phone: %s", this.name, this.phone);
    }
}
