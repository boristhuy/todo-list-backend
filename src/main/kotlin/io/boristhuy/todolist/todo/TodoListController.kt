package io.boristhuy.todolist.todo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoListController(val todoRepository: TodoRepository) {

    @GetMapping
    fun getTodos(): List<Todo> {
        return todoRepository.findAllTodos()
    }

    @PostMapping
    fun addTodo(@RequestBody todo: Todo): Todo {
        return todoRepository.saveTodo(todo)
    }

    @PutMapping("/{id}")
    fun editTodo(@RequestBody todo: Todo, @PathVariable id: Long) {
        return todoRepository.editTodo(todo)
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long) {
        return todoRepository.deleteTodo(id)
    }
}
