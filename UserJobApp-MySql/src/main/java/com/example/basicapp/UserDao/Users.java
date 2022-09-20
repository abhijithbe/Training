package com.example.basicapp.UserDao;

import com.example.basicapp.JobDao.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * user class with various attribute and methods to get users
 * @author abhijith.be
 */
@Entity(name = "user_details")
public class Users {
    @Id
    private int id;
    private String name;
    private int number;
    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Job job;
    public Job getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", job=" + job +
                '}';
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Users(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Users() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
