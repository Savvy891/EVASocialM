package org.example;


import org.example.controllers.PostController;

public class SocialMediaApp {
    public static void main(String[] args) {
        PostController postController = new PostController();
        postController.postStatus();
    }
}
