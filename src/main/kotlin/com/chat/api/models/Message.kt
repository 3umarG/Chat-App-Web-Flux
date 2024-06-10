package com.chat.api.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "messages")
class Message(
    private val userId: String? = null,
    private val username: String? = null,
    private val message: String? = null,
    private val timestamp: Date? = null,
    @Id
    private val id: String? = null
)