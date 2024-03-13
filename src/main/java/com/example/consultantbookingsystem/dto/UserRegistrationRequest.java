package com.example.consultantbookingsystem.dto;

import com.example.consultantbookingsystem.entity.User;

public class UserRegistrationRequest {

    private User user;
    private Integer experience;
    private String areaOfExpertise;

    public UserRegistrationRequest(User user, Integer experience, String areaOfExpertise) {
        this.user = user;
        this.experience = experience;
        this.areaOfExpertise = areaOfExpertise;
    }

    public UserRegistrationRequest()
    {

    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    @Override
    public String toString() {
        return "UserRegistrationRequest{" +
                "user=" + user +
                ", experience=" + experience +
                ", areaOfExpertise='" + areaOfExpertise + '\'' +
                '}';
    }
}
