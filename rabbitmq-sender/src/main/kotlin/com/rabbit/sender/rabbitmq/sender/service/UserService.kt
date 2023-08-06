package com.rabbit.sender.rabbitmq.sender.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.rabbit.sender.rabbitmq.sender.rest.dto.SignInRequest
import com.rabbit.sender.rabbitmq.sender.rest.dto.SignUpRequest
import com.rabbit.sender.rabbitmq.sender.service.message.RabbitMQSender
import org.springframework.stereotype.Service

@Service
class UserService(
    private val sender: RabbitMQSender
) {

    fun signIn(
        request: SignInRequest
    ) {
        val mapper = ObjectMapper().registerKotlinModule()
        sender.sendMessage(
            message = mapper.writeValueAsString(request)
        )
    }

    fun signUp(
        request: SignUpRequest
    ) {
        val mapper = ObjectMapper().registerKotlinModule()
        sender.sendMessage(
            message = mapper.writeValueAsString(request)
        )
    }

}
