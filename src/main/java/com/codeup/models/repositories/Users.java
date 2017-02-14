package com.codeup.models.repositories;

import com.codeup.models.UserPost;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by abdelmoughit on 2/10/2017.
 */
public interface Users extends CrudRepository<UserPost,Long> {
    public UserPost findByUsername(String username);
}
