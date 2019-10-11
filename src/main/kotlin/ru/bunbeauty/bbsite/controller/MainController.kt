package ru.bunbeauty.bbsite.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import ru.bunbeauty.bbsite.model.Master
import ru.bunbeauty.bbsite.service.FormService
import java.util.logging.Logger

@Controller
@RequestMapping("/")
class MainController(private val formService : FormService) {
    private val log = Logger.getLogger(FormService::class.java.name)
    private var i: Int = 0
    private var ipSet: MutableSet<String> = mutableSetOf()

    @GetMapping("")
    fun getMain(model : Model) : String {

        val ip = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes)
                .request.remoteAddr.toString()
        ipSet.add(ip)
        if (ipSet.size > i) {
            log.info("${++i}")
        }
        return "main"
    }

    @GetMapping("/form")
    fun getForm(model : Model) : String {
        return "form"
    }

    @PostMapping("/form")
    fun saveForm(model : Model, @ModelAttribute master: Master) : String {
        formService.saveMaster(master)
        return "success"
    }

}