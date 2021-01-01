package io.boristhuy.todolist.todo

interface TodoRepository {
    fun findAllTodos(): List<Todo>

    fun saveTodo(todo: Todo): Todo

    fun editTodo(todo: Todo)

    fun deleteTodo(id: Long)
}
