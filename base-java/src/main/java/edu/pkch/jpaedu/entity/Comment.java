package edu.pkch.jpaedu.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Lob
    private String content;

    @JoinColumn(name = "comment_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Post post;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CommentHashTag> hashTags;

    protected Comment() {}

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Post getPost() {
        return post;
    }

    public List<CommentHashTag> getHashTags() {
        return hashTags;
    }
}
