package org.example.dtos;

import org.example.models.Comment;

import java.util.List;

public record PostInformation(
        long id,
        String status,
        String username,
        int likes,
        int dislikes,
        List<Comment> comments
) {
}
