package com.example.intelligentfirewarningsystem.entity

data class Receive(
    var temp: String? = null,// 温度
    var temp_v: String? = null, // 温度阈值
    var mq2: String? = null,// 烟雾浓度
    var mq2_v: String? = null,// 烟雾浓度阈值
    var fire: String? = null,// 检测火焰状态，只有1（关闭）或0
    var relay: String? = null// 水泵状态，只有0（关闭）或1

)
