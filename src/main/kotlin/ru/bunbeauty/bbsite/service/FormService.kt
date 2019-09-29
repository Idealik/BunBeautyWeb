package ru.bunbeauty.bbsite.service

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import org.springframework.stereotype.Service
import ru.bunbeauty.bbsite.model.Master
import java.util.logging.Logger
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*
import javax.servlet.http.HttpServletRequest
import kotlin.collections.HashMap


@Service
class FormService(private val databaseReference: DatabaseReference) {

    private val log = Logger.getLogger(FormService::class.java.name)

    val NAME = "name"
    val PHONE = "phone"
    val ACTIVITY_KIND = "activity kind"
    val ABOUT = "about"
    val WHY_BBP = "why bbp"
    val CONTACTS = "contacts"

    fun saveData(master: Master, count: Long) {
        var formRef = databaseReference.child("Closed BBP request")
        val items = HashMap<String, Any>()
        items[NAME] = master.masterName
        items[PHONE] = master.phone
        items[ACTIVITY_KIND] = master.activityKind
        items[ABOUT] = master.about
        items[WHY_BBP] = master.whyBbp
        items[CONTACTS] = master.contacts

        val serviceId = formRef.push().key
        formRef = formRef.child(serviceId)
        formRef.updateChildren(items, null)

        log.info("Closed request was created  - master name: ${master.masterName}, phone : ${master.phone}, activity kind : ${master.activityKind}, " +
                "about : ${master.about}, whyBbp : ${master.whyBbp}, contacts : ${master.contacts}")
    }

    fun saveMaster(master: Master) {
        val ip = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes)
                .request.remoteAddr.toString().replace(".", " ")

        val ipRef = databaseReference.child("ip addresses").child(ip)

        ipRef.addListenerForSingleValueEvent(
                object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.value != null) {
                            var count = dataSnapshot.value as Long
                            if (count < 3) {
                                saveData(master, count)
                                ipRef.setValueAsync(++count)
                            } else {
                                log.info("Too many requests from $ip")
                            }
                        } else {
                            saveData(master, 1)
                            ipRef.setValueAsync(1)
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {}
                }
        )
    }

}
