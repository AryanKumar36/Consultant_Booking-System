package com.example.consultantbookingsystem.dao;

import com.example.consultantbookingsystem.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {

    @Query("SELECT s FROM Slot s WHERE s.consultantId = :consultantId " +
    "AND s.dayOfWeek= :dayOfWeek " +
    "AND ((s.startTime<= :newEndTime  AND :newStartTime<= s.endTime) OR " +
    "     (s.startTime<= :newStartTime AND :newEndTime<= s.endTime))")
    List<Slot> findOverlappingSlotsByDay(@Param("consultantId") Long consultantId,
                                         @Param("dayOfWeek") String dayOfWeek,
                                         @Param("newStartTime") Time newStartTime,
                                         @Param("newEndTime") Time newEndTime);

    @Query("SELECT s FROM Slot s WHERE s.consultantId = :consultantId")
    List<Slot> findByConsultantId(@Param("consultantId") Long consultantId);
}
