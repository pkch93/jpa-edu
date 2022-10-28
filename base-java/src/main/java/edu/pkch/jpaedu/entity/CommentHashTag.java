package edu.pkch.jpaedu.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class CommentHashTag extends HashTag {
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    protected CommentHashTag() {}

    public List<Comment> getComments() {
        return comments;
    }
}
