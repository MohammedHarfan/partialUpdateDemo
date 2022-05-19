package com.plugin.model;

import javax.persistence.*;

@Entity
@Table(name = "contact_phone")
public class ContactPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable=false)
    public Long customerId;
    public String phone;

    @Override
    public String toString() {
        return phone;
    }
}