package edu.pkch.jpa

import javax.persistence.*

@Entity
@Table(name = "post")
class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column
    var title: String,

    @Lob @Column
    var contents: String,

    @ManyToOne
    var member: Member
)