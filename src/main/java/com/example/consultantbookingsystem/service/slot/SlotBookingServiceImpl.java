package com.example.consultantbookingsystem.service.slot;

import com.example.consultantbookingsystem.dao.ConsultantRepository;
import com.example.consultantbookingsystem.dao.SlotRepository;
import com.example.consultantbookingsystem.entity.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class SlotBookingServiceImpl implements SlotBookingService{


    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private ConsultantRepository consultantRepository;
    @Override
    public Optional<Slot> findById(Long theID) {

        return slotRepository.findById(theID);
    }

    @Override
    public List<Slot> getAllSlots() {
        return null;
    }

    @Override
    public List<Slot> findByConsultantId(Long csId) {
        return null;
    }

    @Override
    public Slot addSlot(Long consultantId, String dayOfWeek, Time newStartTime, Time newEndTime) {
        return null;
    }
}
