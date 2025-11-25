package org.example.services;

import org.example.dtos.PostInformation;
import org.example.dtos.PostNewPostRequest;
import org.example.dtos.UpdatePostRequest;
import org.example.exceptions.PostNotFoundException;
import org.example.models.Post;
import org.example.repositories.PostRepository;
import org.example.utils.mapper.PostMapper;

import java.util.List;
import java.util.function.Predicate;

/**
 * Service layer that encapsulates business rules and interactions with the
 * {@link PostRepository}. The service accepts request DTOs, performs any
 * necessary validation or transformation, and returns response DTOs used by
 * the UI layer.
 *
 * This implementation is intentionally small — it primarily handles creating
 * posts, returning non-draft posts, and toggling draft status.
 */
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Create a new Post based on the incoming request. The Post object itself
     * sets default values (draft=true, timestamps). The repository persists
     * the post and the created entity is mapped to a DTO for presentation.
     *
     * @param request request object containing status and username
     * @return information DTO representing the created post
     */
    public PostInformation createPost(PostNewPostRequest request) {
        Post post = new Post(request.status(), request.username());
        postRepository.save(post);
        return PostMapper.toDto(post);
    }

    /**
     * Return all posts that are not marked as drafts. Mapping from domain
     * model to DTO happens here so the UI only consumes DTOs.
     */
    public List<PostInformation> getAllPosts() {
        // Stream-based implementation: filter out drafts and map to DTO
        return postRepository.findAll().stream()
//                .peek(p -> System.out.println("Before Filter" + p.toString()))
                .filter(Predicate.not(Post::isDraft))
//                .peek(p -> System.out.println("After Filter" + p.toString()))
                .map(PostMapper::toDto)
                .toList();
    }

    /**
     * Find a post by id and mark it as no longer a draft. Returns true when
     * the post was found and updated, false otherwise.
     */
    public boolean changeDraftStatus(long id) {
        Post post = postRepository.findAll().stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (post == null) return false;
        post.setDraft(false);
        return true;
    }

    /**
     * Return all posts (including drafts) authored by the provided username,
     * mapped to DTOs for display purposes.
     */
    public List<PostInformation> findAllByUsername(String username) {
        return postRepository.findAllByUsername(username).stream().map(PostMapper::toDto).toList();
    }

    public boolean deletePostById(long id) {
        postRepository.findById(id).orElseThrow(() ->
                new PostNotFoundException("Post with id of " + id + " not found!"));
        return postRepository.deleteById(id);
    }

    public PostInformation updatePost(UpdatePostRequest request) {
        Post post = postRepository.findById(request.id()).orElseThrow(
                () -> new PostNotFoundException("Post with id of "+ request.id() + " not found")
        );
        post.setStatus(request.status());
        return PostMapper.toDto(post);
    }
}
