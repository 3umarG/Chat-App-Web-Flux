package com.chat.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration


@SpringBootApplication
@Configuration
class ChatAppEnhancedApplication

fun main(args: Array<String>) {
    runApplication<ChatAppEnhancedApplication>(*args)
}

