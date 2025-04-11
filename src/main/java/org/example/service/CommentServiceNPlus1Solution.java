package org.example.service;


import org.example.dto.Comment;
import org.example.repository.CommentsRepositoryNPlusOneSolution;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceNPlus1Solution {
    private final CommentsRepositoryNPlusOneSolution commentsRepositoryNPlusOneSolution;

    public CommentServiceNPlus1Solution(CommentsRepositoryNPlusOneSolution commentsRepositoryNPlusOneSolution) {
        this.commentsRepositoryNPlusOneSolution = commentsRepositoryNPlusOneSolution;
    }

    public List<Comment> getAllComments() {
        return commentsRepositoryNPlusOneSolution.findAll();
    }
}
