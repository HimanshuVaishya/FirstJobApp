package org.example.firstjobapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String about;

//    @OneToMany(mappedBy = "company") => company-> is field of Job Table so that we can map the same
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public Company() {
    }

    public Company(Long id, String name, String address, String about, List<Job> jobs) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.about = about;
        this.jobs = jobs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
