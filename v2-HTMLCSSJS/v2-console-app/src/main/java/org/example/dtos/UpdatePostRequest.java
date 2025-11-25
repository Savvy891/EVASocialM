package org.example.dtos;

public record UpdatePostRequest(
        long id,
        String status
) {
}
