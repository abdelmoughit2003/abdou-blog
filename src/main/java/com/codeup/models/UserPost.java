package com.codeup.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by abdelmoughit on 2/10/2017.
 */
@Entity
@Table(name="post_users")

public class UserPost {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  @Column(nullable = false)
  String username;

  @Column(nullable = false)

  String email;
  @Column(nullable = false)
  String password;

  @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
  List<Post> posts;//these are all the posts created by the user
  public UserPost(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }


  public UserPost() {
  }
  public UserPost(UserPost user) {
    id = user.id;
    username = user.username;
    password = user.password;
    email = user.email;
    posts = user.posts;
  }





  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }




}
