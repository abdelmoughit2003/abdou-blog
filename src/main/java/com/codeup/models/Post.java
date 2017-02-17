package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Description cannot be empty")
    @Size(min = 5, message = "Description must have at least 5 characters")
    private String description;

    @Column
    private String image;
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }


    @ManyToOne
    @JsonManagedReference
    @JoinColumn (name="user_id") //define at the table level
    private User user;
    public User getUser(){
        return user;
    }
    public void setUser(User user){
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
