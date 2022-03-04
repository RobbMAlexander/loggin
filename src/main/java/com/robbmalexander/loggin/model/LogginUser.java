package com.robbmalexander.loggin.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class LogginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String username;
    String password;

    public LogginUser(){
    }

    public LogginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy="userPostedBy")
    @OrderBy("postId")
    List<Post> userPosts;

    public List<Post> getUserPosts(){
        return userPosts;
    }

}
