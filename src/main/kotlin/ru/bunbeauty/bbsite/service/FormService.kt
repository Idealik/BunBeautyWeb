package ru.bunbeauty.bbsite.service

import com.google.firebase.database.DatabaseReference
import org.springframework.stereotype.Service
import ru.bunbeauty.bbsite.model.Master

@Service
class FormService(private val databaseReference: DatabaseReference) {
    val NAME = "name"
    val PHONE = "phone"
    val ACTIVITY_KIND = "activity kind"
    val ABOUT = "about"
    val WHY_BBP = "why bbp"
    val CONTACTS = "contacts"

    fun saveData(master: Master) {
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
        formRef.updateChildren(items,null)
    }

}
