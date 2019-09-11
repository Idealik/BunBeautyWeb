package ru.bunbeauty.bbsite

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream
import javax.annotation.PostConstruct

@Configuration
class FirebaseConfig {

    @Bean
    fun firebaseDatabase(): DatabaseReference {
        return FirebaseDatabase.getInstance().reference
    }
    @PostConstruct
    fun init() {
        /**
         * https://firebase.google.com/docs/server/setup
         *
         * Create service account , download json
         */
        val serviceAccount = FileInputStream("F:\\Extra\\Apps\\bbsite\\src\\main\\resources\\bunbeautyweb-firebase-admin-sdk.json")

        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://bunbeautyweb.firebaseio.com")
                .setStorageBucket("bunbeautyweb.appspot.com")
                .build()

        FirebaseApp.initializeApp(options)
    }
}