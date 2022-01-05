package edu.pkch.jpa

import javax.persistence.*

@Entity
@Table(name = "post")
class PostK(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val title: String,

    @Lob @Column
    val contents: String,

    @ManyToOne
    val member: MemberK
)