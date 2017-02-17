package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by abdelmoughit on 2/10/2017.
 */
@Entity
@Table(name="post_users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  @NotBlank(message = "Enter a username")
  private String username;

  @Column(nullable = false)
  @NotBlank(message = "Enter a valid email")

  @Email(message = "Enter a valid email address")
  private String email;

  @Column(nullable = false)
  @NotBlank(message = "Enter a username")
  @Size(min =8, message="Your password must have at least 8 charachters")
  @JsonIgnore
  private String password;

  @OneToMany(mappedBy = "user")
  @JsonBackReference
  private List<Post> posts;//these are all the posts created by the user

  public User() {

  }
  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }



  public User(User user) {
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
