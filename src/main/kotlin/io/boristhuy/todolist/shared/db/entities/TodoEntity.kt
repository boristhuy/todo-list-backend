package io.boristhuy.todolist.shared.db.entities

import javax.persistence.*

@Entity
@Table(name = "todo")
class TodoEntity(
    @Id
    @SequenceGenerator(name = "todo_seq")
    @GeneratedValue(generator = "todo_seq", strategy = GenerationType.AUTO)
    val id: Long,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "completed", nullable = false)
    var completed: Boolean = false,

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(name = "todo_tag",
        joinColumns = [JoinColumn(name = "todo_id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id")]
    )
    var tags: Set<TagEntity> = hashSetOf()
)
