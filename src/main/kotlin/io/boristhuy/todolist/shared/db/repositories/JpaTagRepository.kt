package io.boristhuy.todolist.shared.db.repositories

import io.boristhuy.todolist.shared.db.entities.TagEntity
import org.springframework.data.repository.CrudRepository

interface JpaTagRepository : CrudRepository<TagEntity, Long>
