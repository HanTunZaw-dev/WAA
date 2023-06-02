package miu.edu.lab2.repo;

import miu.edu.lab2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAll();

    User findById(long id);

    @Query("select u from User u where size(u.posts) > 1")
    List<User> findUsersWithMoreThanOnePost();
}
