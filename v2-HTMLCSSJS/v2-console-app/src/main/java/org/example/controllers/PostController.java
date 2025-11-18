package org.example.controllers;

import org.example.dtos.PostInformation;
import org.example.dtos.PostNewPostRequest;
import org.example.services.PostService;

import java.util.Scanner;

public class PostController {
    private PostService postService;
    private Scanner scanner;

    public PostController(PostService postService, Scanner scanner) {
        this.postService = postService;
        this.scanner = scanner;
    }

    /**
     * Ask the user for a status and username, create a new post and show the
     * created post information. This action will create a draft post (see
     * {"@link org.example.models.Post"}) which can be finalized later.
     */
    public void postStatus() {
        System.out.println("Please input your status!");
        String status = scanner.nextLine();
        System.out.println("Please enter your username!");
        String username = scanner.nextLine();
        System.out.println("Creating Post.....");
        PostInformation postInformation = postService.createPost(new PostNewPostRequest(status, username));
        System.out.println("Post Created");
        System.out.println(postInformation);
    }

    /**
     * Retrieve and print all non-draft posts (the service filters drafts)
     */
    public void viewAllPosts() {
        System.out.println("Here is all of the available posts:");
        postService.getAllPosts().forEach(System.out::println);
    }

    /**
     * List posts for a username, prompt for an id, and mark the chosen post as
     * no longer a draft.
     */
    public void changeDraftStatus() {
        System.out.println("please enter your username");
        String username = scanner.nextLine();
        postService.findAllByUsername(username).forEach(System.out::println);
        System.out.println("Please enter an id to final a post");
        int choice = scanner.nextInt();
        postService.changeDraftStatus(choice);
    }

    public void deletePostPrompt() {
        System.out.println("Please enter your username");
        String username = scanner.nextLine();
        postService.findAllByUsername(username).forEach(System.out::println);
        System.out.println("pleae enter a id to delete post");
        int choice = scanner.nextInt();
        postService.deletePostById(choice);


    }
}

