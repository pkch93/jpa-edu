package edu.pkch.jpa

import javax.persistence.*

@Entity
@Table(name = "member")
class MemberK(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val memberNumber: Long,

    @Column(length = 100)
    val nickname: String
)