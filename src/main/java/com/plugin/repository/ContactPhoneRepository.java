package com.plugin.repository;

import com.plugin.model.ContactPhone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ContactPhoneRepository extends JpaRepository<ContactPhone, Serializable> {
    ContactPhone findById(long id);
    ContactPhone findByCustomerId(long id);
}
