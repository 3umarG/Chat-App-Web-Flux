package com.chat.api.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "messages")
class Message(
    val userId: String? = null,
    val username: String? = null,
    val message: String? = null,
    val channelId: String? = null,
    @Indexed
    var timestamp: Date? = null,
    @Id
    val id: String? = null
)