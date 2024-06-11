package com.chat.api.controllers

import com.chat.api.models.Message
import com.chat.api.repositories.MessagesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.Date


@RestController
@RequestMapping("/flux")
class MessagesController @Autowired constructor(private val messagesRepo: MessagesRepository) {

    @PostMapping("/chats")
    @ResponseStatus(HttpStatus.CREATED)
    fun postChat(@RequestBody chatMessage: Message): Mono<Message> {
        chatMessage.timestamp = Date()
        return messagesRepo.save(chatMessage)
    }

    @GetMapping(
        "/chats/stream",
        produces = [MediaType.TEXT_EVENT_STREAM_VALUE]
    )
    fun streamMessages(@RequestParam page: Int): Flux<Message> {
        val pageable = PageRequest.of(page, 5, Sort.by(Sort.Order.desc("timestamp")))
        return messagesRepo.findAllByChannelIdIsNull(pageable)
    }
}