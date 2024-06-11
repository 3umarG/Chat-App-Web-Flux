package com.chat.api.repositories

import com.chat.api.models.Message
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.Tailable
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface MessagesRepository : ReactiveMongoRepository<Message, String> {

    @Tailable
    fun findAllByChannelIdIsNull(pageable: Pageable) : Flux<Message>
}