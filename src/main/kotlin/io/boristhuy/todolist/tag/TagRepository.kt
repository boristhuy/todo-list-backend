package io.boristhuy.todolist.tag

interface TagRepository {
    fun findAllTags(): List<Tag>
}
