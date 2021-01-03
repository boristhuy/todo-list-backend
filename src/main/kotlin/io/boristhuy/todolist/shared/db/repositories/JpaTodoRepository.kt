package io.boristhuy.todolist.shared.db.repositories

import io.boristhuy.todolist.shared.db.entities.TodoEntity
import org.springframework.data.repository.CrudRepository

interface JpaTodoRepository : CrudRepository<TodoEntity, Long>
