package com.example.blog.repository;

import com.example.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostReposirory extends CrudRepository <Post, Long> {
}
