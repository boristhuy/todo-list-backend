package io.boristhuy.todolist.tag

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tags")
class TagController(val tagRepository: TagRepository) {

    @GetMapping
    fun getTags(): List<Tag> {
        return this.tagRepository.findAllTags()
    }
}
