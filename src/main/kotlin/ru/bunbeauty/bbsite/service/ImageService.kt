package ru.bunbeauty.bbsite.service

import com.google.firebase.cloud.StorageClient
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class ImageService {
    fun findImageByName(name: String): ByteArray? {
        val imageUrl = StorageClient.getInstance().bucket()[name].signUrl(14,TimeUnit.DAYS)
        val inputStream = imageUrl.openStream()
        val byteArr = inputStream.readBytes()
        inputStream.close()
        return byteArr
    }

}
