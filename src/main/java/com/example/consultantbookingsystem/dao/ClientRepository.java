package com.example.consultantbookingsystem.dao;

import com.example.consultantbookingsystem.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
