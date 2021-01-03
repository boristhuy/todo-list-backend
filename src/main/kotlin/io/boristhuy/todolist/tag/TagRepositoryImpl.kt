package io.boristhuy.todolist.tag

import io.boristhuy.todolist.shared.db.entities.TagEntity
import io.boristhuy.todolist.shared.db.repositories.JpaTagRepository
import org.springframework.stereotype.Repository

@Repository
class TagRepositoryImpl(val jpaTagRepository: JpaTagRepository) : TagRepository {

    override fun findAllTags(): List<Tag> {
        return this.jpaTagRepository.findAll().map(::toTag)
    }

}

fun toTag(entity: TagEntity) = Tag(
    id = entity.id,
    title = entity.title
)
