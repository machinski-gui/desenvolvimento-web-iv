package com.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
