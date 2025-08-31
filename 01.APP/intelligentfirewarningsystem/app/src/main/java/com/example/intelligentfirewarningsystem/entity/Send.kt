package com.example.intelligentfirewarningsystem.entity

data class Send(
    var cmd: Int,
    var mq2_v: Int? = null,
    var temp_v: Int? = null,
    var relay: Int? = null
)
