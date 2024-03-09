package com.mohk.jobapp.job;

import com.mohk.jobapp.company.Company;
import jakarta.persistence.*;


@Entity   //for connecting to h2 database
//@Table(name = "job_table")
public class Job {
    @Id  //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

//    RELATIONSHIP TO COMPANY
    @ManyToOne
    private Company company;
    public Job() { //default constructor for JPA
    }

    //Default Constructor plus getter and setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Job(Long id, String title, String description, String minSalary, String maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;

    }
//    GETTER AND SETTER FOR COMPANY

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}


