package io.boristhuy.todolist.todo.db

import javax.persistence.*

@Entity
@Table(name = "TODO")
class TodoEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long,

        @Column(name = "TITLE", nullable = false)
        var title: String,

        @Column(name = "COMPLETED", nullable = false)
        var completed: Boolean = false
)
