package org.example.repositories;

import org.example.models.Comment;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InMemoryCommentRepository implements CommentRepository{
    List<Comment> comments = new ArrayList<>();

    @Override
    public Comment save(Comment comment){
        boolean result = comments.add(comment);
        if(result){
            return comment;
        }
        return null;
    }
    @Override
    public List<Comment> findAll(){
        return comments;
    }

    @Override
    public List<Comment> findAllByPostID(int Id) {
        return List.of();
    }

    @Override
    public List<Comment> findAllByPostId(int id) {
        return List.of();
    }


//    @Override
//    public List<Comment> findAllByPostId(int id){
//        return comments.stream()
//                .filter(comment -> comment.getPostId).equalsIgnoreCase(postId))
//        .toList();
//    } //might be (int postID)


}
