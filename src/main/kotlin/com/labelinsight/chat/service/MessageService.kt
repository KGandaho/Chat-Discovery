package com.labelinsight.chat.service

import com.labelinsight.chat.model.Message
import com.labelinsight.chat.model.OutputMessage
import com.labelinsight.chat.model.PersistedMessage
import com.labelinsight.chat.repository.OutPutMessageRepository
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

@Service
class MessageService (private val outPutMessageRepository: OutPutMessageRepository) {

    fun saveMessage(outputMessage: OutputMessage, product:String) {
        val persistedMessage = PersistedMessage()
        persistedMessage.from = outputMessage.from
        persistedMessage.product = product
        persistedMessage.text = outputMessage.text
        persistedMessage.time = outputMessage.time

        outPutMessageRepository.save(persistedMessage)
    }

    fun createOutputMessage(message: Message):OutputMessage {
        val time = SimpleDateFormat("EEE, MMM d, ''yy h:mm a").format(Date())

        return OutputMessage(message.from,
                             message.text,
                             time)
    }
    fun getChatByProduct(product: String):List<PersistedMessage> {
        return outPutMessageRepository.findAllByProduct(product)
    }
}


