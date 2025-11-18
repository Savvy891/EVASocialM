package org.example.utils.mapper;


import org.example.dtos.PostInformation;
import org.example.models.Post;

public class PostMapper {
    public static PostInformation toDto(Post post) {
        return new PostInformation(
                post.getId(),
                post.getStatus(),
                post.getUsername(),
                post.getLikes(),
                post.getDislikes(),
                post.getComments()
        );
    }
}
