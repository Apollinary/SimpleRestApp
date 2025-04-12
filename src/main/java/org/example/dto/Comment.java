package org.example.dto;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String text;
    @ManyToOne//(fetch = FetchType.LAZY)
    private Topic topic;

    public Comment(String text) {
        this.text = text;
    }

}