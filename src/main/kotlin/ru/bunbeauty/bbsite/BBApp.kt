package ru.bunbeauty.bbsite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BBApp

fun main(args: Array<String>) {
    runApplication<BBApp>(*args)
}
