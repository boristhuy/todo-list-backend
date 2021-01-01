package io.boristhuy.todolist.todo

class Todo(val id: Long, var title: String, var completed: Boolean, var tags: List<String>? = emptyList()) {

}
