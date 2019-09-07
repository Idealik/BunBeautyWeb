package ru.bunbeauty.bbsite.controller

import org.apache.commons.io.IOUtils
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import ru.bunbeauty.bbsite.service.ImageService
import java.io.ByteArrayInputStream
import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping("/image")
class ImageController(private val imageService: ImageService) {

    @GetMapping("{name}")
    fun getValidate(@PathVariable name: String, response: HttpServletResponse) {
        print("image")
        response.setContentType(MediaType.IMAGE_JPEG_VALUE)
        IOUtils.copy(ByteArrayInputStream(imageService.findImageByName(name)), response.outputStream)
    }
}