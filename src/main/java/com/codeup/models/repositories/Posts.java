package com.codeup.models.repositories;

import com.codeup.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by abdelmoughit on 2/9/2017.
 */
@Repository
public interface Posts extends CrudRepository<Post,Long> {

@Query ("select p from Post p where p.title like ?1")

     List<Post> findWhereTitleLike(String title);
}
