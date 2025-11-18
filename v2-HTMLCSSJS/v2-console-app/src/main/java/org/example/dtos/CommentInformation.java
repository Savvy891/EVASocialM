package org.example.dtos;

// remember you have questions about this page
// ask Mathew to explain what's happening

public record CommentInformation(
        long id,
        String comment,
        String username,
        int likes,
        int dislikes
) {
}
