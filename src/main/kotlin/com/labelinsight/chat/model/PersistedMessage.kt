package com.labelinsight.chat.model

import javax.persistence.*

@Entity
class PersistedMessage : AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    @Column(name = "value_from")
    var from: String? = null

    @Column(name = "value_text")
    var text: String? = null

    @Column(name = "value_time")
    var time: String? = null

    @Column(name = "value_product")
    var product: String? = null

    constructor(from: String,
                text: String,
                time: String,
                product: String) {
        this.from = from
        this.text = text
        this.time = time
        this.product = product
    }
    constructor() {}
}