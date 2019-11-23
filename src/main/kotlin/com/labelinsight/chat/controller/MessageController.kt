package com.labelinsight.chat.controller

import com.labelinsight.chat.message.Message
import com.labelinsight.chat.message.OutputMessage
import java.text.SimpleDateFormat
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.handler.annotation.MessageMapping
import java.util.*
import org.springframework.stereotype.Controller


@Controller
class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    @Throws(Exception::class)
    fun send(message: Message): OutputMessage {

        val time = SimpleDateFormat("HH:mm").format(Date())
        return OutputMessage(message.from, message.text, time)
    }

}