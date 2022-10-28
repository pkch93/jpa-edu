package edu.pkch.jpaedu.entity;

import jakarta.persistence.*;

@Entity
@Table
public class PostHashTag extends HashTag {
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Post post;

    protected PostHashTag() {}

    public Post getPost() {
        return post;
    }
}
