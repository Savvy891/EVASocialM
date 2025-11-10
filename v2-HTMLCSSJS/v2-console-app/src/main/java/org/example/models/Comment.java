package org.example.models;


import java.time.LocalDateTime;
import java.util.Arrays;

public class Comment {
    private long id;
    private String comment;
    private String username;
    private boolean isDraft;
    private int likes;
    private int dislikes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Comment[] comments;
    private static long idCounter = 1;

    private Comment() {}

    public Comment(String comment, String username){
        this.id = idCounter++;
        this.comment = comment;
        this.username = username;
        this.isDraft = true;
        this.likes = 0;
        this.dislikes = 0;
        this.createdAt = LocalDateTime.now();
        this.comments = new Comment[10];
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(long idCounter) {
        Comment.idCounter = idCounter;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", username='" + username + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", comments=" + Arrays.toString(comments) +
                '}';
    }
}
