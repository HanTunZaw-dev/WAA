package miu.edu.lab.repo;

import miu.edu.lab.domain.PostUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostUserRepo extends CrudRepository<PostUser, Long> {
    List<PostUser> findAll();

    //@Query(value = "SELECT * FROM post_user u WHERE u.ID=:id ", nativeQuery = true)
    PostUser findById(long id);

    @Query(value = "SELECT u FROM PostUser u WHERE u.posts.size > 1")
        //@Query(value = "SELECT u.* FROM USER u WHERE (SELECT COUNT(p.*) FROM POST p WHERE p.USER_ID=u.ID)>1", nativeQuery = true)
    List<PostUser> findUsersWithMoreThanOnePost();

    @Query(value = "SELECT u FROM PostUser u WHERE u.posts.size > :n")
    List<PostUser> findUsersWithMoreThanNPosts(int n);


}
