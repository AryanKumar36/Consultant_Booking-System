package com.example.consultantbookingsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;

@Entity
@Table(name = "slot")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultant_user_id")
    private Consultant consultant;

    @Column(nullable = false)
    @NotBlank(message = "Day of week is required")
    private String dayOfWeek;
    @NotNull(message = "Start Time is required")
    @Column(nullable = false)
    private Time startTime;
    @NotNull(message = "End Time is required")
    @Column(nullable = false)
    private Time endTime;

    public Slot()
    {

    }

    public Long getId()
    {
        return id;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }


    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", consultant=" + consultant +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}