package org.example;

import org.example.models.Post;


public class SocialMediaApp {
    public static void main(String[] args) {

        Post post = new Post("Test Post", "testuser001");
        Post post2 = new Post("Test Post 2","testuser002");
        System.out.println(post.getStatus());
        System.out.println(post.getUsername());
        System.out.println(post.getCreatedAt());
        System.out.println(post.isDraft());
        System.out.println(post.getId());
        System.out.println(post2.getId());
        System.out.println(post.getIdCounter());
        post.setIdCounter(10);
        System.out.println(Post.getIdCounter());
        System.out.println(post2.getIdCounter());
        System.out.println(post.toString());


    }
}
