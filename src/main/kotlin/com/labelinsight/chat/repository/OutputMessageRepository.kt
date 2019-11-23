package com.labelinsight.chat.repository

import com.labelinsight.chat.model.PersistedMessage
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface OutPutMessageRepository : PagingAndSortingRepository<PersistedMessage, Int> {

    fun findAllByProduct(product:String):List<PersistedMessage>
}
