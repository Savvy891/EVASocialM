package org.example.dtos;

public record PostNewCommentRequest(
        String comment,
        String username,
        long postId
) {
}
