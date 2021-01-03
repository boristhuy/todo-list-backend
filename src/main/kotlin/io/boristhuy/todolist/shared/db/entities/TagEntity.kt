package io.boristhuy.todolist.shared.db.entities

import javax.persistence.*

@Entity
@Table(name = "tag")
class TagEntity(
    @Id
    @SequenceGenerator(name = "tag_seq")
    @GeneratedValue(generator = "tag_seq", strategy = GenerationType.AUTO)
    val id: Long,

    @Column(name = "title", nullable = false)
    var title: String
)
