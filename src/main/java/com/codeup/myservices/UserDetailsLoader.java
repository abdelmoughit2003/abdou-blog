

package com.codeup.myservices;
        import com.codeup.models.UserPost;
        import com.codeup.models.repositories.Roles;
        import com.codeup.models.repositories.Users;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
        import org.springframework.stereotype.Service;
        import java.util.List;

@Service("customUserDetailsService")
public class UserDetailsLoader implements UserDetailsService {
    private final Users users;
    private final Roles roles;

    @Autowired
    public  UserDetailsLoader(Users users, Roles roles) {
        this.users = users;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPost user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        List<String> userRoles = roles.ofUserWith(username);
        return new UserWithRoles(user, userRoles);
    }
}