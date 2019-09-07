package ru.bunbeauty.bbsite.model

import org.springframework.lang.Nullable

class Master(
        @Nullable
        val id: String = "",
        val masterName: String = "",
        val phone: String = "",
        val activityKind: String = "",
        val about: String = "",
        val whyBbp: String = "",
        val contacts: String = ""
) {
        override fun toString() : String {
                return "Master( id=$id, " +
                        "masterName=$masterName, " +
                        "phone=$phone, " +
                        "activityKind=$activityKind, " +
                        "about=$about, " +
                        "whyBbp=$whyBbp, " +
                        "contacts=$contacts)"
        }
}
