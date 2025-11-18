package org.example.repositories;

import org.example.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    List<Post> findAll();
    List<Post>findAllByUsername(String username);
    Optional<Post> findById(long id);
    boolean deleteById(long id);

}
