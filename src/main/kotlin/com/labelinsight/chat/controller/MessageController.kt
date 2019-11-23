package com.labelinsight.chat.controller

import com.labelinsight.chat.model.Message
import com.labelinsight.chat.model.OutputMessage
import com.labelinsight.chat.model.PersistedMessage
import com.labelinsight.chat.repository.OutPutMessageRepository
import com.labelinsight.chat.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.DestinationVariable
import java.text.SimpleDateFormat
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import java.util.*
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.util.UUID

@Controller
class MessageController {

    @Autowired
    private val simpMessagingTemplate: SimpMessagingTemplate? = null

    @Autowired
    private val messageService: MessageService? = null

    @Autowired
    private val outputMessageRepository: OutPutMessageRepository? = null

    @MessageMapping("/chat/{product}")
    @Throws(Exception::class)
    fun send(message: Message, @DestinationVariable product: String) {

        val outputMessage = messageService?.createOutputMessage(message)
        if (outputMessage != null) {
            messageService?.saveMessage(outputMessage, product)
        }

        if (outputMessage != null) {
            simpMessagingTemplate?.convertAndSend("/topic/$product", outputMessage)
        }
    }

    @RequestMapping("chat/history/{product}")
    fun getChat(@PathVariable product: String, model: Model):String {

        val chatHistory = messageService!!.getChatByProduct(product)
        model.addAttribute("chatHistory", chatHistory)
        messageService!!.getChatByProduct(product)

        return "chat-history.html"
    }

}