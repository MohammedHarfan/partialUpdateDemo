package com.plugin.repository;

import com.plugin.model.CustomerStructured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerStructuredRepository extends JpaRepository<CustomerStructured, Long> {
}