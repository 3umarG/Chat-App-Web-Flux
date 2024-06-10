package com.chat.api

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.CollectionOptions
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
class MongoConfig {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(MongoConfig::class.java)
    }

    @Bean
    fun init(mongoTemplate: MongoTemplate): CommandLineRunner {
        return CommandLineRunner { _ ->

            LOGGER.info("Init method ....")
            if (!mongoTemplate.collectionExists("messages")) {
                LOGGER.info("Create Collection ...")
                mongoTemplate.createCollection(
                    "messages", CollectionOptions.empty()
                        .capped()
                        .size(5000000)
                        .maxDocuments(10000)
                )
            }
        }
    }

}