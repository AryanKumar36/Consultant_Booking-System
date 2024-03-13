package com.example.consultantbookingsystem.dao;

import com.example.consultantbookingsystem.entity.Consultant;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
    @EntityGraph(attributePaths = "slots")
    List<Consultant> findAllWithSlots();

    @EntityGraph(attributePaths = "slots")
    List<Consultant> findAllWithSlotsByExperience(int experience);
    @EntityGraph(attributePaths = "slots")
    List<Consultant> findAllWithSlotsByAreaOfExpertise(String areaOfExpertise);

    @EntityGraph(attributePaths = "slots")
    List<Consultant> findAllWithSlotsByExperienceAndAreaOfExpertise(int experience, String areaOfExpertise);
}
