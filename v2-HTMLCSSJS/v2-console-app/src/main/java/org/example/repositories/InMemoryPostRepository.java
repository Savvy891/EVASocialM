package org.example.repositories;

import org.example.models.Post;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPostRepository implements PostRepository {
    List<Post> posts = new ArrayList<>();


    @Override
    public Post save(Post post) {
        boolean result = posts.add(post);
        if(result){
            return post;
        }

        return null;
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public List<Post> findAllByUsername(String username) {
        // object orient way
//        List<Post> postsWithUsername = new ArrayList<>();
//        for(Post post : posts) {
//            if(post.getUsername().equalsIgnoreCase(username)){
//                postsWithUsername.add(post);
//            }
//        }
//
//        return postsWithUsername;
        //Java 8|| functional programing way
        return posts.stream()
                .filter(post -> post.getUsername().equalsIgnoreCase(username))
                .toList();
    }
}
