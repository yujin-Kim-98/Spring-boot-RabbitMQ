package com.rabbit.sender.rabbitmq.sender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitmqSenderApplication

fun main(args: Array<String>) {
	runApplication<RabbitmqSenderApplication>(*args)
}
