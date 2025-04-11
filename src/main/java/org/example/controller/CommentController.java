package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.Comment;
import org.example.service.CommentServiceNPlus1;
import org.example.service.CommentServiceNPlus1Solution;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentServiceNPlus1 commentServiceNPlus1;
    private final CommentServiceNPlus1Solution serviceNPlus1Solution;

    public CommentController(CommentServiceNPlus1 commentServiceNPlus1,
                             CommentServiceNPlus1Solution serviceNPlus1Solution) {
        this.commentServiceNPlus1 = commentServiceNPlus1;
        this.serviceNPlus1Solution = serviceNPlus1Solution;
    }

    @GetMapping("/nplusone")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentServiceNPlus1.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/nplusone/solutionone")
    public ResponseEntity<List<Comment>> getAllCommentsSolution() {
        List<Comment> comments = serviceNPlus1Solution.getAllComments();
        return ResponseEntity.ok(comments);
    }

}
