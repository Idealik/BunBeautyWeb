package ru.bunbeauty.bbsite.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.bunbeauty.bbsite.model.Master
import ru.bunbeauty.bbsite.service.FormService

@Controller
@RequestMapping("/")
class MainController(private val formService : FormService) {

    @GetMapping("")
    fun getMain(model : Model) : String {
        return "main"
    }

    @GetMapping("/form")
    fun getForm(model : Model) : String {
        return "form"
    }

    @PostMapping("/form")
    fun saveForm(model : Model, @ModelAttribute master: Master) : String {
        formService.saveData(master)
        return "success"
    }

}