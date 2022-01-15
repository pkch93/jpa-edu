package edu.pkch.jpa

import javax.persistence.*

@Entity
@Table(name = "member")
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column
    var memberNumber: Long,

    @Column(length = 100)
    var nickname: String
)