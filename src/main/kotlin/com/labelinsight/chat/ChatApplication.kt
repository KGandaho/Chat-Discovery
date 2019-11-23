package com.labelinsight.chat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.labelinsight"])
class ChatApplication

fun main(args: Array<String>) {
	runApplication<ChatApplication>(*args)
}
