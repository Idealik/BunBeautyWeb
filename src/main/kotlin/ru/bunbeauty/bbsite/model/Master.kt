package ru.bunbeauty.bbsite.model

import org.springframework.lang.Nullable

data class Master(
        @Nullable
        val id: String = "",
        val masterName: String = "",
        val phone: String = "",
        val activityKind: String = "",
        val about: String = "",
        val whyBbp: String = "",
        val contacts: String = ""
) {}
