package edu.pkch.jpa;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long memberNumber;

    @Column(length = 100)
    private String nickname;

    public Member() {}

    public Member(Long memberNumber, String nickname) {
        this.memberNumber = memberNumber;
        this.nickname = nickname;
    }
}
