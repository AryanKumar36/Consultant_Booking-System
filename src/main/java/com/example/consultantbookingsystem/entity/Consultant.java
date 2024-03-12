package com.example.consultantbookingsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "consultant")
public class Consultant {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private User user;

    @Column(nullable = false)
    @Range(message = "Invalid experience", min = 0, max = 99)
    private int experience;
    @NotBlank(message = "Area of expertise is required")
    @Column(nullable = false)
    private String areaOfExpertise;

    public Consultant()
    {

    }
    public Consultant(User user, int experience, String areaOfExpertise) {
        this.user = user;
        this.experience = experience;
        this.areaOfExpertise = areaOfExpertise;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public int getExperience() {
        return experience;
    }

    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", user=" + user +
                ", experience=" + experience +
                ", areaOfExpertise='" + areaOfExpertise + '\'' +
                '}';
    }
}