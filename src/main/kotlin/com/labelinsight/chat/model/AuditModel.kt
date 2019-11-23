package com.labelinsight.chat.model

import org.springframework.data.annotation.LastModifiedDate
import javax.persistence.TemporalType
import org.springframework.data.annotation.CreatedDate
import java.io.Serializable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import javax.persistence.Temporal


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
@JsonIgnoreProperties(value = ["createdAt", "updatedAt"], allowGetters = true)
abstract class AuditModel : Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    var createdAt: Date? = null

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    var updatedAt: Date? = null
}