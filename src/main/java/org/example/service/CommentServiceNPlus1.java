package org.example.service;


import org.example.dto.Comment;
import org.example.repository.CommentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceNPlus1 {
    private final CommentsRepository commentsRepository;

    public CommentServiceNPlus1(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public List<Comment> getAllComments() {
        return commentsRepository.findAll();
    }
}
