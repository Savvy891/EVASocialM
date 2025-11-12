package org.example.controllers;

import org.example.dtos.PostInformation;
import org.example.dtos.PostNewPostRequest;
import org.example.services.PostService;

import java.util.Scanner;

public class PostController {
    private PostService postService = new PostService();
    private Scanner scanner = new Scanner(System.in);

    public void postStatus(){
        System.out.println("Please enter your status...");
        String status = scanner.nextLine();
        System.out.println("Please enter your username... ");
        String username = scanner.nextLine();
        System.out.println("Creating Post...");
        PostInformation postInformation = postService.createPost(new PostNewPostRequest(status, username));
        System.out.println("Post Created");
        System.out.println(postInformation);


    }

}
