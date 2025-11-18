package org.example.services;

import org.example.dtos.CommentInformation;
import org.example.dtos.PostNewCommentRequest;
import org.example.models.Comment;
import org.example.repositories.CommentRepository;
import org.example.repositories.InMemoryCommentRepository;
import org.example.utils.mapper.CommentToDTO;

public class CommentService {
    private CommentRepository commentRepository = new InMemoryCommentRepository();
    public CommentInformation createComment(PostNewCommentRequest request){
        Comment comment = new Comment(request.comment(), request.username());
        comment.setPostId(request.postId());
        commentRepository.save(comment);
        return CommentToDTO.commentDTO(comment);
    }
}
