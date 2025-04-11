package org.example.repository;

import org.example.dto.Comment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepositoryNPlusOneSolution extends JpaRepository<Comment, Long> {
    @EntityGraph(attributePaths = "topic")
    List<Comment> findAll();
}
