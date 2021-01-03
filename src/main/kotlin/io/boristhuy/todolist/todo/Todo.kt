package io.boristhuy.todolist.todo

import io.boristhuy.todolist.tag.Tag

class Todo(
    val id: Long,
    var title: String,
    var completed: Boolean = false,
    var tags: Set<Tag> = hashSetOf()
)
