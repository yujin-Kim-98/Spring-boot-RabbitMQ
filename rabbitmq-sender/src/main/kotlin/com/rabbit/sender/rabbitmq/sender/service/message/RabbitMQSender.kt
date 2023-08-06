package com.rabbit.sender.rabbitmq.sender.service.message

import org.slf4j.LoggerFactory
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RabbitMQSender(
    @Value("\${sample.rabbitmq.exchange}") val exchange: String,
    @Value("\${sample.rabbitmq.routing-key}") val routingKey: String,
    private val rabbitTemplate: AmqpTemplate
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun sendMessage(
        message: String
    ) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message)
        logger.info("RabbitMQ Message Send. Message: {}", message)
    }

}