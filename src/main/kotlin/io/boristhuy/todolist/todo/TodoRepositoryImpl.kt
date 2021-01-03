package io.boristhuy.todolist.todo

import io.boristhuy.todolist.shared.db.entities.TodoEntity
import io.boristhuy.todolist.tag.Tag
import io.boristhuy.todolist.shared.db.entities.TagEntity
import io.boristhuy.todolist.shared.db.repositories.JpaTodoRepository
import org.springframework.stereotype.Repository

@Repository
class TodoRepositoryImpl(val jpaTodoRepository: JpaTodoRepository) : TodoRepository {

    override fun findAllTodos(): List<Todo> {
        return jpaTodoRepository.findAll().map(::toTodo)
    }

    override fun saveTodo(todo: Todo): Todo {
        val todoEntity = jpaTodoRepository.save(toTodoEntity(todo))
        return toTodo(todoEntity)
    }

    override fun editTodo(todo: Todo) {
        jpaTodoRepository.save(toTodoEntity(todo))
    }

    override fun deleteTodo(id: Long) {
        jpaTodoRepository.deleteById(id)
    }

}

fun toTodoEntity(todo: Todo) = TodoEntity(
    id = todo.id,
    title = todo.title,
    completed = todo.completed,
    tags = todo.tags.map(::toTagEntity).toSet()
)

fun toTodo(entity: TodoEntity) = Todo(
    id = entity.id,
    title = entity.title,
    completed = entity.completed,
    tags = entity.tags.map(::toTag).toSet()
)

fun toTagEntity(tag: Tag) = TagEntity(
    id = tag.id,
    title = tag.title
)

fun toTag(entity: TagEntity) = Tag(
    id = entity.id,
    title = entity.title
)
