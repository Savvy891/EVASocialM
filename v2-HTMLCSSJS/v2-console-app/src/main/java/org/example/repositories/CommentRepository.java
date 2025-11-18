package org.example.repositories;

import org.example.models.Comment;

import java.util.List;

public interface CommentRepository {
    Comment save(Comment comment);
    List<Comment> findAll();
    List<Comment> findAllByPostID(int Id);

    List<Comment> findAllByPostId(int id) //might be (int postID)
    ;
}
