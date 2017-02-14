package com.codeup.models;

import javax.persistence.*;

/**
 * Created by abdelmoughit on 2/8/2017.
 */
@Entity
@Table(name="posts")
public class Post{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn (name="user_id") //define at the table level
    UserPost user;

    public UserPost getUser(){
        return user;
    }
    public void setUser(UserPost post){
        this.user=user;
    }


    public Post(String title,String description) {
        this.title=title;
        this.description=description;
    }
    public Post() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }




}
