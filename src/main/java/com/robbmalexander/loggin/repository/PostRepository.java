package com.robbmalexander.loggin.repository;

import com.robbmalexander.loggin.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByUserName(String username);
}
