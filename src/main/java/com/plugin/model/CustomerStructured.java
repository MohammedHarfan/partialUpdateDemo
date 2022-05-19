package com.plugin.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_structured")
public class CustomerStructured {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    @OneToMany(fetch = FetchType.EAGER, targetEntity = ContactPhone.class, mappedBy = "customerId")
    public List<ContactPhone> contactPhoneList;
}
