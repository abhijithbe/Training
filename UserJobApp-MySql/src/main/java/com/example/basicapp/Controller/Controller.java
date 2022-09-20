package com.example.basicapp.Controller;
import com.example.basicapp.JobDao.Job;
import com.example.basicapp.JobDao.JobRepo;
import com.example.basicapp.UserDao.UserRepo;
import com.example.basicapp.UserDao.Users;
import com.example.basicapp.Exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**
 * Controller for the application
 * @author abhijith.be
 */
@RestController
public class Controller {
    @Autowired
    private MessageSource message;
    @Autowired
    private UserRepo repo;
    @Autowired
    private JobRepo job;
    /**
     * Api to fetch all users from database
     * @return -> list of users
     */
    @GetMapping("/users")
    public List<Users> fetchUsers() {

        return repo.findAll();
    }
    /**
     * Api to fetch all jobs from database
     * @return -> list of jobs
     */
    @GetMapping("/job")
    public List<Job> fetchJob() {

        return job.findAll();
    }
    /**
     * Api to obtain specific user of particular id
     * @param id -> id of user that needs to be fetched
     * @return
     */
    @GetMapping("/users/{id}")
    public Users fetchUsers(@PathVariable int id) {
        //Users user=service.fetchOne(id);
        Optional<Users> user=repo.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("id"+id);
        }
        return user.get();
    }
    /**
     * Api to delete specific user
     * @param id -> id of user that need to be deleted
     */
    @DeleteMapping("/users/{id}")
    public void Deleteuser(@PathVariable int id) {
        repo.deleteById(id);
    }
    /**
     * Api to assign the job to the user
     * @param id -> id of user whom the job needs to be assigned
     * @param jobUser -> job of the user
     * @return -> success or exception
     */
    @PostMapping("/users/{id}")
    public String postjob(@PathVariable int id,@RequestBody Job jobUser){
        Optional<Users> user=repo.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("id"+id);
        }
        jobUser.setUser(user.get());
        job.save(jobUser);
        return "success";
    }
    /**
     * Api to save the user to database
     * @param user -> user that needs to be saved
     * @return -> success on saving the user
     */
    @PostMapping("/users")
    public String postuser(@RequestBody Users user){
        repo.save(user);
        return "success";
    }
}
