package com.example.consultantbookingsystem.service.slot;

import com.example.consultantbookingsystem.entity.Slot;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface SlotBookingService {

    //Find BY id
    Optional<Slot> findById(Long theID);

    //Get all slots
    List<Slot> getAllSlots();

    //Get slots by ConsultantId;
    List<Slot> findByConsultantId(Long csId);

    //
    Slot addSlot(Long consultantId, String dayOfWeek, Time newStartTime, Time newEndTime);
}
