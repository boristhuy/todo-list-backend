package io.boristhuy.todolist.todo.db

import io.boristhuy.todolist.todo.Todo
import io.boristhuy.todolist.todo.TodoRepository
import org.springframework.stereotype.Repository

@Repository
class TodoRepositoryImpl(val jpaTodoRepository: JpaTodoRepository) : TodoRepository {

    override fun findAllTodos(): List<Todo> {
        val todoEntities = jpaTodoRepository.findAll();
        return todoEntities.map { entity -> entity.toTodo() }
    }

    override fun saveTodo(todo: Todo): Todo {
        val todoEntity = jpaTodoRepository.save(todo.toTodoEntity())
        return todoEntity.toTodo();
    }

    override fun editTodo(todo: Todo) {
        jpaTodoRepository.save(todo.toTodoEntity())
    }

    override fun deleteTodo(id: Long) {
        jpaTodoRepository.deleteById(id)
    }

}

fun Todo.toTodoEntity() = TodoEntity(
        id = id,
        title = title,
        completed = completed
)

fun TodoEntity.toTodo() = Todo(
        id = id,
        title = title,
        completed = completed
)
