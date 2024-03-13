package com.example.consultantbookingsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;


    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\+91 \\d{5}-\\d{5}", message = "Phone number must be in the format +91 XXXXX-XXXXX")
    private String phoneNo;


    @Range(message = "Invalid Age", min = 18, max = 100)
    @Column(nullable = false)
    private int age;

    @NotNull(message = "Role is Required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public User()
    {

    }

    public User(String name, String email, String phoneNo, int age, Role role, int experience, String areaOfExpertise) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.age = age;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }
}

