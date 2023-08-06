package com.rabbit.sender.rabbitmq.sender.rest.dto

data class SendMessageRequest(
    val message: String
)

data class SignInRequest(
    val email: String,
    val password: String
)

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String,
    val age: Int
)