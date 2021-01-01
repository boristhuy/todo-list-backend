package io.boristhuy.todolist.todo.db

import org.springframework.data.repository.CrudRepository

interface JpaTodoRepository : CrudRepository<TodoEntity, Long> {
}
