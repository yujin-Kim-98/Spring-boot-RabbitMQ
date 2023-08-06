package com.rabbit.sender.rabbitmq.sender.config

import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig(
    @Value("\${sample.rabbitmq.queue}") val queueName: String,
    @Value("\${sample.rabbitmq.exchange}") val exchange: String,
    @Value("\${sample.rabbitmq.routing-key}") val routingKey: String,
) {

    @Bean
    fun queue(): Queue = Queue(queueName, false)

    @Bean
    fun exchange(): TopicExchange = TopicExchange(exchange)

    @Bean
    fun binding(
        queue: Queue,
        exchange: TopicExchange
    ): Binding {
        return BindingBuilder
            .bind(queue)
            .to(exchange)
            .with(routingKey)
    }

    @Bean
    fun jsonMessageConverter(): MessageConverter = Jackson2JsonMessageConverter()

    @Bean
    fun rabbitTemplate(
        connectionFactory: ConnectionFactory
    ): AmqpTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = jsonMessageConverter()
        return rabbitTemplate
    }

}