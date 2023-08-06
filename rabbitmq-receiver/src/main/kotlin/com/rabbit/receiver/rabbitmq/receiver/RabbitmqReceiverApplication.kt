package com.rabbit.receiver.rabbitmq.receiver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitmqReceiverApplication

fun main(args: Array<String>) {
	runApplication<RabbitmqReceiverApplication>(*args)
}
