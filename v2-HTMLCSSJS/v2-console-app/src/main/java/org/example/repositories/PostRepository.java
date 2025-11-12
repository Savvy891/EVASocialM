package org.example.repositories;

import org.example.models.Post;

import java.util.List;

public interface PostRepository {
    Post save(Post post);
    List<Post> findAll();
    List<Post>findAllByUsername(String username);

}
