package com.chat.api.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "users")
class User(
    private val username: String? = null,
    private val password: String? = null,
    private val createdAt: Date? = null,
    @Id
    private val id: String? = null
)