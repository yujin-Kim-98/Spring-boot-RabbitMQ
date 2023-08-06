package com.rabbit.receiver.rabbitmq.receiver.service.message

import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicLong

@Component
class RabbitMQListener(
    @Value("\${sample.rabbitmq.queue}") val queueName: String
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    private final val count = AtomicLong(0L)

    @RabbitListener(queues = ["\${sample.rabbitmq.queue}"])
    fun listenerMessageJson(
        message: String
    ) {
        logger.info(
            "RabbitMQ Message Receiver. ${count.incrementAndGet()} Received = {}",
            message
        )
    }

}