package com.codeup.myservices;
import com.codeup.models.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdelmoughit on 2/8/2017.
 */
@Service("postSvc")
public class PostSvc {
    private List<Post> posts = new ArrayList<>();


    public PostSvc() {
        //This run by the time the class is created
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setId(posts.size()+1);
        posts.add(post);
        return post;
    }

    public Post findOne(int id) {
        return posts.get( id - 1);
    }

    private void createPosts() {
        // create some ad objects and add them to the ads list
        // with the save method
        for(int i=0;i<100;i++){
            save(new Post("title " + (i+1), "Some body content"+ (i+2) ));
        }
    }

}
