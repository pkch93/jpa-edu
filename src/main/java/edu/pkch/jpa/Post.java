package edu.pkch.jpa;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String title;

    @Lob
    @Column
    private String content;

    @ManyToOne
    private MemberK member;

    protected Post() {}

    public Post(String title, String content, MemberK member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }
}
