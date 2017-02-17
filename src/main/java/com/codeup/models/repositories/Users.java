package com.codeup.models.repositories;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by abdelmoughit on 2/10/2017.
 */
public interface Users extends CrudRepository<User,Long> {
     User findByUsername(String username);
}
