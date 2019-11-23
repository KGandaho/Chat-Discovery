package com.labelinsight.chat.controller

import com.labelinsight.chat.message.Message
import com.labelinsight.chat.message.OutputMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.DestinationVariable
import java.text.SimpleDateFormat
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import java.util.*
import org.springframework.stereotype.Controller



@Controller
class MessageController {


    @Autowired
    private val simpMessagingTemplate: SimpMessagingTemplate? = null

    @MessageMapping("/chat/{product}")
    @Throws(Exception::class)
    fun send(message: Message, @DestinationVariable product: String) {
        val time = SimpleDateFormat("HH:mm").format(Date())
        simpMessagingTemplate?.convertAndSend("/topic/$product", OutputMessage(message.from, message.text, time))
    }
}