package com.example.basicapp.JobDao;
import com.example.basicapp.JobDao.Job;
import com.example.basicapp.UserDao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Job interface that extends to JPA repository
 * Job-> userdefined class
 * @author abhijith.be
 */
public interface JobRepo extends JpaRepository<Job,Integer> {

}
