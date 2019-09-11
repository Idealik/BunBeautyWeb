package ru.bunbeauty.bbsite.service

import com.google.firebase.cloud.StorageClient
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit


@Service
class ImageService {
    fun findImageByName(name: String): ByteArray? {
        val url = StorageClient.getInstance().bucket()["main.png"].signUrl(14, TimeUnit.DAYS)

        var stream = url.openStream()
        return stream.readBytes()

        return null
    }

}
