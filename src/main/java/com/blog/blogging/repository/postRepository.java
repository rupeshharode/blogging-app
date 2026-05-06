package com.blog.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blogging.model.post;

public interface postRepository extends JpaRepository<post, Integer>
 {


}
