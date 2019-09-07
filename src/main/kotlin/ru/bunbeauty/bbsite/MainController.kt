package ru.bunbeauty.bbsite

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/")
class MainController {

    @GetMapping("")
    fun getMain(model : Model) : String {
        return "main"
    }

    @GetMapping("/form")
    fun getForm(model : Model) : String {
        return "form"
    }

}