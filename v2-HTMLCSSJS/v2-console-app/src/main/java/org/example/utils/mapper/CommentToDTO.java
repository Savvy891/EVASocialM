package org.example.utils.mapper;

import org.example.dtos.CommentInformation;
import org.example.models.Comment;

public class CommentToDTO {
    public static CommentInformation commentDTO (Comment comment){
        return new CommentInformation(
                comment.getId(),
                comment.getUsername(),
                comment.getComment(),
                comment.getLikes(),
                comment.getDislikes()
        );
    }
}
