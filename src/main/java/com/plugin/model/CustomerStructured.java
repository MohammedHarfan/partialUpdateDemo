package com.plugin.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_structured")
public class CustomerStructured {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Long id;
    public String name;
    @ManyToOne(targetEntity = ContactPhone.class, fetch = FetchType.EAGER)
    @JoinColumn(name="fk_contact_phone_id", unique=true)
    public ContactPhone contactPhone;
}
