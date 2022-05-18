package com.plugin.repository;

import com.plugin.model.CustomerStructured;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerStructuredRepository extends JpaRepository<CustomerStructured, Long> {
    CustomerStructured findById(long id);
}