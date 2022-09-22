package com.example.basicapp.UserDao;
import com.example.basicapp.UserDao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * User interface that extends to JPA repository
 * Users -> userdefined class
 * @author abhijith.be
 */
public interface UserRepo extends JpaRepository<Users,Integer> {
}
