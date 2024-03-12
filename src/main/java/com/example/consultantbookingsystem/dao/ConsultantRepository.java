package com.example.consultantbookingsystem.dao;

import com.example.consultantbookingsystem.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    @Override
    boolean existsById(Long theId);
}
