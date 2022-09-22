package com.example.basicapp.JobDao;
import com.example.basicapp.UserDao.Users;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Job class with various attributes and methods to retrieve job details of user
 * @author abhijith.be
 */
@Entity(name="JobDetails")
public class Job {
    @Id
    private int id;
    private String Company;
    private String Role;

    @OneToOne
    private Users user;

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", Company='" + Company + '\'' +
                ", Role='" + Role + '\'' +
                ", user=" + user +
                '}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
