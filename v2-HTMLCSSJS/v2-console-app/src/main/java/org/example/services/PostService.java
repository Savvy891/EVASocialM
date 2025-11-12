package org.example.services;

import org.example.dtos.PostInformation;
import org.example.dtos.PostNewPostRequest;
import org.example.models.Post;
import org.example.repositories.InMemoryPostRepository;
import org.example.repositories.PostRepository;

import java.util.Arrays;

public class PostService {
    private PostRepository postRepository = new InMemoryPostRepository();

    public PostInformation createPost(PostNewPostRequest request) {
        Post post = new Post(request.status(), request.username());
        postRepository.save(post);
        return new PostInformation(
                post.getId(),
                post.getStatus(),
                post.getUsername(),
                post.getLikes(),
                post.getDislikes(),
                Arrays.asList(post.getComments())
        );

    }
}
